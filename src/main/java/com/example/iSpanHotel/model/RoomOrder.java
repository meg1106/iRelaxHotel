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
	private int id;
	
	@Column(name = "order_id", nullable = false, unique = false)
	private Integer orderId;
	
	@Column(name = "date", nullable = false, unique = false)
	private String date;
	
	@Column(name = "status", nullable = false, unique = false)
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "roomtype_id", nullable = false, unique = false)
	private RoomType roomType;
	
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false, unique = false)
	private Member member;
}
