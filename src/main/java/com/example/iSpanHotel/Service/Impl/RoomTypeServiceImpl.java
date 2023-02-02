package com.example.iSpanHotel.Service.Impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
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
			InputStream is = new FileInputStream(roomTypeDto.getRoomPic());
			roomType.setRoomType(roomTypeDto.getRoomType());
			roomType.setRoomPrice(roomTypeDto.getRoomPrice());
			roomType.setRoomPerson(roomTypeDto.getRoomPerson());
			roomType.setRoomPic(IOUtils.toByteArray(is));
			roomType.setContent(roomTypeDto.getContent());
			roomTypeDao.save(roomType);
			return "房型創建成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		
	}

	@Override
	public String delete(Long id) {
		try {
			roomTypeDao.deleteById(id);
			return "刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		
	}

	@Override
	public String update(Long id, RoomTypeDto roomTypeDto) {
		try {
			RoomType roomType = new RoomType();
			InputStream is = new FileInputStream(roomTypeDto.getRoomPic());
			roomType.setId(id);
			roomType.setRoomType(roomTypeDto.getRoomType());
			roomType.setRoomPrice(roomTypeDto.getRoomPrice());
			roomType.setRoomPerson(roomTypeDto.getRoomPerson());
			roomType.setRoomPic(IOUtils.toByteArray(is));
			roomType.setContent(roomTypeDto.getContent());
			roomTypeDao.save(roomType);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
	}

	@Override
	public List<RoomType> findAll() {
		List<RoomType> roomTypes = roomTypeDao.findAll();
		return roomTypes;
	}

	@Override
	public RoomType findById(Long id) {
		Optional<RoomType> roomType = roomTypeDao.findById(id);
		RoomType roomType2 = roomType.get();
		return roomType2;
	}
}
