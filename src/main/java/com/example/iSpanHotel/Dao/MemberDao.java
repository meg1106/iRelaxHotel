package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.Member;

public interface MemberDao extends JpaRepository<Member, Long>{
	Integer countByAccount(String account);
}
