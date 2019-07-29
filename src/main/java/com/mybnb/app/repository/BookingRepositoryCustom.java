package com.mybnb.app.repository;

import java.util.List;

import com.mybnb.app.models.Booking;

public interface BookingRepositoryCustom {
	void refresh(Booking booking);
	
	List<Booking> getBookingReport(String mq, String f);

	public List<Object> getCancelReport(String q);
}
