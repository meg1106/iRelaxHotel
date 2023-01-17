package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.model.Member;

import jakarta.servlet.http.HttpSession;

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
	public String login(HttpSession session, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
