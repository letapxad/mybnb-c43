package com.mybnb.app.models;

import java.io.Serializable;

public class CommentId implements Serializable {
	private Booking booking;
 	
 	public CommentId(Booking booking) {
 		this.setBooking(booking);
}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
