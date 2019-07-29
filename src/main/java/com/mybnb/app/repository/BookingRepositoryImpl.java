package com.mybnb.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.mybnb.app.models.Booking;

public class BookingRepositoryImpl implements BookingRepositoryCustom {
	 
	@PersistenceContext
	 public EntityManager em;

	@Transactional
	@Override
	public void refresh(Booking booking) {
		// TODO Auto-generated method stub
		em.refresh(booking);

	}

	@Override
	public List<Booking> getBookingReport(String mq, String f) {
		Query query = em.createNativeQuery(mq + f, Booking.class);
    	List<Booking> res =  query.getResultList();
    	return res;
	}

	@Override
	public List<Object> getCancelReport(String q){
		TypedQuery<Object> tq = em.createQuery(q, Object.class);
		return tq.getResultList();

	}


}
