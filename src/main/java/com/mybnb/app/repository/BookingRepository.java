package com.mybnb.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Renter;

public interface BookingRepository extends CrudRepository<Booking,Integer>{

    
    @Query("SELECT s from Booking s where s.id = ?1")
    Booking findByBookingId(int booking_id);
    
    @Modifying
    @Query("update Booking b set b.status = 'Canceled' where b.renter = ?1")
    @Transactional
    void cancelAllBooking(Renter renter);
    

}
