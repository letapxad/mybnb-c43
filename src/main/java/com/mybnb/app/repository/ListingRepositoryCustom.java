package com.mybnb.app.repository;

import java.util.List;

import org.springframework.data.domain.Example;

import com.mybnb.app.models.Listing;

public interface ListingRepositoryCustom {
	void refresh(Listing  listing);
	
	List<Listing> findByCustomQuery(String mainQuery, String filters);

	public List<Object[]> findByListingQuery(String mainQuery);
}
