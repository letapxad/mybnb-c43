package com.mybnb.app.models;

import java.io.Serializable;
 public class RenterCommentListingId implements Serializable{
	
// 	/**
// 	 * 
// 	 */
 	private static final long serialVersionUID = 1L;
 	private Booking booking;
 	
// 	private Renter renter;
	
 	public RenterCommentListingId(Booking booking) {
 		this.booking = booking;
// 		this.renter = renter;
}
	
 }
