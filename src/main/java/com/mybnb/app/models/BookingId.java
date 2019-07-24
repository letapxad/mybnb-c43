package com.mybnb.app.models;

import java.io.Serializable;

public class BookingId implements Serializable{
	
	//private int id; //booking id
	
	private Renter renter;
	
	private Listing listing;

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	
	
}
