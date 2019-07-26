package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Availability;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import com.mybnb.app.models.RenterCommentListing;
import java.sql.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RenterCommentListingRepository extends CrudRepository<RenterCommentListing, Integer>{

  @Modifying
  @Query(value = "insert into renter_comment_listing (added_on , rating, text, booking_listing_id, booking_renter_id, host_id) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  @Transactional
  void insertComment(Date added_on, float rating, String text,
      int booking_listing_id, int booking_renter_id, int host_id);
  
  @Modifying
  @Query(value = "delete from renter_comment_listing where booking_renter_id = ?1", nativeQuery = true)
  @Transactional
  void deleteComment(int SIN);

    
}
