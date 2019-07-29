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
    @Query("update Booking b set b.status = 'cancelled' where b.renter = ?1")
    @Transactional
    void cancelAllBooking(Renter renter);

    @Modifying
    @Query(value = "insert into booking (renter_id, listing_id, host_id, start_date, end_date, cost, status, cancelled_by) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    @Transactional
    void insertBooking(int renter_id, int listing_id, int host_id, Date start_date,
        Date end_date, double cost, String status, String cancelled_by);

    @Query("select b from Booking b where renter_id = ?1")
    List<Booking> fidnByRenterId(int renter_id);

    
    @Query("select distinct id from Booking b where renter_id = ?1")
    List<Integer> findByRenterDistinctRId(int renter_id);

    @Modifying
    @Query("update Booking b set b.status = 'Cancelled' where b.id = ?1")
    @Transactional
    void cancelBooking(int booking_id);
    
    @Modifying
    @Query("update Booking b set b.cancelled_by = 'Renter' where b.id = ?1")
    @Transactional
    void setCancelRenter(int booking_id);
    
    @Modifying
    @Query("update Booking b set b.cancelled_by = 'Host' where b.id = ?1")
    @Transactional
    void setCancelHost(int booking_id);
    
    @Modifying
    @Query("delete from Booking b where b.renter = ?1")
    @Transactional
    void deleteBooking(Renter renter);

    //@Query("select b from Booking b where booking_id = ?1")
    //Booking getBookingById(int booking_id);
    @Query(value="select distinct host_id,id  from booking", nativeQuery = true)
    List<Booking> getBookigDax();

    @Query( value="select renter_id,count(*) as cancel_count from Booking b where status='Cancelled' and cancelled_by='RENTER' group by b.renter_id  order by cancel_count  desc", nativeQuery = true)
    List<Object[]> getRenterCancellation();

    @Query( value="select host_id,count(*) as cancel_count from Booking b where status='Cancelled' and cancelled_by='HOST' group by b.host_id  order by cancel_count  desc", nativeQuery = true)
    List<Object[]> getHostCancellation();

    @Query(value=" select renter_id, count(id) AS count from booking where start_date>= ?1 and end_date<= ?2  group by renter_id order by count desc", nativeQuery = true)
    List<Object[]> rankRentersByBookingCount(String start_date, String end_date);

    @Query(value=" select renter_id, count(booking.id) AS count from booking inner join listing l on listing_id=l.id where start_date>= ?1 and end_date<= ?2  and city= ?3 group by renter_id order by count desc", nativeQuery = true)
    List<Object[]> rankRentersByBookingCountInCity(String start_date, String end_date, String city);
}
