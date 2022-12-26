package com.example.iSpanHotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	private String create(@RequestBody EmployeeDto employeeDto) {

		return "成功";
	}
	
	@PostMapping("/login")
	private void login(HttpSession session) {
		
	}
	
	
	
}
