package com.example.iSpanHotel.Service.Impl;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.CheckEmailUtils;
import com.example.iSpanHotel.Class.UrlUtility;
import com.example.iSpanHotel.Dao.CheckEmailDao;
import com.example.iSpanHotel.Dao.ItemDao;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dto.EmailDto;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Dto.PaymentDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.model.CheckEmail;
import com.example.iSpanHotel.model.Member;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private CheckEmailDao checkEmailDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Value("${spring.mail.username}")
	private String sender;

	public String sendOrderDetail(PaymentDto paymentDto) {
		String tradeNo = paymentDto.getMerchantTradeNo();
		Long oid = Long.parseLong(tradeNo.substring(18));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); 
		String name = orderDao.findById(oid).get().getMember().getRealName();
		String email = orderDao.findById(oid).get().getMember().getAccount();
		String checkin = sdf.format(itemDao.findById(oid).get().getCheckinDate());
		String checkout = sdf.format(itemDao.findById(oid).get().getCheckoutDate());
		String roomType = itemDao.findById(oid).get().getRoom().getRoomType().getRoomType();
		Integer floor = itemDao.findById(oid).get().getRoom().getRoomFloor();
		String roomNum = itemDao.findById(oid).get().getRoom().getRoomNum();
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setText("親愛的會員 " + name + " 先生/小姐您好，以下為您的訂房資訊：\n入住時間：" + checkin + " 下午4時\n退房時間：" + checkout
					+ " 上午11時\n房型：" + roomType + "\n樓層及房號：" + floor + "樓 " + roomNum + "號房\n\n如有任何問題，歡迎來電：02-34567890\n\niRelax Hotel期待您的光臨！");
			mailMessage.setSubject("訂房通知");
			javaMailSender.send(mailMessage);
			return "信件發送成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "信件發送失敗";
		}
	}

	public String sendContactUs(EmailDto emailDto) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(sender);
			mailMessage.setText(emailDto.getMsgBody());
			mailMessage.setSubject(emailDto.getSubject());
			javaMailSender.send(mailMessage);
			return "謝謝您的來信，我們會盡快回覆您！";
		} catch (Exception e) {
			return "信件發送失敗，請稍候再試。";
		}
	}

	@Override
	public String processForgotPassword(HttpServletRequest request, MemberDto memberDto) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String account = memberDto.getAccount();
		String token = RandomString.make(30);
		Member member = memberDao.findByEmail(account);
		if (member != null) {
			member.setResetPasswordToken(token);
			memberDao.save(member);
		} else {
			return "找不到此Email";
		}
		try {
			String resetPasswordLink = UrlUtility.getSiteURL(request) + "/frontend/change_password.html?token=" + token;
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(account);
			mimeMessageHelper.setText("<p>您好</p>" + "<p>您申請了忘記密碼服務</p>" + "<p>請點擊下方的連結以更改密碼：</p>" + "<p><a href=\""
					+ resetPasswordLink + "\">更改我的密碼</a></p>" + "<br>" + "<p>如您沒有申請此服務或是已想起密碼，請忽略本信件，謝謝。</p>"
					+ "<p>iRelax Hotel</p>", true);
			mimeMessageHelper.setSubject("iRelax Hotel 會員密碼重置信件");
			javaMailSender.send(mimeMessage);
			return "iRelax Hotel已將密碼重置信件寄到您的信箱，請至信箱確認，謝謝。";
		} catch (MessagingException e) {
			return "信件發送失敗";
		}
	}

	@Override
	public String sendCheckEmail(MemberDto memberDto) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		String email = memberDto.getAccount();
		String code = CheckEmailUtils.VerifyCode(6);
		Member member = memberDao.findByEmail(email);
		CheckEmail McheckEmail = checkEmailDao.findByEmail(email);
		if (member == null) {
			if (McheckEmail == null) {
				CheckEmail checkEmail = new CheckEmail();
				checkEmail.setEmail(email);
				checkEmail.setCode(code);
				checkEmailDao.save(checkEmail);
			}else {
				McheckEmail.setCode(code);
				checkEmailDao.save(McheckEmail);
			}
		} else {
			return "此信箱已使用！";
		}
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setText("<p>您好</p>" + "<p>您申請的會員註冊驗證6碼數字如下：</p>" + "<p>" + code + "</p>" + "<br>"
					+ "<p>如您沒有申請此服務請忽略本信件，謝謝。</p>" + "<p>iRelax Hotel</p>", true);
			mimeMessageHelper.setSubject("iRelax Hotel 會員註冊驗證碼");
			javaMailSender.send(mimeMessage);
			return "驗證碼已寄出！";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "伺服器忙碌中，請稍候重試！";
		}
	}
}
