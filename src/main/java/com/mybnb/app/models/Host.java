package com.mybnb.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Host extends User{
	
	
	/* 
	 * host can have many listings
	 * no need to define a separate 
	 * relationship this will be auto generated
	 */
	
	@OneToMany(mappedBy="host")//, cascade = CascadeType.ALL)
	private List<Listing> listings;
	
	@OneToMany(mappedBy = "host")//, cascade = CascadeType.ALL)
    private List<Booking> bookings;

	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
}
