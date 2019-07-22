package com.mybnb.app.models;

import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

public class UserId implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int SIN;
 
    // default constructor
 
    public UserId() {
    }

    public int getSIN() {
      return SIN;
    }

    public void setSIN(int sIN) {
      SIN = sIN;
    }

    // equals() and hashCode()
}