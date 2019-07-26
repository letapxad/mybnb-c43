package com.mybnb.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ListingId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	@ManyToOne
	  @JoinColumn(name="listing_id")
    private Host host;
 
    // default constructor
 
    public ListingId() {
    	
    }
    


	public ListingId(int id, Host host ) {
        this.setHost(host);
        this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Host getHost() {
		return host;
	}



	public void setHost(Host host) {
		this.host = host;
	}
 
    // equals() and hashCode()
}