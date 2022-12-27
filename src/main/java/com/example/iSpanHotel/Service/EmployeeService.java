package com.example.iSpanHotel.Service;

import com.example.iSpanHotel.Dto.EmployeeDto;

import jakarta.servlet.http.HttpSession;

public interface EmployeeService {
	
	// 創建員工帳號
	String create(EmployeeDto employeeDto);
	
	// 刪除員工帳號
	String delete(EmployeeDto employeeDto);
	
	// 修改員工帳號
	String update(EmployeeDto employeeDto);
	
	// 查詢所有員工帳號
	String findAll(EmployeeDto employeeDto);
	
	// 員工帳號登入 
	String login(HttpSession session,String username,String password);
	
}
