package com.example.iSpanHotel.Dto;

public class OrderDto {
	private Long id;
	private Long member_id;
	private String orderDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMember() {
		return member_id;
	}
	public void setMember(Long member_id) {
		this.member_id = member_id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", member_id=" + member_id + ", orderDate=" + orderDate + "]";
	}
	
}
