package com.example.iSpanHotel.Dto;

public class MemberDto {
	private Long id;
	private String account;
	private String passwd;
	private String realName;
	private String email;
	private String tel;
	private String resetPasswordToken;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", account=" + account + ", passwd=" + passwd + ", realName=" + realName
				+ ", email=" + email + ", tel=" + tel + ", resetPasswordToken=" + resetPasswordToken + "]";
	}
	
	
}
