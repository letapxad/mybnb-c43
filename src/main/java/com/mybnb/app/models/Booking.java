package com.mybnb.app.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Enumerated;

@Entity
@IdClass(BookingId.class)
public class Booking {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  private enum Status {Booked, Cancelled;}
  
  @Enumerated(EnumType.STRING)
  private Status status;
  private Date date;
  private float cost;
  
  @Id
  @ManyToOne
  private Renter renter;
  
  @Id
  @ManyToOne
  private Listing listing;
  
  
  public Status getStatus() {
    return status;
  }
  public void setStatus(Status status) {
    this.status = status;
  }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Renter getRenter() {
		return renter;
	}
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
  public float getCost() {
    return cost;
  }
  public void setCost(float cost) {
    this.cost = cost;
  }
  public Listing getListing() {
    return listing;
  }
  public void setListing(Listing listing) {
    this.listing = listing;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
}