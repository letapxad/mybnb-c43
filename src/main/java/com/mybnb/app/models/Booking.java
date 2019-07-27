package com.mybnb.app.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

@Entity
//@IdClass(BookingId.class)
public class Booking {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  private enum Status {Booked, Canceled;}
  
  @Enumerated(EnumType.STRING)
  private Status status;
  
  private Date start_date;
  
  private Date end_date;
  
  private double cost;
  
  private String canceled_by;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="renter_id")
  private Renter renter;
  
  @ManyToOne
  @JoinColumn(name="listing_id")
  private Listing listing;
  
  @ManyToOne
  @JoinColumn(name="host_id")
  private Host host;
  
  
  public Host getHost() {
    return host;
  }
  public void setHost(Host host) {
    this.host = host;
  }
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
  public double getCost() {
    return cost;
  }
  public void setCost(double cost) {
    this.cost = cost;
  }
  public Listing getListing() {
    return listing;
  }
  public void setListing(Listing listing) {
    this.listing = listing;
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

}