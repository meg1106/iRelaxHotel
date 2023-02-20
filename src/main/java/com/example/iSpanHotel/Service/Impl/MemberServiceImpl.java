package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Dao.CheckEmailDao;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private CheckEmailDao checkEmailDao;

	@Override
	public String create(MemberDto memberDto) {
		int checkAccount = memberDao.countByAccount(memberDto.getAccount());
		String code = memberDto.getCode();
		String account = memberDto.getAccount();
		String ecode = checkEmailDao.findByEmail(account).getCode();
		System.out.println(code);
		System.out.println(ecode);
		if (checkAccount == 0) {
				if (code.equals(ecode)) {
					try {
						Member member = new Member();
						member.setAccount(memberDto.getAccount());
						member.setPasswd(BCrypt.hashpw(memberDto.getPasswd(), BCrypt.gensalt()));
						member.setRealName(memberDto.getRealName());
						member.setTel(memberDto.getTel());
						memberDao.save(member);
						checkEmailDao.deleteByEmail(account);
						return "註冊成功";
					} catch (Exception e) {
						e.printStackTrace();
						return "發生未知的錯誤";
					}
				} else {
					return "信箱驗證碼錯誤";
				}
			} else {
				return "此信箱已有人使用";
			}
		 
	}

	@Override
	public String delete(Long id) {
		try {
			memberDao.deleteById(id);
			return "刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String update(Long id, MemberDto memberDto) {
		try {
			Member member = memberDao.findById(id).get();
			if (!memberDto.getPasswd().isEmpty()) {
				member.setPasswd(BCrypt.hashpw(memberDto.getPasswd(), BCrypt.gensalt()));
			}
			member.setRealName(memberDto.getRealName());
			member.setTel(memberDto.getTel());
			memberDao.save(member);
			String token = JWTutils.creatJWT(member.getId().toString(), member.toString(), null);
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			return "err";
		}
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		members = memberDao.findAll();
		return members;
	}

	@Override
	public Member findById(Long id) {
		Optional<Member> member = memberDao.findById(id);
		return member.get();
	}

	@Override
	public JSONObject checkLogin(String token) {
		JSONObject object = new JSONObject();
		// 解析JWT
		try {
			Claims claims = JWTutils.parseJWT(token);
			String userMsg = claims.getSubject();
			System.out.println(userMsg);
			object.put("status", "success");
			object.put("userMsg", new JSONObject(userMsg));
		} catch (Exception exception) {
			object.put("status", "error");
		}
		return object;
	}

	@Override
	public String login(String account, String password) {
		if (memberDao.findByAccount(account) != null) {
			Member member = memberDao.findByAccount(account);
			String pswd = member.getPasswd();
			if (BCrypt.checkpw(password, pswd)) {
				// 生成JWT
				String token = JWTutils.creatJWT(member.getId().toString(), member.toString(), null);
				return token;
			} else {
				return "err";
			}
		} else {
			return "err";
		}
	}

	@Override
	public Member getByResetPasswordToken(String token) {
		return memberDao.findByResetPasswordToken(token);
	}

	@Override
	public String processResetPassword(HttpServletRequest request, MemberDto memberDto) {
		String token = request.getParameter("token");
		String passwd = memberDto.getPasswd();
		System.out.println(passwd);
		System.out.println(token);
		Member member = memberDao.findByResetPasswordToken(token);
		if (member == null) {
			return "驗證碼錯誤，請重新申請連結！";
		} else {
			member.setPasswd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
			member.setResetPasswordToken(null);
			memberDao.save(member);
			return "密碼修改成功，請重新登入！";
		}
	}

	@Override
	public String googleLogin(MemberDto memberDto) {
		String name = memberDto.getRealName();
		String account = memberDto.getAccount();
		String gid = memberDto.getGoogleLoginId();
		Member member = memberDao.findByEmail(account);
		if (member == null) {
			Member gMember = new Member();
			gMember.setRealName(name);
			gMember.setAccount(account);
			gMember.setGoogleLoginId(gid);
			memberDao.save(gMember);
			String token = JWTutils.creatJWT(gMember.getId().toString(), gMember.toString(), null);
			return token;
		} else {
			String token = JWTutils.creatJWT(member.getId().toString(), member.toString(), null);
			return token;
		} 
	}
}
