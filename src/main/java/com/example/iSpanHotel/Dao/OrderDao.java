package com.example.iSpanHotel.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iSpanHotel.model.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	Optional<Order> findByMemberId(Long id);

}
