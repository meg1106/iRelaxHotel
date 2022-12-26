package com.example.iSpanHotel.Service;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Service
public interface MemberService {

	// 創建會員帳號
	String create(MemberDto memberDto);

	// 刪除會員帳號
	String delete(MemberDto memberDto);

	// 修改會員帳號
	String update(MemberDto memberDto);

	// 查詢所有會員帳號
	String findAll(MemberDto memberDto);

	// 會員帳號登入
	String login(HttpSession session, String username, String password);

}
