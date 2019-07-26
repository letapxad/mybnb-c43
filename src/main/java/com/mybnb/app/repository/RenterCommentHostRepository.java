
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
  @Query(value = "insert into renter_comment_host (added_on, rating, text, booking_id) values (?1, ?2, ?3, ?4)", nativeQuery = true)
  @Transactional
  void insertComment(java.util.Date added_on, float rating, String text,
      int booking_id);
  
  @Modifying
  @Query(value = "delete from renter_comment_host where booking_renter_id = ?1", nativeQuery = true)
  @Transactional
  void deleteComment(int SIN);

    
}
