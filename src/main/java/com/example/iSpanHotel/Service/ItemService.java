package com.example.iSpanHotel.Service;

import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.Room;

@Service
public interface ItemService {

	// 創建訂單細節
	Item create(OrderDto orderDto, Order order, Room room);

	// 刪除訂單細節
	String delete(Long id);

	// 修改訂單細節
	String update(Long id, OrderDto orderDto);

}
