package com.mybnb.app.beans;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybnb.app.models.Amenity;


public class ListingQuery {
	
//	private List<Amenity> amenities;
	
	private int street_num;
	
	private String street_name;
	
	private String city;
	
	private String country;
	
	private String postal_code_area;
	
	private String postal_code_num;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout_date;

//	@Min(-180)
//	@Max(180)
	@NumberFormat(pattern="###.####")
	private double longitude;
	
//	@Min(-90)
//	@Max(90)
	@NumberFormat(pattern="###.####")
	private double latitude;
	
	@Min(1)
	private int distance;
	
	@Min(0)
	private double min_cost;
	
	@Min(1000000)
	private double max_cost;
	
	private boolean price_low_to_high;

//	public List<Amenity> getAmenities() {
//		return amenities;
//	}
//
//	public void setAmenities(List<Amenity> amenities) {
//		this.amenities = amenities;
//	}

	public int getStreet_num() {
		return street_num;
	}

	public void setStreet_num(int street_num) {
		this.street_num = street_num;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code_area() {
		return postal_code_area;
	}

	public void setPostal_code_area(String postal_code_area) {
		this.postal_code_area = postal_code_area;
	}

	public String getPostal_code_num() {
		return postal_code_num;
	}

	public void setPostal_code_num(String postal_code_num) {
		this.postal_code_num = postal_code_num;
	}

	public Date getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getMin_cost() {
		return min_cost;
	}

	public void setMin_cost(double min_cost) {
		this.min_cost = min_cost;
	}

	public double getMax_cost() {
		return max_cost;
	}

	public void setMax_cost(double max_cost) {
		this.max_cost = max_cost;
	}

	public boolean isPrice_low_to_high() {
		return price_low_to_high;
	}

	public void setPrice_low_to_high(boolean price_low_to_high) {
		this.price_low_to_high = price_low_to_high;
	}
	
}
