package com.example.iSpanHotel.Controller;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Class.Cookies;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody MemberDto memberDto) {
		String result = memberService.create(memberDto);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		memberService.delete(id);
		return ResponseEntity.ok("刪除成功");
	}

	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody MemberDto memberDto, HttpServletResponse response) {
		try {
			String token = memberService.update(id, memberDto);
			if (token != "err") {
				Cookies.setCookies(token, response);
				return ResponseEntity.ok("修改成功！");
			}
			return ResponseEntity.ok("修改失敗！");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}

	@GetMapping("/")
	private List<Member> findAll() {
		List<Member> members = memberService.findAll();
		return members;
	}

	@GetMapping("/{id}")
	private ResponseEntity<Member> findById(@PathVariable Long id) {
		Member member = memberService.findById(id);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@GetMapping("/checkLogin")
	private ResponseEntity<String> checkLogin(@CookieValue(value = "UID", defaultValue = "Atta")String token) {
		JSONObject jsonObject = new JSONObject();
		String jsonString = null;
			try {
				jsonObject = memberService.checkLogin(token);
				jsonString = jsonObject.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return ResponseEntity.ok(jsonString);
	}

	@PostMapping("/login")
	private ResponseEntity<String> login(String account, String passwd, HttpServletResponse response) {
		try {
			String token = memberService.login(account, passwd);
			if (token != "err") {
				Cookies.setCookies(token, response);
				return ResponseEntity.ok("登入成功！");
			}
			return ResponseEntity.ok("帳號或密碼錯誤，請重新輸入！");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	
	@PostMapping("/logout")
	private ResponseEntity<String> logout(@CookieValue(value = "UID")String token, HttpServletResponse response) {
		try {
			Cookies.removeCookies(response);
			return ResponseEntity.ok("登出成功");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping("/forgot_password")
	private ResponseEntity<String> processForgotPassword(HttpServletRequest request, @RequestBody MemberDto memberDto) {
		String result = emailService.processForgotPassword(request, memberDto);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/reset_password")
	public ResponseEntity<String> processResetPassword(HttpServletRequest request, @RequestBody MemberDto memberDto) {
		String result = memberService.processResetPassword(request, memberDto);
	    return ResponseEntity.ok(result);
	}
	
	@PostMapping("/checkEmail")
	private ResponseEntity<String> checkEmail(@RequestBody MemberDto memberDto) {
		String result = emailService.sendCheckEmail(memberDto);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/googleLogin")
	private ResponseEntity<String> googleLogin(@RequestBody MemberDto memberDto, HttpServletResponse response){
		try {
			String token = memberService.googleLogin(memberDto);
			System.out.println(token);
			if (token != "err") {
				Cookies.setCookies(token, response);
				return ResponseEntity.ok("登入成功！");
			}
			return ResponseEntity.ok("此Google信箱已使用過，請使用一般登入！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
