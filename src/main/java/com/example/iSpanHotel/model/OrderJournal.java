package com.example.iSpanHotel.model;

import java.util.Date;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "order_journal")
public class OrderJournal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@Column(name = "stayDate", nullable = false, columnDefinition = "DATE")
	private Date stayDate;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@JsonIgnoreProperties({"orderJournalds"})
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getStayDate() {
		return stayDate;
	}

	public void setStayDate(Date stayDate) {
		this.stayDate = stayDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
