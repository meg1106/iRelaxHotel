package com.example.iSpanHotel.Service;

import org.springframework.stereotype.Service;
import com.example.iSpanHotel.model.EmailDetails;

@Service
public interface EmailService {
	
	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
