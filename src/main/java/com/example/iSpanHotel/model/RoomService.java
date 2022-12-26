package com.example.iSpanHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roomservice")
public class RoomService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "room_number", nullable = false, unique = true)
	private String roomNum;
	
	@Column(name = "room_status", nullable = false, unique = false)
	private short roomStatus;
	
	@Column(name = "note", nullable = true, unique = false)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "roomtype_id", nullable = false, unique = false)
	private RoomType roomType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public short getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(short roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "RoomService [id=" + id + ", roomNum=" + roomNum + ", roomStatus=" + roomStatus + ", note=" + note
				+ ", roomType=" + roomType + "]";
	}
}
