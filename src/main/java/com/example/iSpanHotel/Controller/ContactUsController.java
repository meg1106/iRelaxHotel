package com.example.iSpanHotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Service.EmailService;

@RestController
@RequestMapping("/contactUs")
public class ContactUsController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping("")
	private ResponseEntity<String> sendContactUs(@RequestBody EmailDto emailDto){
		String result = emailService.sendContactUs(emailDto);
	    return ResponseEntity.ok(result);
	}
}
