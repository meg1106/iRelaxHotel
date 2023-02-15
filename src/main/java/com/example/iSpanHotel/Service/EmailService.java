package com.example.iSpanHotel.Service;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Dto.PaymentDto;
import jakarta.servlet.http.HttpServletRequest;

@Service
public interface EmailService {
	
	// 發送訂房資訊信件
    String sendOrderDetail(PaymentDto paymentDto);
 
    // 發送聯絡我們信件
    String sendContactUs(EmailDto emailDto);
    
    // 發送重置密碼信件
    String processForgotPassword(HttpServletRequest request, MemberDto memberDto);
    
    // 發送註冊信箱驗證碼
    String sendCheckEmail(MemberDto memberDto);
}
