package com.example.iSpanHotel.Service;

import java.util.List;

import com.example.iSpanHotel.Dto.RoomDto;
import com.example.iSpanHotel.model.Room;

public interface RoomService {

	// 創建
	String create(RoomDto roomDto);
	
	// 刪除
	String delete(Long id);
	
	// 修改
	String update(Long id, RoomDto roomDto);
	
	// 查詢所有
	List<Room> findAll();
	
	// 查詢單一
	Room findById(Long id);
	
	
}
