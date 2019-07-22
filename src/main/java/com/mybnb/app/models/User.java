package com.mybnb.app.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@IdClass(UserId.class)
public class User {
	
	@Id
	private int SIN;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	private String last_name;
	private String occupation;
	@Column(columnDefinition = "TINYINT")
	private Boolean active;
	
	public int getSIN() {
		return SIN;
	}
	public void setSIN(int sIN) {
		SIN = sIN;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
