package com.example.iSpanHotel.model;

import java.util.Date;

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
	
//	@JsonIgnoreProperties({"items"})
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@Column(name = "checkin_date", nullable = false, columnDefinition = "DATE")
	private Date stayDate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
}
