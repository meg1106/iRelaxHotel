package com.example.iSpanHotel.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.iSpanHotel.model.OrderJournal;
import com.example.iSpanHotel.model.Room;

import jakarta.transaction.Transactional;

public interface OrderJournalDao extends JpaRepository<OrderJournal, Long> {
	
	@Modifying
	@Transactional
	@Query(name = "deleteByOrder", nativeQuery = true, value = "delete from `order_journal` where order_id=:order")
	void deleteByOrder(@Param("order") Long order);
	
//	@Query(nativeQuery = true, value = "SELECT * FROM room WHERE id NOT IN(SELECT room_id FROM `order_journal` WHERE stay_date BETWEEN:startDate AND:endDate)")
//	List<Room> findRoomBystayDateBetween(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	@Query(value = "SELECT c FROM Room c WHERE c.id NOT IN(SELECT x.room From OrderJournal x where x.stayDate BETWEEN:startDate and:endDate) AND c.roomFloor =:floor AND c.roomType IN(SELECT y.id FROM RoomType y WHERE y.roomPerson >=:person )")
	List<Room> findRoomBystayDateBetween(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("floor")Integer floor, @Param("person")Integer person);
	
	
}
