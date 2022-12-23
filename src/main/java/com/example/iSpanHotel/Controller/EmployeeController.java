package com.example.iSpanHotel.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmployeeDto;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@PostMapping("/create")
	private String create(@RequestBody EmployeeDto employeeDto) {
		
		
		return "成功";
	}
	
	@PostMapping("/login")
	private void login(HttpSession session) {
		
	}
	
	
	
}
