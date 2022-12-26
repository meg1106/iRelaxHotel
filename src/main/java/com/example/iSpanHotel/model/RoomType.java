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
	private Integer id;
	
	@Column(name = "roomtype", nullable = false, unique = false)
	private String roomtype;
	
	@Column(name = "roomprice", nullable = false, unique = false)
	private Integer roomprice;
	
	@Column(name = "roompic", nullable = true, unique = false)
	private String roompic;
	
	@Column(name = "content", nullable = true, unique = false)
	private String content;
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	private List<RoomService> roomServices;
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	private List<RoomOrder> roomOrders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(Integer roomprice) {
		this.roomprice = roomprice;
	}

	public String getRoompic() {
		return roompic;
	}

	public void setRoompic(String roompic) {
		this.roompic = roompic;
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
		return "RoomType [id=" + id + ", roomtype=" + roomtype + ", roomprice=" + roomprice + ", roompic=" + roompic
				+ ", content=" + content + ", roomServices=" + roomServices + "]";
	}
}
