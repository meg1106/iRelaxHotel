package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

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
	private Boolean checkLogin(String token) {
		Boolean request = memberService.checkLogin(token);
		return request;
	}

	@PostMapping("/login")
	private String login(String account, String passwd) {
		System.out.println("有連到api");
		String check = memberService.login(account, passwd);
		System.out.println(check);
		return check;
	}

	@PostMapping("/forgot_password")
	private ResponseEntity<String> processForgotPassword(HttpServletRequest request, @RequestBody MemberDto memberDto) {
		String result = emailService.processForgotPassword(request, memberDto);
		return ResponseEntity.ok(result);
	}

	public void sendEmail(String recipient, String link)
	        throws Exception {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("nienfxxq@gmail.com", "iRelaxHotel");
	    helper.setTo(recipient);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
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
