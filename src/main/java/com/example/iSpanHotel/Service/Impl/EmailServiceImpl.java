package com.example.iSpanHotel.Service.Impl;

import com.example.iSpanHotel.Class.UrlUtility;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Member;

import java.io.File;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

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
	public String sendOrderDetail(OrderDto orderDto, Item item) {

		String name = memberDao.findById(orderDto.getMember()).get().getRealName();
		String checkin = item.getCheckinDate().toString();
		String checkout = item.getCheckoutDate().toString();
		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
//			mailMessage.setFrom("iRelaxHotel@gmail.com");
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

	@Override
	public String processForgotPassword(HttpServletRequest request, MemberDto memberDto) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String email = memberDto.getEmail();
		String token = RandomString.make(30);
		Member member = memberDao.findByEmail(email);
        if (member != null) {
        	member.setResetPasswordToken(token);
        	memberDao.save(member);
        } else {
            return "找不到此Email";
        }
        try {
        	String resetPasswordLink = UrlUtility.getSiteURL(request) + "/member/reset_password?token=" + token;
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setText("<p>您好</p>"
		            + "<p>您申請了忘記密碼服務</p>"
		            + "<p>請點擊下方的連結以更改密碼：</p>"
		            + "<p><a href=\"" + resetPasswordLink + "\">更改我的密碼</a></p>"
		            + "<br>"
		            + "<p>如您沒有申請此服務或是已想起密碼，請忽略本信件，謝謝。</p>"
		            + "<p>iRelax Hotel</p>"
//		            + "<img src='/iSpanHotel/src/main/resources/public/images/logo/logo (3).jpg'>"
		            , true);
			mimeMessageHelper.setSubject("iRelax Hotel 會員密碼重置信件");
			javaMailSender.send(mimeMessage);
			return "iRelax Hotel已將密碼重置信件寄到您的信箱，請至信箱確認，謝謝。";
		}
		catch (MessagingException e) {
			return "信件發送失敗";
		}
	}
}
