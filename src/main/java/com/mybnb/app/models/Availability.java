package com.mybnb.app.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Availability {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int availability_id;
  private Date date;
  private float price;
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
  
}