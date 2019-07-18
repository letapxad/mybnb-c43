package com.mybnb.app.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int listing_id;
	private double longitude;
	private double latitude;
	private String type;
	private int street_num;
	private int street_name;
	private String unit;
	private String postal_code;
	private String country;
	private Date listed_on;
	private boolean active;
	private String name;

	@ManyToOne
	private Host host;
	
	@OneToMany(mappedBy="listing")
    private List<Availability> availabilities;
	
	@ManyToMany
	private List<Amenity> amenities;

	public int getListing_id() {
		return listing_id;
	}
	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStreet_num() {
		return street_num;
	}
	public void setStreet_num(int street_num) {
		this.street_num = street_num;
	}
	public int getStreet_name() {
		return street_name;
	}
	public void setStreet_name(int street_name) {
		this.street_name = street_name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getListed_on() {
		return listed_on;
	}
	public void setListed_on(Date listed_on) {
		this.listed_on = listed_on;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
