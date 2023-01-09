package com.example.iSpanHotel.Dto;

public class HotelNewsDto {
	private Long id;
	private Short newsType;
	private String title;
	private String startDate;
	private String endDate;
	private String pic;
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public short getNewsType() {
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
		return "HotelNewsDto [id=" + id + ", newsType=" + newsType + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", pic=" + pic + ", content=" + content + "]";
	}
	
}
