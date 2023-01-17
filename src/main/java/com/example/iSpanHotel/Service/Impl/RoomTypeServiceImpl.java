package com.example.iSpanHotel.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.RoomTypeDao;
import com.example.iSpanHotel.Dto.RoomTypeDto;
import com.example.iSpanHotel.Service.RoomTypeService;
import com.example.iSpanHotel.model.RoomType;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
	
	@Autowired
	private RoomTypeDao roomTypeDao;
	
	@Override
	public String create(RoomTypeDto roomTypeDto) {
		
		try {
			RoomType roomType = new RoomType();
			roomType.setRoomType(roomTypeDto.getRoomType());
			roomType.setRoomPrice(roomTypeDto.getRoomPrice());
			roomType.setRoomPerson(roomTypeDto.getRoomPerson());
			roomType.setRoomPic(roomTypeDto.getRoomPic());
			roomType.setContent(roomTypeDto.getContent());
			roomTypeDao.save(roomType);
			return "房型創建成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		
	}
}
