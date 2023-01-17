package com.example.iSpanHotel.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.HotelNews;

public interface HotelNewsDao extends JpaRepository<HotelNews, Long> {

	Optional<HotelNews> findByTitle(String title);

}
