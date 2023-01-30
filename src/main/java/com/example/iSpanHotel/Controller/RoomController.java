package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Service.RoomService;
import com.example.iSpanHotel.model.Room;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	@GetMapping("/")
	private ResponseEntity<List<Room>> findAll() {
		List<Room> rooms = roomService.findAll();
		return ResponseEntity.ok(rooms);
	}
	
}
