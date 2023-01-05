package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.Item;

public interface ItemDao extends JpaRepository<Item, Long> {

}
