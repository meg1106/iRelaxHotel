package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.RoomDto;
import com.example.iSpanHotel.Service.RoomService;
import com.example.iSpanHotel.model.Room;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody RoomDto roomDto) {
		String message = roomService.create(roomDto);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		String message = roomService.delete(id);
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody RoomDto roomDto) {
		String message = roomService.update(id, roomDto);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/")
	private ResponseEntity<List<Room>> findAll() {
		List<Room> rooms = roomService.findAll();
		return ResponseEntity.ok(rooms);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Room> findById(@PathVariable Long id) {
		Room room = roomService.findById(id);
		return ResponseEntity.ok(room);
	}
	
}
