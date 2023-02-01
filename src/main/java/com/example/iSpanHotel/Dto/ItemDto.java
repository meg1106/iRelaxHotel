package com.example.iSpanHotel.Dto;

public class ItemDto {
	private Long id;
	private Long order_id;
	private Long room_id;
	private String checkinDate;
	private String checkoutDate;
	private Short status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", order_id=" + order_id + ", room_id=" + room_id + ", checkinDate=" + checkinDate
				+ ", checkoutDate=" + checkoutDate + ", status=" + status + "]";
	}
	
}
