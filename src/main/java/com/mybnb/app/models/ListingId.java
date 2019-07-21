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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
    // equals() and hashCode()
}
