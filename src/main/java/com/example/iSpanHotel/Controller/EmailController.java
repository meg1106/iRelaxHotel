package com.example.iSpanHotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	// Sending a simple Email
//    @PostMapping("/send")
//    public String
//    sendMail(@RequestBody EmailDto emailDto)
//    {
//        String status
//            = emailService.sendSimpleMail(emailDto);
// 
//        return status;
//    }
 
    // Sending email with attachment
    @PostMapping("/sendWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDto emailDto)
    {
        String status
            = emailService.sendMailWithAttachment(emailDto);
 
        return status;
    }
}
