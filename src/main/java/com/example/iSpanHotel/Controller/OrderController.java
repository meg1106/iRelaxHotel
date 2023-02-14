package com.example.iSpanHotel.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Dto.PaymentDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.Service.ItemService;
import com.example.iSpanHotel.Service.MemberService;
import com.example.iSpanHotel.Service.OrderService;
import com.example.iSpanHotel.Service.RoomService;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.Room;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/")
	private List<Order> findAll() {
		List<Order> order = orderService.findAll();
		return order;
	}
	
	@PostMapping("/")
	private ResponseEntity<String> create(@CookieValue(value = "UID", defaultValue = "Atta")String token, @RequestBody OrderDto orderDto) {
		try {
			String mId = JWTutils.parseJWT(token).getId();
			Member member = memberService.findById(Long.parseLong(mId));
			Room room = roomService.findById(orderDto.getRoom_id());
			Order order = orderService.create(member, room, orderDto);
			Item item = itemService.create(orderDto, order, room);
			emailService.sendOrderDetail(member, item);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return ResponseEntity.ok("下訂完成！將跳轉到訂單頁面，請盡快付款，謝謝！");
	}
	
	@GetMapping("/o{id}")
	private ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/m{id}")
	private ResponseEntity<Order> findByMemberId(@PathVariable Long id) {
		Order order = orderService.findByMemberId(id);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		orderService.update(id, orderDto);
		itemService.update(id, orderDto);
		return ResponseEntity.ok("訂單修改成功");
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.ok("訂單刪除成功");
	}
	
	@PostMapping("/payment")
	private ResponseEntity<String> createPaymentForm(@RequestBody PaymentDto paymentDto) throws UnsupportedEncodingException {
		String form = orderService.createPaymentForm(paymentDto);
		return ResponseEntity.ok(form);
	} 
}