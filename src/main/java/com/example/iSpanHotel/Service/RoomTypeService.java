package com.example.iSpanHotel.Service;

import java.util.List;

import com.example.iSpanHotel.Dto.RoomTypeDto;
import com.example.iSpanHotel.model.RoomType;

public interface RoomTypeService {

	// 創建房型
	String create(RoomTypeDto roomTypeDto);

	// 刪除房型
	String delete(Long id);

	// 修改房型
	String update(Long id, RoomTypeDto roomTypeDto);

	// 查詢所有房型
	List<RoomType> findAll();
	
	// 根據id查詢房型
	RoomType findById(Long id);

}
