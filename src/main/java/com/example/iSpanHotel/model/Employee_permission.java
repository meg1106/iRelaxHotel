//package com.example.iSpanHotel.model;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "employee_permission")
//public class Employee_permission {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "employee_id", nullable = false)
//	private Employee employee;
//	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "permissions_id", nullable = false)
//	private Permissions permissions;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public Permissions getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(Permissions permissions) {
//		this.permissions = permissions;
//	}
//	
//}
