package com.example.iSpanHotel.Service;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.model.Item;

@Service
public interface EmailService {
	
	// Method
    // To send a simple email
    String sendSimpleMail(OrderDto orderDto, Item item);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDto details);
}
