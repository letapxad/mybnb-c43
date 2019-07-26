package com.mybnb.app.models;



import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
//@IdClass(CommentId.class)
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
  
    private String text;
 
	private java.util.Date addedOn;
	
	private float rating;
	
 	//@Id
 	@OneToOne
 	@JoinColumn(name="booking_id")
 	private Booking booking;
 	
 	//@ManyToOne
    //@JoinColumn(name="host_id")
    //private Host host;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	/*
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	*/
}
