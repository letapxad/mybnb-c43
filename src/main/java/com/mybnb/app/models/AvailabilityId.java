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
 
    // default constructor
 
    public AvailabilityId(Listing listing) {
        this.listing = listing;
    }
 
    // equals() and hashCode()
}
