package com.mybnb.app.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Renter extends User {
	
	private Long card_num;
	private Date exp_date;
	
	@OneToMany(mappedBy = "renter", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings;
	
//	 @OneToMany
//	 private List<RenterCommentListing> comments;
	
	public Long getCard_num() {
		return card_num;
	}
	public void setCard_num(Long card_num) {
		this.card_num = card_num;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
}
