package com.example.iSpanHotel.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dto.RoomDto;
import com.example.iSpanHotel.Service.RoomService;
import com.example.iSpanHotel.Service.RoomTypeService;
import com.example.iSpanHotel.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;
	@Autowired
	private RoomTypeService roomTypeService;

	@Override
	public String create(RoomDto roomDto) {
		try {
			Room room = new Room();
			room.setRoomNum(roomDto.getRoomNum());
			room.setRoomFloor(roomDto.getRoomFloor());
			room.setRoomStatus(roomDto.getRoomStatus());
			room.setNote(roomDto.getNote());
			room.setRoomType(roomTypeService.findById(roomDto.getRoomType()));
			roomDao.save(room);
			return "新增成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}

	}

	@Override
	public String delete(Long id) {
		try {
			roomDao.deleteById(id);
			return "刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
	}

	@Override
	public String update(Long id, RoomDto roomDto) {
		try {
			Room room = new Room();
			room.setId(id);
			room.setRoomNum(roomDto.getRoomNum());
			room.setRoomFloor(roomDto.getRoomFloor());
			room.setRoomStatus(roomDto.getRoomStatus());
			room.setNote(roomDto.getNote());
			room.setRoomType(roomTypeService.findById(roomDto.getRoomType()));
			roomDao.save(room);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
	}

	@Override
	public List<Room> findAll() {
		List<Room> rooms = roomDao.findAll();
		return rooms;
	}

	@Override
	public Room findById(Long id) {
		Optional<Room> room = roomDao.findById(id);
		return room.get();
	}

}
