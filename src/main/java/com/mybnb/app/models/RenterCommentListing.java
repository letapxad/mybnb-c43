package com.mybnb.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ForeignKey;

@Entity
public class RenterCommentListing extends Comment {
    
  @OneToOne
  @MapsId
  //@ForeignKey(name="fk_comment1")
  @JoinColumn(name="booking_id")
  //@MapsId
  private Booking booking;
}
