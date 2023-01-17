package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import io.jsonwebtoken.Claims;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public String create(MemberDto memberDto) {
		int checkAccount = memberDao.countByAccount(memberDto.getAccount());
		int checkEmail = memberDao.countByEmail(memberDto.getEmail());

		if (checkAccount == 0) {
			if (checkEmail == 0) {
				try {
					Member member = new Member();
					member.setAccount(memberDto.getAccount());
					member.setPasswd(BCrypt.hashpw(memberDto.getPasswd(), BCrypt.gensalt()));
					member.setRealName(memberDto.getRealName());
					member.setEmail(memberDto.getEmail());
					member.setTel(memberDto.getTel());
					memberDao.save(member);
					return "註冊成功";
				} catch (Exception e) {
					e.printStackTrace();
					return "發生未知的錯誤";
				}
			}else {
				return "此信箱已有人使用";
			}
		} else {
			return "此帳號已有人使用";
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
			Member member = new Member();
			member.setId(id);
			member.setAccount(memberDto.getAccount());
			member.setPasswd(BCrypt.hashpw(memberDto.getPasswd(), BCrypt.gensalt()));
			member.setRealName(memberDto.getRealName());
			member.setEmail(memberDto.getEmail());
			member.setTel(memberDto.getTel());
			memberDao.save(member);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
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
	public Boolean checkLogin(String token) {
		// 解析JWT
		try {
			Claims claims = JWTutils.parseJWT(token);
			System.out.println("解析成功" + claims.getSubject());
			return true;
		} catch (Exception exception) {
			System.out.println("解析失敗:");
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public String login(String account, String password) {
		if(memberDao.findByAccount(account) != null) {
			Member member = memberDao.findByAccount(account);
			String pswd = member.getPasswd();
			if (BCrypt.checkpw(password,pswd)) {
				// 生成JWT
				String token = JWTutils.creatJWT(member.getId().toString(),member.toString(), null);
				System.out.println("生成token=:" + token);
				return token;
			}else {
				System.out.println("找不到密碼");
				return "帳號或密碼錯誤";
			}
		}else {
			System.out.println("找不到帳號");
			return "帳號或密碼錯誤";
		}	
	}

}
