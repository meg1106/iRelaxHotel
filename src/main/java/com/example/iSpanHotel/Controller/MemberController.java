package com.example.iSpanHotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/create")
	private String create(@RequestBody MemberDto memberDto) {
		String message = memberService.create(memberDto);
		
		return message;
	}
	
	@PostMapping("/login")
	private void login(HttpSession session) {
		
	}
}
