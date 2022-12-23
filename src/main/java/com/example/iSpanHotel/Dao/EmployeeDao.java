package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	

}
