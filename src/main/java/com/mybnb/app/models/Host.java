package com.mybnb.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Host extends User{
	
	
	/* 
	 * host can have many listings
	 * no need to define a separate 
	 * relationship this will be auto generated
	 */
	
      @OneToMany(cascade=CascadeType.REMOVE, 
          fetch = FetchType.LAZY, 
          mappedBy = "host")
    private List<Listing> listings;
    
    @OneToMany(cascade=CascadeType.REMOVE, 
    fetch = FetchType.LAZY, 
    mappedBy = "host")
    private List<Booking> bookings;

	public List<Listing> getListings() {
		return listings;
	}

	public void removeListing(Listing listing){
		this.listings.remove(listing);
		listing.setHost(null);
		System.out.println("trying to remove listing");
		System.out.println(listing.getId());
	}

	public void addListing(Listing listing){
		this.listings.add(listing);
		listing.setHost(this);
		System.out.println("trying to remove listing");
		System.out.println(listing.getId());
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
}
