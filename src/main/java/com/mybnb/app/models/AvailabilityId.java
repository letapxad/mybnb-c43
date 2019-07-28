package com.mybnb.app.models;

import java.io.Serializable;
import java.sql.Date;

public class AvailabilityId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;
	
	private Listing listing;

    public AvailabilityId() {
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public Listing getListing() {
      return listing;
    }

    public void setListing(Listing listing) {
      this.listing = listing;
    }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + ((listing == null) ? 0 : listing.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AvailabilityId other = (AvailabilityId) obj;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (listing == null) {
      if (other.listing != null)
        return false;
    } else if (!listing.equals(other.listing))
      return false;
    return true;
  }
 
    // default constructor

    // equals() and hashCode()
}
