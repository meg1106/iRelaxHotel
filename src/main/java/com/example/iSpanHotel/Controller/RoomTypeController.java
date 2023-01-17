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

import com.example.iSpanHotel.Dto.RoomTypeDto;
import com.example.iSpanHotel.Service.RoomTypeService;
import com.example.iSpanHotel.model.RoomType;

@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody RoomTypeDto roomTypeDto) {
		String message = roomTypeService.create(roomTypeDto);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		String message = roomTypeService.delete(id);
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody RoomTypeDto roomTypeDto) {
		String message = roomTypeService.update(id, roomTypeDto);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<RoomType>> findAll() {
		List<RoomType> roomTypes = roomTypeService.findAll();
		return ResponseEntity.ok(roomTypes);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<RoomType> findById(@PathVariable Long id) {
		RoomType roomType = roomTypeService.findById(id);
		return ResponseEntity.ok(roomType);
	}
	
}
