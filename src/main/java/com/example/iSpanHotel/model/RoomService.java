package com.example.iSpanHotel.model;

import jakarta.annotation.Generated;
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
	private Roomtype roomtype;
}
