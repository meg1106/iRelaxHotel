package com.example.iSpanHotel.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Class.TDXapi;

@RestController
@RequestMapping("/bustime")
public class BusTimeController {

	@GetMapping("/get")
	private String getBusTime() {
		TDXapi busApi = new TDXapi();
		String message = "";
		try {
			message = busApi.getBus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
}
