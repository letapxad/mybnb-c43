package com.mybnb.app.controllers;

import java.sql.Date;
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
    public String createHostForm1(Model model, Host host) {
//    hostRepo.insertHost(SIN, first_name, last_name, occupation, true);
      hostRepo.save(host);
      
      return "redirect:createHost";
    }
	
	
	@GetMapping("/createRenter")
    public String createRenterForm(Model model) {
//    hostRepo.insertHost(SIN, first_name, last_name, occupation, true, 10);
      //model.addAttribute("hosts",hostRepo.findAll());
      return "create_renter";
    }
	
	@PostMapping("/saveRenter")
    public String createRenterForm(Model model, @RequestParam int SIN, @RequestParam(required=false) String first_name, @RequestParam(required=false) String last_name, @RequestParam(required=false) String occupation, @RequestParam(required=false) Long card_num, @RequestParam(required=false) Date exp_date) {
      renterRepo.insertRenter(SIN, first_name, last_name, occupation, true, 11, card_num, exp_date);
      return "redirect:createRenter";
    }
	
	@GetMapping("/deleteRenter")
	public String deleteRenterForm(Model model) {
	  return "delete_renter";
	}
	
	@PostMapping("/delRenter")
	public String deleteRenterForm(Model model, @RequestParam int SIN) {
	  Renter renter = renterRepo.findBySIN(SIN);
	  bookingRepo.cancelAllBooking(renter);
	  renterRepo.deleteRenter(SIN);
      return "redirect:deleteRenter";
	}
	
	@GetMapping("/deleteHost")
    public String deleteHostForm(Model model) {
      return "delete_host";
    }
    
    @PostMapping("/delHost")
    public String deleteHostForm(Model model, @RequestParam int SIN) {
      Host host = hostRepo.findBySIN(SIN);
      listingRepo.deactivateAllListing(host);
      hostRepo.deleteHost(SIN);
      return "redirect:deleteHost";
    }
    
    @GetMapping("/createListing")
    public String createListingForm(Model  model, @RequestParam int host_id) {
//      System.out.println(host_sin + " "+ listing_id);
        Host host = hostRepo.findByHostId(host_id);
        
        model.addAttribute("host", host);
        //System.out.println(listing.getName());
        return "create_listing";
    }
    
    @PostMapping("/saveListing")
    public String createListingForm(Model model, @RequestParam Listing listing) {
      listingRepo.save(listing);
      return "redirect:createListing";
    }
}
