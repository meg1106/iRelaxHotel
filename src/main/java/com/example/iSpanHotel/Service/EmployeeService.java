package com.example.iSpanHotel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.model.Employee;
import jakarta.servlet.http.HttpSession;

@Service
public interface EmployeeService {
	
	// 創建員工帳號
	String create(EmployeeDto employeeDto);
	
	// 刪除員工帳號
	String delete(Long id);
	
	// 修改員工帳號
	String update(Long id, EmployeeDto employeeDto);
	
	// 查詢所有員工帳號
	List<Employee> findAll();
	
	// 根據id查詢員工
	Employee findByName(String name);
	
	// 員工帳號登入 
	String login(HttpSession session,String username,String password);
	
}
