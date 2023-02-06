package com.example.iSpanHotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.OrderJournal;

public interface OrderJournalDao extends JpaRepository<OrderJournal, Long> {

}
