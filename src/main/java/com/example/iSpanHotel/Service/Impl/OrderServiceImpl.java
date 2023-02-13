package com.example.iSpanHotel.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.DateUtils;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dao.OrderJournalDao;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.OrderService;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.OrderJournal;
import com.example.iSpanHotel.model.Room;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private OrderJournalDao orderJournalDao;
	
	@Override
	public Order create(Member member, Room room, OrderDto orderDto) {
		try {
			Order order = new Order();
			order.setMember(member);
			order.setOrderDate(new Date());
			order = orderDao.save(order);
			List<String> dates = DateUtils.getBetweenDates(orderDto.getCheckinDate(), orderDto.getCheckoutDate(), true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member);
				orderJournal.setOrder(order);
				orderJournal.setRoom(room);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
			}
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String delete(Long id) {
		try {
			orderDao.deleteById(id);
			return "訂單刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String update(Long id, OrderDto orderDto) {
		try {
			orderJournalDao.deleteByOrder(id);
			Order order = new Order();
			Member member = memberDao.findById(orderDto.getMember()).get();
			order.setId(id);
			order.setMember(member);
			order.setOrderDate(new Date());
			orderDao.save(order);
			List<String> dates = DateUtils.getBetweenDates(orderDto.getCheckinDate(), orderDto.getCheckoutDate(), true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member);
				orderJournal.setOrder(order);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
			}
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

	@Override
	public Order findByMemberId(Long id) {
		Optional<Order> order = orderDao.findByMemberId(id);
		return order.get();
	}
	
}
