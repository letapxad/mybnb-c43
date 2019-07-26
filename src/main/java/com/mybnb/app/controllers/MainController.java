package com.mybnb.app.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.MatcherConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybnb.app.beans.ListingQuery;
import com.mybnb.app.models.Amenity;
import com.mybnb.app.models.Availability;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import com.mybnb.app.repository.AmenityRepository;
import com.mybnb.app.repository.AvailabilityRepository;
import com.mybnb.app.repository.BookingRepository;
import com.mybnb.app.repository.HostRepository;
import com.mybnb.app.repository.ListingRepository;
import com.mybnb.app.repository.RenterRepository;

@ControllerAdvice
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
	
	@Autowired
	private AvailabilityRepository availabilityRepo;
	
	@Autowired
	private AmenityRepository amenityRepo;
	
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
	
	@PostMapping("/addListing")
	public String saveListing(Model model, @RequestParam Listing listing) {
		listingRepo.save(listing);
		return "listings";
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
    public String createRenterForm(Model model, Renter renter) {//@RequestParam int SIN, @RequestParam(required=false) String first_name, @RequestParam(required=false) String last_name, @RequestParam(required=false) String occupation, @RequestParam(required=false) Long card_num, @RequestParam(required=false) Date exp_date) {
      renterRepo.save(renter);//renterRepo.insertRenter(SIN, first_name, last_name, occupation, true, 11, card_num, exp_date);
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
	  renterRepo.deactivateRenter(SIN);
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
      hostRepo.deactivateHost(SIN);
      return "redirect:deleteHost";
    }

    // not working
//    @GetMapping("/createListing")
//    public String createListingForm(Model  model, @RequestParam int host_id) {
////      System.out.println(host_sin + " "+ listing_id);
//        Host host = hostRepo.findByHostId(host_id);
//        
//        model.addAttribute("host", host);
//        //System.out.println(listing.getName());
//        return "create_listing";
//    }
    
    @PostMapping("/saveListing")
    public String createListingForm(Model model, 
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam double latitude,
        @RequestParam double longitude,
        @RequestParam String country,
        @RequestParam String city,
        @RequestParam String street_name,
        @RequestParam int street_num,
        @RequestParam int unit,
        @RequestParam String postal_code_area,
        @RequestParam String postal_code_num,
        @RequestParam Date listed_on,
        @RequestParam int host_id) {
      listingRepo.insertListing(name, type, latitude, longitude, country, city, street_name, street_num, unit, postal_code_area, postal_code_num, listed_on, host_id);
      //listingRepo.save(listing);
      return "redirect:createListing";
    }
    
    @GetMapping("/deleteListing")
    public String deleteListingForm(Model model) {
      return "delete_listing";
    }
    
    @PostMapping("/delListing")
    public String deleteListingForm(Model model, @RequestParam int id) {
      //Host host = hostRepo.findBySIN(SIN);
      listingRepo.deactivateListing(id);
      //hostRepo.deactivateHost(SIN);
      return "redirect:deleteListing";
    }
    
    @GetMapping("/allAvailableListings")
    public String getAvailableListings (Model model) {
      Iterable<Availability> listings = availabilityRepo.findAll();
      model.addAttribute("listings", listings);
      return "available_listings";
    }
    
    @GetMapping("/createBooking")
    public String createBookingForm(Model model) {
      return "create_booking";
    }
    
    @PostMapping("/saveBooking")
    public String createBookingForm(Model model, RedirectAttributes redirAttrs, @RequestParam int renter_id, @RequestParam int listing_id, @RequestParam(required=false) Date start_date, @RequestParam(required=false) Date end_date, @RequestParam float cost) {
      Iterable<Availability> listings = availabilityRepo.findAll();
      bookingRepo.insertBooking(renter_id, listing_id, start_date, end_date, cost, 10, "Booked");
      Listing listing = listingRepo.findByListingId(listing_id);
      availabilityRepo.deleteAvailability(start_date, listing);
      //availabilityRepo.deleteAvailability(end_date, listing);
      redirAttrs.addFlashAttribute("message", "This is message from flash");
      return "redirect:createBooking";
    }
    
    @GetMapping("/cancelBooking")
    public String cancelBookingForm(Model model) {
      return "cancel_booking";
    }
    
    @PostMapping("/canBooking")
    public String cancelBookingForm(Model model, @RequestParam int renter_id, @RequestParam int listing_id) {
      List<Booking> bookings = bookingRepo.fidnByRenterId(renter_id);
      Renter renter = renterRepo.findByRenterId(renter_id);
      Listing listing = listingRepo.findByListingId(listing_id);
      bookingRepo.cancelBooking(renter, listing);
      return "redirect:cancelBooking";
    }
    
    @GetMapping("/updatePricing")
    public String updatePricingForm(Model model) {
      return "update_pricing";
    }
    
    @PostMapping("/upPricing")
    public String updatePricingForm(Model model, @RequestParam float new_price, @RequestParam int listing_id) {
      Listing listing = listingRepo.findByListingId(listing_id);
      availabilityRepo.updatPricing(listing, new_price);
      return "redirect:updatePricing";
    }
    
    @GetMapping("/makeAvailable")
    public String makeAvailableForm(Model model) {
      return "make_availaible";
    }
    
    @PostMapping("/maAvailable")
    public String makeAvailableForm(Model model, @RequestParam Date new_date, @RequestParam float price, @RequestParam int listing_id) {
      Listing listing = listingRepo.findByListingId(listing_id);
      availabilityRepo.insertAvailability(new_date, price, listing_id);
      return "redirect:makeAvailable";
    }
    
    @GetMapping("/makeUnavailable")
    public String makeUnavailableForm(Model model) {
      return "make_unavailaible";
    }
    
    @PostMapping("/maUnavailable")
    public String makeUnavailableForm(Model model, @RequestParam Date date, @RequestParam int listing_id) {
      Listing listing = listingRepo.findByListingId(listing_id);
      availabilityRepo.deleteAvailability(date, listing);
      return "redirect:makeUnavailable";
    }
    
    // queries to support
    @GetMapping("searchListings")
    public String queryListingsForm(@ModelAttribute(name="lq") ListingQuery lq, BindingResult result,Model model) {
//    	System.out.println(lq);
    	System.out.println(result.getAllErrors());
//    		System.out.println(lq.getStreet_num());
//    		  boolean long_lat = false;
    	System.out.println(lq.getCheckin_date());
    	System.out.println();
    		StringBuilder qfilter = new StringBuilder();
    		boolean filtered = false;
    		if(lq.getCheckin_date() != null && lq.getCheckout_date() != null) {
    			filtered = true;
    			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    			String checkin = format.format(lq.getCheckin_date());
    			String checkout = format.format(lq.getCheckout_date());
    			
    			LocalDate cin = new LocalDate(checkin);
    			LocalDate cout = new LocalDate(checkout);
    			LocalDate curr = cin;
    			while(curr.isBefore(cout)) {
    				System.out.println(curr);
    				curr = curr.plusDays(1);
    			}
    			System.out.println(cin);
    			System.out.println(cout);
//    			qfilter.append( date+ )
    		}
    		System.out.println(lq.getMin_cost());
    		
    		if(lq.getMax_cost() != 0.0) {
    			filtered = true;
    			qfilter.append(" AND price >= " +  lq.getMin_cost() +" AND "+" price <= " + lq.getMax_cost());
//    			qfilter.append(" AND");
    		}
    		
    		if(lq.isPrice_low_to_high()) {
    			filtered = true;
    			qfilter.append(" ORDER BY price ASC");
    		} else {
    			qfilter.append(" ORDER BY price DESC");
    		}
//    		
//    		qfilter.append("AND 1");

    		  if(lq.getLatitude() != 0.0 && lq.getLongitude() != 0.0) {
    			  StringBuilder mqb = new StringBuilder();
    			  
    			  mqb.append("SELECT a.*,");
    			  if(filtered) {
    				  mqb.append("av.*,");
    			  }
    			  mqb.append("( 3959 * acos( cos( radians(" + lq.getLatitude() + ") ) "
    			  		+ " * cos( radians( latitude ) ) "
    			  		+ " * cos( radians( longitude ) "
    			  		+ " - radians(" + lq.getLongitude() + ") ) "
    			  		+ " + sin( radians(" + lq.getLatitude() +") ) "
    			  		+ " * sin( radians( latitude ) ) ) ) "
    			  		+ " AS distance ");
    			  mqb.append(" FROM Listing a ");
    					  
    			if(filtered) {
    				mqb.append(" inner join availability av on av.listing_id=a.id");
    			}
    	
    			  		mqb.append(" HAVING distance < " + lq.getDistance());
    			  
    			  
//    			  System.out.println(lq.getDistance());
//    			  System.out.println(lq.getLatitude());
//    			  List<Listing> listings = listingRepo.findByDistance(lq.getDistance(), lq.getLatitude(), lq.getLongitude());
    			  System.out.println(mqb.toString() + qfilter.toString());
    			  List<Listing> listings = listingRepo.findByCustomQuery(mqb.toString(), qfilter.toString());
    			  
    			  
    			  model.addAttribute("listings", listings);
    	          model.addAttribute("num", listings.size());
    	  
    	          
    	    	return "query_listings";
    			  
    		  } 
//    		  
//    		  if(lq.getCity() != null) {
//    		  
////    			  listing.setActive(true);
//    			  List<Listing> listings = listingRepo.findByAddress(lq.getStreet_num(), lq.getStreet_name(), lq.getCity(), lq.getCountry(), lq.getPostal_code_area(), lq.getPostal_code_num(), lq.isPrice_low_to_high());
//    					  model.addAttribute("listings", listings);
//    	          model.addAttribute("num", listings.size());
//    	          System.out.println("called by address method");
//    		  }
//    		  
//    		  List<Listing> listings = listingRepo.findByAdd();
//    		  
    		  
//    		  System.out.println(listings);
    		  
    		  // initialize a listing object
//    		  Listing listing = new Listing();
//    		  // we want only active listings
//        	  listing.setActive(true);
//        	  System.out.println(lq.getStreet_name());
//        	  if(lq.getStreet_name() != null && lq.getStreet_name().length()> 0) listing.setStreet_name(lq.getStreet_name());
//        	  if(lq.getStreet_num() > 0) listing.setStreet_num(lq.getStreet_num());
//        	  if(lq.getPostal_code_area()!= null && lq.getPostal_code_area().length()>0) listing.setPostal_code_area(lq.getPostal_code_area());
//        	  if(lq.getPostal_code_num() != null && lq.getPostal_code_num().length()>0) listing.setPostal_code_num(lq.getPostal_code_num());
//        	  if(lq.getCity() != null&& lq.getCity().length()>0) listing.setCity(lq.getCity());
//        	  if(lq.getCountry() != null && lq.getCountry().length()>0) listing.setCountry(lq.getCountry());
//        	          	  
//        	  ExampleMatcher matcher = null;
//        	  
//        		  if(lq.getStreet_num() == 0) {
//        			  matcher = ExampleMatcher.matching()
//    	        			  .withIgnorePaths("id","longitude","latitude","street_num")
//    	        			  .withIgnoreCase()
//    	        			  .withIgnoreNullValues();   
//        
//        		  } else {
//        			  matcher = ExampleMatcher.matching()
//    	        			  .withIgnorePaths("id","longitude","latitude")
//    	        			  .withIgnoreCase()
//    	        			  .withIgnoreNullValues();
//        			  
//        		  }
        	  
        	  
//        	 
//        	  SELECT first_name,
//        	          listing.id, 
//        	          ( 3959 * acos( cos( radians(43.779247) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(-79.251600) ) + sin( radians(43.779247) ) * sin( radians( latitude ) ) ) ) 
//        	          AS distance 
//        	          FROM listing a
//        	          inner join host 
//        	          on host_id=host.id 
//        	          HAVING distance  < 3 
//        	          ORDER BY distance;
        	  
        	  
        	  
//        	  System.out.println(matcher.getIgnoredPaths());
//        	  
//        	  Example<Listing> example = Example.of(listing, matcher);
//        	  
//        	  System.out.println(example);
//        	  
//        	  List<Listing> listings = listingRepo.findAll(example);
//        	System.out.println(listings.size());
//            model.addAttribute("listings", listings);
//            model.addAttribute("num", listings.size());
  
    	 
    	return "query_listings";
    }
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//    	System.out.println("binedr got called");
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }
    
    
//  queries to support
//    @PostMapping("searchListings")
//    public String queryListings(Model model, @ModelAttribute ListingQuery lq) {
//    	
//    	  if(lq!=null) {
//    		  Listing listing = new Listing();
//        	  listing.setActive(true);
//        	  if(lq.getCity() != null) listing.setCity(lq.getCity());
//        	  if (lq.getCountry() != null) listing.setCountry(lq.getCountry());
//        	  if(lq.getStreet_name() != null) listing.setStreet_name(lq.getStreet_name());
//        	  ExampleMatcher matcher = ExampleMatcher.matching();
//        	  
//        	  Example<Listing> example = Example.of(listing, matcher);
//        	  
//        	  List<Listing> listings = listingRepo.findAll(example);
//        	System.out.println(listings.size());
//            model.addAttribute("listings", listings);
//    	  }
//    	  System.out.println("lq was null");
//    	 
//    	return "query_listings";
//    }
    
    @GetMapping("bookingsReport")
    public String getBookingReport(Model model) {
    	return "booking_report";
    }
    
//    @GetMapping("bookingsReport")
//    public String getBookingReport(Model model) {
//    	return "booking_report";
//    }
    
    
}

