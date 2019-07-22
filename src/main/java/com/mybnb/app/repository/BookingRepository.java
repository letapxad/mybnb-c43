package com.mybnb.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mybnb.app.models.Booking;

public interface BookingRepository extends CrudRepository<Booking,Integer>{

    
    @Query("SELECT s from Booking s where s.id = ?1")
    Booking findByBookingId(int booking_id);

}
