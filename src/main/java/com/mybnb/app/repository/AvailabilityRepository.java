package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Availability;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AvailabilityRepository extends CrudRepository<Availability, Integer>{

  @Modifying
  @Query("update Availability a set a.price = ?2 where listing = ?1 and a.date = ?3")
  @Transactional
  void updatePricing(Listing listing, double new_price, Date date);

  @Modifying
  @Query("delete from Availability a where a.date = ?1 and a.listing = ?2")
  @Transactional
  void deleteAvailability(Date date, Listing listing);

  @Modifying
  @Query(value = "insert into availability (date, price, listing_id) values (?1, ?2, ?3)", nativeQuery = true)
  @Transactional
  void insertAvailability(Date new_date, double price, int listing_id);

  
  List<Availability> findByListingId(int listing_id);

  @Query("select a from Availability a where a.date = ?1 and a.listing = ?2")
  Availability getPrice(Date date, Listing listing);
}
