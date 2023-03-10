package com.example.iSpanHotel.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.CheckEmailUtils;
import com.example.iSpanHotel.Class.DateUtils;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dao.OrderJournalDao;
import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Dto.PaymentDto;
import com.example.iSpanHotel.Service.OrderService;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.OrderJournal;
import com.example.iSpanHotel.model.Room;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private RoomDao roomDao;
	
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
			return "??????????????????";
		} catch (Exception e) {
			e.printStackTrace();
			return "?????????????????????";
		}
	}

	@Override
	public String update(Long id, OrderDto orderDto) {
		try {
			orderJournalDao.deleteByOrder(id);
			Order order = new Order();
			Member member = memberDao.findById(orderDto.getMember()).get();
			Room room = roomDao.findById(orderDto.getRoom_id()).get();
			order.setId(id);
			order.setMember(member);
			order.setOrderDate(new Date());
			orderDao.save(order);
			List<String> dates = DateUtils.getBetweenDates(orderDto.getCheckinDate(), orderDto.getCheckoutDate(), true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member);
				orderJournal.setOrder(order);
				orderJournal.setRoom(room);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
			}
			return "??????????????????";
		} catch (Exception e) {
			e.printStackTrace();
			return "?????????????????????";
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

	@Override
	public String createPaymentForm(PaymentDto paymentDto) throws UnsupportedEncodingException {
		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		Order order = orderDao.findById(paymentDto.getOrder_id()).get();
//		System.out.println(paymentDto.getOrder_id());
		//?????????????????????
		obj.setMerchantTradeNo("iRelaxHotel" + CheckEmailUtils.VerifyCode(7) + order.getId());
		obj.setMerchantTradeDate(sdf.format(new Date()));
		obj.setTotalAmount(paymentDto.getTotalAmount());
		obj.setTradeDesc(paymentDto.getTradeDesc());
		obj.setItemName(paymentDto.getItemName());
		obj.setReturnURL("http://localhost/order/test2");
		obj.setOrderResultURL("http://localhost:8080/order/paySuccess");
		obj.setNeedExtraPaidInfo("N");
		//??????form???????????????
		String form = all.aioCheckOut(obj, null);
		return form;
	}

}
