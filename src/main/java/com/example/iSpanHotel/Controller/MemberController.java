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

import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody MemberDto memberDto) {
		memberService.create(memberDto);
		return ResponseEntity.ok("創建成功");
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		memberService.delete(id);
		return ResponseEntity.ok("刪除成功");
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody MemberDto memberDto) {
		memberService.update(id, memberDto);
		return ResponseEntity.ok("修改成功");
	}
	
	@GetMapping("/")
	private List<Member> findAll() {
		List<Member> members = memberService.findAll();
		return members;
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Member> findById(@PathVariable Long id) {
		Member member = memberService.findById(id);
		return new ResponseEntity<>(member,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	private void login(HttpSession session) {
		
	}
}
