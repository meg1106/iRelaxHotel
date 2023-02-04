package com.example.iSpanHotel.Controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
    private JavaMailSender mailSender;

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
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@GetMapping("/checkLogin")
	private ResponseEntity<String> checkLogin(@CookieValue(value = "UID", defaultValue = "Atta")String token) {
		JSONObject jsonObject = new JSONObject();
		String object;
		try {
			jsonObject = memberService.checkLogin(token);
			object = jsonObject.toString();
		} catch (Exception e) {
			jsonObject.append("status", "error");
			jsonObject.append("userMsg", null);
			object = jsonObject.toString();
		}		
		return ResponseEntity.ok(object);
	}

	@PostMapping("/login")
	private ResponseEntity<String> login(String account, String passwd, HttpServletResponse response) {
		try {
			String token = memberService.login(account, passwd);
			System.out.println(token);
			if (token != "err") {
				Cookies.setCookies(token, response);
				return ResponseEntity.ok(token);
			}
			return ResponseEntity.ok("帳號或密碼錯誤");
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

	@GetMapping("/reset_password")
	public ResponseEntity<String> showResetPasswordForm(@Param(value = "token") String token) {
	    Member member = memberService.getByResetPasswordToken(token);
	    if (member == null) {
	        return ResponseEntity.ok("驗證碼錯誤");
	    }
	     
	    return ResponseEntity.ok("請更改密碼");
	}
	
	@PostMapping("/reset_password")
	public ResponseEntity<String> processResetPassword(HttpServletRequest request, @RequestBody MemberDto memberDto) {
		String result = memberService.processResetPassword(request, memberDto);
	    return ResponseEntity.ok(result);
	}
}
