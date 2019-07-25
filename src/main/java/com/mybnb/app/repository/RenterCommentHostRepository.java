package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Availability;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import com.mybnb.app.models.RenterCommentHost;
import java.sql.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RenterCommentHostRepository extends CrudRepository<RenterCommentHost, Integer>{

  @Modifying
  @Query(value = "insert into renter_comment_host (added_on , rating, text, booking_listing_id, booking_renter_id, host_id) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  @Transactional
  void insertComment(Date added_on, float rating, String text,
      int booking_listing_id, int booking_renter_id, int host_id);

    
}
