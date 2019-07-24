package com.mybnb.app.models;

import java.io.Serializable;
import java.sql.Date;

public class AvailabilityId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;
	
	private Listing listing;

    public AvailabilityId() {
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public Listing getListing() {
      return listing;
    }

    public void setListing(Listing listing) {
      this.listing = listing;
    }
 
    // default constructor

    // equals() and hashCode()
}
