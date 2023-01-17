package com.example.iSpanHotel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.HotelNewsDto;
import com.example.iSpanHotel.model.HotelNews;

@Service
public interface HotelNewsService {
	
	// 發佈消息
	String create(HotelNewsDto hotelNewsDto);
	
	// 刪除消息
	String delete(Long id);
	
	// 修改消息
	String update(Long id, HotelNewsDto hotelNewsDto);
	
	// 查詢所有消息
	List<HotelNews> findAll();
	
	// 根據標題查詢消息
	HotelNews findByTitle(String title);
	
}
