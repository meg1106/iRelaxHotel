package com.example.iSpanHotel.Dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.iSpanHotel.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

	Integer countByAccount(String account);

	Optional<Employee> findByName(String name);

	Employee findByAccount(String account);
	
	@Query(value = "select * from  user where  name like %?1%",nativeQuery = true)
	Page<Employee> findNameLike(String name, Pageable pageRequest);
}
