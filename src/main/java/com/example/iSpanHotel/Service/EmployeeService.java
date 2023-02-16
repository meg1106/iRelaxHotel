package com.example.iSpanHotel.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.model.Employee;

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
	
	// 分頁查詢
	Page<Employee> findByPaging(int page, int rows);

	// 依姓名查詢
	Page<Employee> findNameLike(int page, int rows, String name);
	
	// 獲取員工總數
	Long countTotal();
	
	// 根據姓名查詢員工
	Employee findByName(String name);

	// 登入token驗證
	Boolean checkLogin(String token);

	// 登入驗證
	String login(HttpSession session, String account, String password);

}
