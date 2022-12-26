package com.example.iSpanHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
