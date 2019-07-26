package com.mybnb.app.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;

public interface BookingRepository extends CrudRepository<Booking,Integer>, BookingRepositoryCustom{

    
    @Query("SELECT s from Booking s where s.id = ?1")
    Booking findByBookingId(int booking_id);
    
    @Modifying
    @Query("update Booking b set b.status = 'Canceled' where b.renter = ?1")
    @Transactional
    void cancelAllBooking(Renter renter);

    @Modifying
    @Query(value = "insert into booking (renter_id, listing_id, host_id, start_date, end_date, cost, status) values (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    @Transactional
    void insertBooking(int renter_id, int listing_id, int host_id, Date start_date,
        Date end_date, float cost, String status);

    @Query("select b from Booking b where renter_id = ?1")
    List<Booking> fidnByRenterId(int renter_id);

    @Modifying
    @Query("update Booking b set b.status = 'Canceled' where b.id = ?1")
    @Transactional
    void cancelBooking(int booking_id);
    
    @Modifying
    @Query("delete from Booking b where b.renter = ?1")
    @Transactional
    void deleteBooking(Renter renter);

    @Query("select b from Booking b where booking_id = ?1")
    Booking getBookingById(int booking_id);

}
