package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.HotelNewsDao;
import com.example.iSpanHotel.Dto.HotelNewsDto;
import com.example.iSpanHotel.Service.HotelNewsService;
import com.example.iSpanHotel.model.HotelNews;

@Service
public class HotelNewsServiceImpl implements HotelNewsService{
	
	@Autowired
	private HotelNewsDao hotelNewsDao;

	@Override
	public String create(HotelNewsDto hotelNewsDto) {
		try {
			HotelNews hotelNews = new HotelNews();
			hotelNews.setId(hotelNewsDto.getId());
			hotelNews.setNewsType(hotelNewsDto.getNewsType());
			hotelNews.setTitle(hotelNewsDto.getTitle());
			hotelNews.setStartDate(hotelNewsDto.getStartDate());
			hotelNews.setEndDate(hotelNewsDto.getEndDate());
			hotelNews.setPic(hotelNewsDto.getPic());
			hotelNews.setContent(hotelNewsDto.getContent());
			hotelNewsDao.save(hotelNews);
			return "消息發佈成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String delete(Long id) {
		try {
			hotelNewsDao.deleteById(id);
			return "消息刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public String update(Long id, HotelNewsDto hotelNewsDto) {
		try {
			HotelNews hotelNews = new HotelNews();
			hotelNews.setId(id);
			hotelNews.setNewsType(hotelNewsDto.getNewsType());
			hotelNews.setTitle(hotelNewsDto.getTitle());
			hotelNews.setStartDate(hotelNewsDto.getStartDate());
			hotelNews.setEndDate(hotelNewsDto.getEndDate());
			hotelNews.setPic(hotelNewsDto.getPic());
			hotelNews.setContent(hotelNewsDto.getContent());
			hotelNewsDao.save(hotelNews);
			return "消息修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<HotelNews> findAll() {
		List<HotelNews> hotelNews = new ArrayList<>();
		hotelNews = hotelNewsDao.findAll();
		return hotelNews;
	}

	@Override
	public HotelNews findByTitle(String title) {
		Optional<HotelNews> hotelNews = hotelNewsDao.findByTitle(title);
		return hotelNews.get();
	}

}
