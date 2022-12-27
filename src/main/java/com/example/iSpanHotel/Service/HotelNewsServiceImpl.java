package com.example.iSpanHotel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Dao.HotelNewsDao;
import com.example.iSpanHotel.Dto.HotelNewsDto;
import com.example.iSpanHotel.model.HotelNews;

@Service
public class HotelNewsServiceImpl implements HotelNewsService{
	
	@Autowired
	private HotelNewsDao hotelNewsDao;

	@Override
	public void create(HotelNewsDto hotelNewsDto) {
		HotelNews hotelNews = new HotelNews();
		hotelNews.setId(hotelNewsDto.getId());
		hotelNews.setNewsType(hotelNewsDto.getNewsType());
		hotelNews.setTitle(hotelNewsDto.getTitle());
		hotelNews.setStartDate(hotelNewsDto.getStartDate());
		hotelNews.setEndDate(hotelNewsDto.getEndDate());
		hotelNews.setPic(hotelNewsDto.getPic());
		hotelNews.setContent(hotelNewsDto.getContent());
		hotelNewsDao.save(hotelNews);
		
	}

}
