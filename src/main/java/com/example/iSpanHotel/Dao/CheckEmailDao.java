package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.iSpanHotel.model.CheckEmail;

import jakarta.transaction.Transactional;

public interface CheckEmailDao extends JpaRepository<CheckEmail, Long>{
	
	@Query("SELECT c FROM CheckEmail c WHERE c.email = ?1")
	CheckEmail findByEmail(String email); 
	
	@Modifying
	@Transactional
	@Query(name = "deleteByEmail", nativeQuery = true, value = "delete from `check_email` where email=:email")
	void deleteByEmail(@Param("email") String email);
}
