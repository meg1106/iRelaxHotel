package com.example.iSpanHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotelnews")
public class HotelNews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "newsType", nullable = false, unique = false)
	private Short newsType;
	
	@Column(name = "title", nullable = false, unique = false)
	private String title;
	
	@Column(name = "start_date", nullable = false, unique = false)
	private String startDate;
	
	@Column(name = "end_date", nullable = false, unique = false)
	private String endDate;
	
	@Column(name = "pic", nullable = true, unique = false)
	private String pic;
	
	@Column(name = "content", nullable = true, unique = false)
	private String content;
	
	
}
