package com.mybnb.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.ManyToMany;

@Entity
//@IdClass(ListingId.class)
public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="host_id")
	private Host host;
	
	private double longitude;
	
	public List<Availability> getAvailabilities() {
    return availabilities;
  }
  public void setAvailabilities(List<Availability> availabilities) {
    this.availabilities = availabilities;
  }
  
  	
  
   private double latitude;
	private String type;
	private int street_num;
	private String street_name;
	private String unit;
	private String city;
	private String postal_code_area;
	private String postal_code_num;
	private String country;
	private Date listed_on;
	@Column(columnDefinition = "TINYINT")
	private boolean active;
	private String name;

	
	@OneToMany(mappedBy="listing")
    private List<Availability> availabilities;
	
	@ManyToMany
	private List<Amenity> amenities;
	
	public Listing(){
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
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
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
	public List<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}
	
	
	
//	static public class ListingId implements Serializable {
//	    /**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		
//		@GeneratedValue(strategy=GenerationType.IDENTITY)
//		private int id;
//		
//		
//	    private Host host;
//	 
//	    // default constructor
//	 
//	    public ListingId() {
//	    	
//	    }
//	    
//
//
//		public ListingId(int id, Host host ) {
//	        this.setHost(host);
//	        this.id = id;
//	    }
//
//		public int getId() {
//			return id;
//		}
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//
//		public static long getSerialversionuid() {
//			return serialVersionUID;
//		}
//
//
//
//		public Host getHost() {
//			return host;
//		}
//
//
//
//		public void setHost(Host host) {
//			this.host = host;
//		}
//	 
//	    // equals() and hashCode()
//	}
}
