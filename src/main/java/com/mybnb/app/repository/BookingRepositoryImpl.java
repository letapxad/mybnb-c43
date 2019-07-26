package com.mybnb.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.mybnb.app.models.Booking;

public class BookingRepositoryImpl implements BookingRepositoryCustom{
	 @PersistenceContext
	 public EntityManager em;

	@Transactional
	@Override
	public void refresh(Booking booking) {
		// TODO Auto-generated method stub
		
	}

}
