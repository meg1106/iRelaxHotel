package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.OrderService;
import com.example.iSpanHotel.model.Order;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public String create(OrderDto orderDto) {
		try {
			Order order = new Order();
			order.setId(orderDto.getId());
			order.setMember(memberDao.findById(orderDto.getMember()).get());
			order.setOrderDate(orderDto.getOrderDate());
			orderDao.save(order);
			return "訂單創建成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String delete(Long id) {
		try {
			orderDao.deleteById(id);
			return "消息刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String update(Long id, OrderDto orderDto) {
		try {
			Order order = new Order();
			order.setId(id);
			order.setMember(memberDao.findById(orderDto.getMember()).get());
			order.setOrderDate(orderDto.getOrderDate());
			orderDao.save(order);
			return "訂單修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<Order> findAll() {
		List<Order> order = new ArrayList<>();
		order = orderDao.findAll();
		return order;
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> order = orderDao.findById(id);
		return order.get();
	}
	
}
