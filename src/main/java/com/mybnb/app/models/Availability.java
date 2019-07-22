package com.mybnb.app.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(AvailabilityId.class)
public class Availability {
  
  @Id
  private Date date;
  private float price;
  
  @Id
  @ManyToOne
  private Listing listing;
  
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public float getPrice() {
    return price;
  }
  public void setPrice(float price) {
    this.price = price;
  }

public Listing getListing() {
	return listing;
}
public void setListing(Listing listing) {
	this.listing = listing;
}
  
}