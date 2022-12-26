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
@Table(name = "roomorder")
public class RoomOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "order_id", nullable = false, unique = false)
	private String orderId;
	
	@Column(name = "date", nullable = false, unique = false)
	private String date;
	
	@Column(name = "status", nullable = false, unique = false)
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "roomtype_id", nullable = false, unique = false)
	private RoomType roomType;
	
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false, unique = false)
	private Member member;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "RoomOrder [id=" + id + ", orderId=" + orderId + ", date=" + date + ", status=" + status + ", roomType="
				+ roomType + ", member=" + member + "]";
	}
	
	
}
