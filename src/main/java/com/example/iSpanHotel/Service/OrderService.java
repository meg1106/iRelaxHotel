package com.example.iSpanHotel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.Room;


@Service
public interface OrderService {
	
	// 創建訂單
	Order create(Member member, Room room, OrderDto orderDto);
	
	// 刪除訂單
	String delete(Long id);
	
	// 修改訂單
	String update(Long id, OrderDto orderDto);
	
	// 查詢所有訂單
	List<Order> findAll();
	
	// 根據訂單id查詢訂單
	Order findById(Long id);
	
	// 根據會員id查詢訂單
	Order findByMemberId(Long id);
}
