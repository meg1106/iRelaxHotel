package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Dao.EmployeeDao;
import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;
import com.example.iSpanHotel.model.Employee;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpSession;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String create(EmployeeDto employeeDto) {
		int checkAccount = employeeDao.countByAccount(employeeDto.getAccount());
		if (checkAccount == 0) {
			try {
				Employee employee = new Employee();
				employee.setAccount(employeeDto.getAccount());
				employee.setPasswd(BCrypt.hashpw(employeeDto.getPasswd(), BCrypt.gensalt()));
				employee.setName(employeeDto.getName());
				employeeDao.save(employee);
				return "註冊成功";
			} catch (Exception e) {
				e.printStackTrace();
//				throw new RuntimeException(e.getMessage());
				return "發生未知的錯誤";
			}
		}else {
			return "此帳號已有人使用";
		}
	}

	@Override
	public String delete(Long id) {
		try {
			employeeDao.deleteById(id);
			return "帳號刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
//			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String update(Long id, EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setAccount(employeeDto.getAccount());
			employee.setPasswd(BCrypt.hashpw(employeeDto.getPasswd(), BCrypt.gensalt()));
			employee.setName(employeeDto.getName());
			employeeDao.save(employee);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findAll();
		return employees;
	}
	
	@Override
	public Page<Employee> findByPaging(int page, int rows) {
//		List<Employee> employees = new ArrayList<>();
		Page<Employee> pageResult = employeeDao.findAll(PageRequest.of(page, rows,Sort.by("id")));
//		employees = pageResult.getContent();
		return pageResult;
	}
	
	@Override
	public Page<Employee> findNameLike(int page, int rows, String name) {
		Page<Employee> pageResult = employeeDao.findNameLike(name, PageRequest.of(page, rows,Sort.by("id")));
		return pageResult;
	}
	
	@Override
	public Long countTotal() {
		Long count = employeeDao.count();
		return count;
	}
	
	@Override
	public Employee findByName(String name) {
		Optional<Employee> employee = employeeDao.findByName(name);
		return employee.get();
	}

	@Override
	public Boolean checkLogin(String token) {
		try {
			Claims claims = JWTutils.parseJWT(token);
			System.out.println("解析成功" + claims.getSubject());
			return true;
		} catch (Exception exception) {
			System.out.println("解析失敗:");
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public String login(HttpSession session, String account, String password) {
		if(employeeDao.findByAccount(account) != null) {
			Employee employee = employeeDao.findByAccount(account);
			String pswd = employee.getPasswd();
			if (BCrypt.checkpw(password,pswd)) {
				session.setAttribute("login", true);
				session.setAttribute("id", employee.getId());
				session.setAttribute("account", employee.getAccount());
				session.setAttribute("name", employee.getName());		
				return "登入成功";
			}else {
				return "帳號或密碼錯誤";
			}
		}else {
			return "帳號或密碼錯誤";
		}
	}

}
