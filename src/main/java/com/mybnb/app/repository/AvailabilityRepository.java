package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Availability;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import java.sql.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AvailabilityRepository extends CrudRepository<Availability, Integer>{

  @Modifying
  @Query("update Availability a set a.price = ?2 where listing = ?1")
  @Transactional
  void updatPricing(Listing listing, float new_price);

  @Modifying
  @Query("delete from Availability a where a.date = ?1 and a.listing = ?2")
  @Transactional
  void deleteAvailability(Date date, Listing listing);

    
}
