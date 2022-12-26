package com.example.iSpanHotel.model;

import java.util.List;

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
	
	@Column(name = "roomtype", nullable = false, unique = false)
	private String roomType;
	
	@Column(name = "roomprice", nullable = false, unique = false)
	private Integer roomPrice;
	
	@Column(name = "roompic", nullable = true, unique = false)
	private String roomPic;
	
	@Column(name = "content", nullable = true, unique = false)
	private String content;
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	private List<RoomService> roomServices;
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	private List<RoomOrder> roomOrders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomtype() {
		return roomType;
	}

	public void setRoomtype(String roomtype) {
		this.roomType = roomtype;
	}

	public Integer getRoomprice() {
		return roomPrice;
	}

	public void setRoomprice(Integer roomprice) {
		this.roomPrice = roomprice;
	}

	public String getRoompic() {
		return roomPic;
	}

	public void setRoompic(String roompic) {
		this.roomPic = roompic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<RoomService> getRoomServices() {
		return roomServices;
	}

	public void setRoomServices(List<RoomService> roomServices) {
		this.roomServices = roomServices;
	}

	public List<RoomOrder> getRoomOrders() {
		return roomOrders;
	}

	public void setRoomOrders(List<RoomOrder> roomOrders) {
		this.roomOrders = roomOrders;
	}

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", roomtype=" + roomType + ", roomprice=" + roomPrice + ", roompic=" + roomPic
				+ ", content=" + content + ", roomServices=" + roomServices + "]";
	}
}
