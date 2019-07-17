package com.mybnb.app.models;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Renter extends User {
	
	private Long card_num;
	private Date exp_date;
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
