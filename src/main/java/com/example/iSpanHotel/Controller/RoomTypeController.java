package com.example.iSpanHotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.RoomTypeDto;
import com.example.iSpanHotel.Service.RoomTypeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PostMapping("/create")
	private String create(@RequestBody RoomTypeDto roomTypeDto) {
		String message = roomTypeService.create(roomTypeDto);
		
		return message;
	}
	
}
