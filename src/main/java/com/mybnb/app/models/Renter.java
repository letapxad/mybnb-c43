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
    @Column(nullable = false)
	private Long card_num;
    @Column(nullable = false)
	private Date exp_date;
	
	@OneToMany(cascade=CascadeType.REMOVE, 
        fetch = FetchType.LAZY, 
        mappedBy = "renter")
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

	public int getDistinctCancelledCount(){
		int res = 0;
		System.out.println(this.bookings);
		for(Booking b: this.bookings){
			System.out.println(b.getCancelled_by()=="RENTER");
			System.out.println(b.getStatus().equals(Booking.Status.Cancelled));

			if(b.getCancelled_by().equals("RENTER") && b.getStatus().equals(Booking.Status.Cancelled)){
				res += 1;
			System.out.println("found");

			}
		}
		return res;
	}





}
