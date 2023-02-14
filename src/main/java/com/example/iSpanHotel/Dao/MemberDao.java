package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.iSpanHotel.model.Member;

public interface MemberDao extends JpaRepository<Member, Long>{
	
	Integer countByAccount(String account);
	
//	Integer countByEmail(String email);
	
	Member findByAccount(String account);
	
	@Query("SELECT c FROM Member c WHERE c.account = ?1")
    Member findByEmail(String account); 
    
	@Query("SELECT c FROM Member c WHERE c.resetPasswordToken = ?1")
    Member findByResetPasswordToken(String token);
	
	@Query("SELECT c FROM Member c WHERE c.googleLoginId = ?1")
	Member findByGoogleLoginId(String gid);
}
