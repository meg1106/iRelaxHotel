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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getNewsType() {
		return newsType;
	}

	public void setNewsType(Short newsType) {
		this.newsType = newsType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HotelNews [id=" + id + ", newsType=" + newsType + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", pic=" + pic + ", content=" + content + "]";
	}
	
	
}
