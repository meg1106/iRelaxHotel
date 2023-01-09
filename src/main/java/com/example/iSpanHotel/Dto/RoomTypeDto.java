package com.example.iSpanHotel.Dto;

public class RoomTypeDto {
	private Long id;
	private String roomType;
	private Integer roomPrice;
	private String roomPic;
	private String content;
	private Integer roomPerson; 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomPic() {
		return roomPic;
	}
	public void setRoomPic(String roomPic) {
		this.roomPic = roomPic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRoomPerson() {
		return roomPerson;
	}
	public void setRoomPerson(Integer roomPerson) {
		this.roomPerson = roomPerson;
	}
	@Override
	public String toString() {
		return "RoomTypeDto [id=" + id + ", roomType=" + roomType + ", roomPrice=" + roomPrice + ", roomPic=" + roomPic
				+ ", content=" + content + ", roomPerson=" + roomPerson + "]";
	}
	
	
}
