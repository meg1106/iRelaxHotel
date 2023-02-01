package com.example.iSpanHotel.Service.Impl;

import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.model.Item;
import java.io.File;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private MemberDao memberDao;

	@Value("${spring.mail.username}")
	private String sender;

	// Method 1
	// To send a simple email
	public String sendSimpleMail(OrderDto orderDto, Item item) {

		String name = memberDao.findById(orderDto.getMember()).get().getRealName();
		String checkin = item.getCheckinDate();
		String checkout = item.getCheckoutDate();
		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(memberDao.findById(orderDto.getMember()).get().getEmail());
			mailMessage.setText("親愛的會員 " + name + " 先生/小姐您好，以下為您的訂房資訊：\n入住時間：" + checkin + " 下午4時\n退房時間：" + checkout
					+ " 上午11時\n\n如有任何問題，歡迎來電：02-34567890\n\niRelax Hotel期待您的光臨！");
			mailMessage.setSubject("訂房通知");

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "信件發送成功";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			e.printStackTrace();
			return "信件發送失敗";
		}
	}

	// Method 2
	// To send an email with attachment
	public String sendMailWithAttachment(EmailDto emailDto) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDto.getRecipient());
			mimeMessageHelper.setText(emailDto.getMsgBody());
			mimeMessageHelper.setSubject(emailDto.getSubject());

			// Adding the attachment
			FileSystemResource file = new FileSystemResource(new File(emailDto.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "信件發送成功";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "信件發送失敗";
		}
	}
}
