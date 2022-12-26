package com.example.iSpanHotel.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dto.MemberDto;
import com.example.iSpanHotel.model.Employee;
import com.example.iSpanHotel.model.Member;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public String create(MemberDto memberDto) {
		int checkAccount = memberDao.countByAccount(memberDto.getAccount());

		if (checkAccount == 0) {
			try {
				Member member = new Member();
				member.setAccount(memberDto.getAccount());
				member.setPasswd(memberDto.getPasswd());
				member.setRealName(memberDto.getRealName());
				member.setEmail(memberDto.getEmail());
				member.setTel(memberDto.getTel());
				memberDao.save(member);
				return "註冊成功";
			} catch (Exception e) {
				e.printStackTrace();
//				throw new RuntimeException(e.getMessage());
				return "發生未知的錯誤";
			}
		} else {
			return "此帳號已有人使用";
		}
	}

	@Override
	public String delete(MemberDto memberDto) {
		try {
			memberDao.deleteById(memberDto.getId());
			return "帳號刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
//			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String update(MemberDto memberDto) {
		try {
			Member member = new Member();
			member.setId(memberDto.getId());
			member.setAccount(memberDto.getAccount());
			member.setPasswd(memberDto.getPasswd());
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
	public String findAll(MemberDto memberDto) {
		List<Employee> members = new ArrayList<>();
		memberDao.findAll();
		return null;
	}

	@Override
	public String login(HttpSession session, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
