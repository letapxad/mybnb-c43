package com.mybnb.app.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Amenity {
  
  private enum Names {Towel, Bed_sheets, Soap, Toilet_paper, Pillows, Wifi, 
    Shampoo, Closet, Drawers, TV, Heat, Air_conditioning, Breakfast, 
    Coffee, Tea, Desk, Fireplace, Iron, Hair_dryer, Private_entrance, 
    Smoke_detector, Carbon_monoxide_detector, First_aid_kit, 
    Fire_extinguisher, Lock_on_bedroom_door;}
  
  @Id
  @Enumerated(EnumType.STRING)
  private Names name;
  
  @ManyToMany(mappedBy="aminities")
  private List<Listing> listings;
  
  public List<Listing> getListings() {
	return listings;
}
public void setListings(List<Listing> listings) {
	this.listings = listings;
}
public Names getName() {
    return name;
  }
  public void setName(Names name) {
    this.name = name;
  }
  
}
