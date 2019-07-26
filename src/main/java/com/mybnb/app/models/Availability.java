package com.mybnb.app.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(AvailabilityId.class)
public class Availability {
  
  @Id
  private Date date;
  private double price;
  
  @Id
  @ManyToOne
  @JoinColumn(name="listing_id")
  private Listing listing;
  
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double d) {
    this.price = d;
  }

public Listing getListing() {
	return listing;
}
public void setListing(Listing listing) {
	this.listing = listing;
}
  
}