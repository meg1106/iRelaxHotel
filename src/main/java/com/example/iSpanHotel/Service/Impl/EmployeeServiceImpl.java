package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Dao.EmployeeDao;
import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;
import com.example.iSpanHotel.model.Employee;
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
				employee.setName(employeeDto.getRealName());
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
			employee.setName(employeeDto.getRealName());
			employeeDao.save(employee);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findAll();
		return employees;
	}
	
	@Override
	public Employee findByName(String name) {
		Optional<Employee> employee = employeeDao.findByName(name);
		return employee.get();
	}
	
	@Override
	public String login(HttpSession session, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
