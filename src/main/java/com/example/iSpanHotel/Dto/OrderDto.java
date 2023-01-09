package com.example.iSpanHotel.Dto;

import com.example.iSpanHotel.model.Member;

public class OrderDto {
	private Long id;
	private Member member;
	private String orderDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", member=" + member + ", orderDate=" + orderDate + "]";
	}
	
}
