package com.example.iSpanHotel.Service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.ItemDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.ItemService;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Order;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public Item create(OrderDto orderDto, Order order) {
		try {
			Item item = new Item();
			item.setOrder(order);
			item.setRoom(roomDao.findById(orderDto.getRoom_id()).get());
			item.setCheckinDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getCheckinDate()));
			item.setCheckoutDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getCheckoutDate()));
			itemDao.save(item);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String delete(Long id) {
		try {
			itemDao.deleteById(id);
			return "細節刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String update(Long id, OrderDto orderDto) {
		try {
			Item item = new Item();
			item.setId(id);
			item.setOrder(orderDao.findById(orderDto.getOrder_id()).get());
			item.setRoom(roomDao.findById(orderDto.getRoom_id()).get());
			item.setCheckinDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getCheckinDate()));
			item.setCheckoutDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getCheckoutDate()));
			item.setStatus(orderDto.getStatus());
			itemDao.save(item);
			return "細節修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<Item> findByDate() {
		try {
			Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01");
			System.out.println(expiryDate);
			List<Item> items = itemDao.findAllBycheckinDateAfter(expiryDate);
//			System.out.println(items.get(0).toString());
			return items;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
