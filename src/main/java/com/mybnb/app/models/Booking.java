package com.mybnb.app.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
  
  private enum Status {Booked, Cancelled;}
  
  @Enumerated(EnumType.STRING)
  private Status status;
  
  @Column(nullable = false)
  private Date start_date;
  
  @Column(nullable = false)
  private Date end_date;
  
  @Column(nullable = false)
  private double cost;
  
  private String cancelled_by;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "renter_id")
  private Renter renter;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "listing_id")
  private Listing listing;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="host_id")
  private Host host;
  
  @OneToOne(mappedBy = "booking",
      cascade = CascadeType.REMOVE, orphanRemoval = true)
  private RenterCommentHost rch;
  
  @OneToOne(mappedBy = "booking",
      cascade = CascadeType.REMOVE, orphanRemoval = true)
  private RenterCommentListing rcl;
  
  @OneToOne(mappedBy = "booking",
      cascade = CascadeType.REMOVE, orphanRemoval = true)
  private HostCommentRenter hcr;
  
  public Host getHost() {
    return host;
  }

  public String getCancelled_by() {
    return cancelled_by;
  }

  public void setCancelled_by(String cancelled_by) {
    this.cancelled_by = cancelled_by;
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