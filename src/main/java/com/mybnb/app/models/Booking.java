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
  private Date start_date;
  private Date end_date;
  
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
  
  public Date getStart_date() {
    return start_date;
  }
  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }
  public Date getEnd_date() {
    return end_date;
  }
  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
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
}