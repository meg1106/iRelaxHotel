package com.example.iSpanHotel.Dto;

public class ItemDto {
	private Long id;
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
	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", status="
				+ status + "]";
	}
	
}
