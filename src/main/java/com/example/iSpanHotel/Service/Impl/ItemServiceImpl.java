package com.example.iSpanHotel.Service.Impl;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.ItemDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Dto.PaymentDto;
import com.example.iSpanHotel.Service.ItemService;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.Room;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public Item create(OrderDto orderDto, Order order, Room room) {
		try {
			Item item = new Item();
			item.setOrder(order);
			item.setRoom(room);
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
			item.setOrder(orderDao.findById(id).get());
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
	public String paySuccess(PaymentDto paymentDto) {
		String tradeNo = paymentDto.getMerchantTradeNo();
		Long oid = Long.parseLong(tradeNo.substring(16));
		if (paymentDto.getRtnMsg().equals("Succeeded")) {
			System.out.println("OK");
			Item item = new Item();
			item.setId(oid);
			item.setOrder(orderDao.findById(oid).get());
			item.setRoom(itemDao.findById(oid).get().getRoom());
			item.setCheckinDate(itemDao.findById(oid).get().getCheckinDate());
			item.setCheckoutDate(itemDao.findById(oid).get().getCheckoutDate());
			item.setStatus((short)2);
			itemDao.save(item);
		}else{
			System.out.println("NO");
			return "付款失敗！";
		}
		return "訂單狀態修改成功";
	}
}
