package com.example.iSpanHotel.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.EmployeeDao;
import com.example.iSpanHotel.Dto.EmployeeDto;
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
				employee.setPasswd(employeeDto.getPasswd());
				employee.setRealName(employeeDto.getRealName());
				employee.setPermissions(employeeDto.getPermissions());
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
	public String delete(EmployeeDto employeeDto) {
		try {
			employeeDao.deleteById(employeeDto.getId());
			return "帳號刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
//			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String update(EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			employee.setId(employeeDto.getId());
			employee.setAccount(employeeDto.getAccount());
			employee.setPasswd(employeeDto.getPasswd());
			employee.setRealName(employeeDto.getRealName());
			employeeDao.save(employee);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String findAll(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employeeDao.findAll();
		return null;
	}

	@Override
	public String login(HttpSession session, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
