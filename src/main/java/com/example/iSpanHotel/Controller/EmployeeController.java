package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;
import com.example.iSpanHotel.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	private List<Employee> findAll() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}
	
	@GetMapping("/{page}/{rows}")
	private List<Employee> findAll(@PathVariable int page, @PathVariable int rows) {
		List<Employee> employees = employeeService.findByPaging(page, rows);
		return employees;
	}

	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody EmployeeDto employeeDto) {
		employeeService.create(employeeDto);
		return ResponseEntity.ok("員工帳號創建成功");
	}

	@GetMapping("/{name}")
	private ResponseEntity<Employee> findByName(@PathVariable String name) {
		Employee employee = employeeService.findByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
		employeeService.update(id, employeeDto);
		return ResponseEntity.ok("員工帳號修改成功");
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok("員工帳號刪除成功");
	}

	@PostMapping("/login")
	private String login(String account, String passwd) {
		System.out.println("有連到api");
		String check = employeeService.login(account, passwd);
		System.out.println(check);
		return check;
	}

}
