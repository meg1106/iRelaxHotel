package com.example.iSpanHotel.Dto;

public class EmployeeDto {
	private Long id;
	private String account;
	private String passwd;
	private String name;
	private Short permissions;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Short getPermissions() {
		return permissions;
	}
	public void setPermissions(Short permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", account=" + account + ", passwd=" + passwd + ", realName=" + name
				+ ", permissions=" + permissions + "]";
	}

}
