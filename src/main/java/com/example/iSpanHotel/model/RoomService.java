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
	private Integer id;
	
	@Column(name = "room_number", nullable = false, unique = true)
	private String roomNum;
	
	@Column(name = "room_status", nullable = false, unique = false)
	private Short roomStatus;
	
	@Column(name = "note", nullable = true, unique = false)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "roomtype_id", nullable = false, unique = false)
	private RoomType roomType;
}
