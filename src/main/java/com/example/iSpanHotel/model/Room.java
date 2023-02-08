package com.example.iSpanHotel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_num", nullable = false, unique = true)
	private String roomNum;
	
	@Column(name = "room_floor", nullable = false)
	private Integer roomFloor;
	
	@Column(name = "room_status", nullable = false)
	private Short roomStatus = 1;
	
	@Column(name = "note")
	private String note;
	
	@JsonIgnoreProperties({"rooms"})
	@ManyToOne
	@JoinColumn(name = "roomtype_id", nullable = false)
	private RoomType roomType;
	
	@JsonIgnoreProperties({"room"})
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "room")
	private List<Item> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public Integer getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(Integer roomFloor) {
		this.roomFloor = roomFloor;
	}

	public Short getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(Short roomStatus) {
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
