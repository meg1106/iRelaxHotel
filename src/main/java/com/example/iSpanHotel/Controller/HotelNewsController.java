package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.HotelNewsDto;
import com.example.iSpanHotel.Service.HotelNewsService;
import com.example.iSpanHotel.model.HotelNews;

@RestController
@RequestMapping("/hotelnews")
public class HotelNewsController {
	@Autowired
	private HotelNewsService hotelNewsService;
	
	@GetMapping("/")
	private List<HotelNews> findAll() {
		List<HotelNews> hotelNews = hotelNewsService.findAll();
		return hotelNews;
	}
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody HotelNewsDto hotelNewsDto) {
		hotelNewsService.create(hotelNewsDto);
		return ResponseEntity.ok("消息創建成功");
	}
	
	@GetMapping("/{title}")
	private ResponseEntity<HotelNews> findByTitle(@PathVariable String title) {
		HotelNews hotelNews = hotelNewsService.findByTitle(title);
		return new ResponseEntity<>(hotelNews,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody HotelNewsDto hotelNewsDto) {
		hotelNewsService.update(id, hotelNewsDto);
		return ResponseEntity.ok("消息修改成功");
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		hotelNewsService.delete(id);
		return ResponseEntity.ok("消息刪除成功");
	}
}
