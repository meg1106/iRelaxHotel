package com.example.iSpanHotel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "order_id", nullable = false)
//	private Order order;
//	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "room_id", nullable = false)
//	private Room room;
	
	@Column(name = "checkin_date", nullable = false)
	private String checkinDate;
	
	@Column(name = "checkout_date", nullable = false)
	private String checjoutDate;
	
	@Column(name = "status", nullable = false)
	private Short status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Room getRoom() {
//		return room;
//	}
//
//	public void setRoom(Room room) {
//		this.room = room;
//	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getChecjoutDate() {
		return checjoutDate;
	}

	public void setChecjoutDate(String checjoutDate) {
		this.checjoutDate = checjoutDate;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	
}
