package com.example.iSpanHotel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.model.Order;


@Service
public interface OrderService {
	
	// 創建訂單
	String create(OrderDto orderDto);
	
	// 刪除訂單
	String delete(Long id);
	
	// 修改訂單
	String update(Long id, OrderDto orderDto);
	
	// 查詢所有訂單
	List<Order> findAll();
	
	// 根據會員id查詢訂單
	Order findById(Long id);
}
