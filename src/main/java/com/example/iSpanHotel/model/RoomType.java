package com.example.iSpanHotel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roomtype")
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "roomtype", nullable = false)
	private String roomType;
	
	@Column(name = "roomprice", nullable = false)
	private Integer roomPrice;
	
	@Column(name = "roomperson", nullable = false)
	private Integer roomPerson;
	
	@Column(name = "roompic")
	private String roomPic;
	
	@Column(name = "content")
	private String content;
	
	@JsonIgnoreProperties({"roomType"})
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "roomType")
	private List<Room> rooms;

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

	public Integer getRoomPerson() {
		return roomPerson;
	}

	public void setRoomPerson(Integer roomPerson) {
		this.roomPerson = roomPerson;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
