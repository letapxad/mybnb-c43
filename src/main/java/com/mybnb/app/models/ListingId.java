package com.mybnb.app.models;

import java.io.Serializable;

public class ListingId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
 
    private Host host;
 
    // default constructor
 
    public ListingId(int id, Host host) {
        this.host = host;
        this.id = id;
    }
 
    // equals() and hashCode()
}
