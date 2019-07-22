package com.mybnb.app.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import com.mybnb.app.repository.BookingRepository;
import com.mybnb.app.repository.HostRepository;
import com.mybnb.app.repository.ListingRepository;
import com.mybnb.app.repository.RenterRepository;

@Controller
public class MainController {
	@Autowired
	private ListingRepository listingRepo;
	
	@Autowired
	private HostRepository hostRepo;

	@Autowired
    private RenterRepository renterRepo;
	
	@Autowired
    private BookingRepository bookingRepo;
	
	@GetMapping("/hosts")
	public String index(Model model) {
		Iterable<Host> hosts = hostRepo.findAll();
		model.addAttribute("hosts",hosts );
		return "index";
	}

	@GetMapping("/listing")
	public String getListing(Model  model, @RequestParam int listing_id) {
//		System.out.println(host_sin + " "+ listing_id);
		Listing listing = listingRepo.findByListingId(listing_id);
		
		model.addAttribute("listing", listing);
		System.out.println(listing.getName());
		return "listing";
	}
	
	@GetMapping("/renters")
	public String getRenters (Model model) {
	  Iterable<Renter> renters = renterRepo.findAll();
      model.addAttribute("renters", renters);
      return "renter";
	}
	
	@GetMapping("/booking")
    public String getBooking(Model  model, @RequestParam int booking_id) {
//      System.out.println(host_sin + " "+ listing_id);
        Booking booking = bookingRepo.findByBookingId(booking_id);
        model.addAttribute("booking", booking);
        return "booking";
    }
	 
	@GetMapping("/listings")
	public String getListingForm(Model model, @RequestParam(required=false) int street_num, @RequestParam(required=false) String street_name, @RequestParam(required=false) String unit) {
		
		Listing listing = listingRepo.findByAddress(unit, street_num, street_name);
		model.addAttribute("listing", listing);
		
		return "listings";
	}
	
	@GetMapping("/createHost")
	public String createHostForm(Model model) {
//	  hostRepo.insertHost(SIN, first_name, last_name, occupation, true, 10);
	  //model.addAttribute("hosts",hostRepo.findAll());
	  return "create_host";
	}
	
	@PostMapping("/saveHost")
    public String createHostForm(Model model, @RequestParam int SIN, @RequestParam(required=false) String first_name, @RequestParam(required=false) String last_name, @RequestParam(required=false) String occupation) {
      hostRepo.insertHost(SIN, first_name, last_name, occupation, true, 10);
      
      
      return "redirect:createHost";
    }
	
	
	
}
