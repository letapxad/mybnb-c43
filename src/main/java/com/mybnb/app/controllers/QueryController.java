package com.mybnb.app.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.MatcherConfigurer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.data.domain.PageRequest;
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
import com.mybnb.app.repository.HostCommentRenterRepository;
import com.mybnb.app.repository.HostRepository;
import com.mybnb.app.repository.ListingRepository;
import com.mybnb.app.repository.RenterCommentHostRepository;
import com.mybnb.app.repository.RenterCommentListingRepository;
import com.mybnb.app.repository.RenterRepository;


@Controller
public class QueryController {

	@Autowired
    private ListingRepository listingRepo;
    
    @Autowired
    private AmenityRepository amenityRepo;
    
    @GetMapping("searchListings")
    public String queryForm(Model model){
        model.addAttribute("amenities", amenityRepo.findAll());

        return "query_listings";
    }


    @GetMapping("error")
    public String error(Model model){
        return "redirect:/";
    }

     // queries to support
     @PostMapping("getListings")
    // public String queryListingsForm(@ModelAttribute(name="lq") ListingQuery lq, BindingResult result,Model model) {
    public String queryListingsForm( Model model,
        RedirectAttributes redirectAttr,
        @RequestParam(value="street_num", required=false) Number street_num,
        @RequestParam(value="city", required=false) String city,
        @RequestParam(value="country", required=false) String country,
        @RequestParam(value="street_name", required=false) String street_name,
        @RequestParam(value="postal_code_area", required=false) String postal_code_area,
        @RequestParam(value="postal_code_num", required=false) String postal_code_num,
        @RequestParam(value="amenitiesList", required=false) List<String> amenitiesList,
        @RequestParam(value="checkin_date", required=false)  String checkin_date,
        @RequestParam(value="checkout_date", required=false)  String checkout_date,
        @RequestParam(value="latitude", required=false) Number latitude,
        @RequestParam(value="longitude", required=false) Number longitude,
        @RequestParam(value="distance", required=false) Number distance,
        @RequestParam(value="min_cost", required=false) Number min_cost,
        @RequestParam(value="max_cost", required=false) Number max_cost,
        @RequestParam(value="price_low_to_high", required=false) boolean price_low_to_high){
                    
        // check if there are coordinates are present
        System.out.println(latitude);
        System.out.println(street_name + street_name + city + country + postal_code_area + postal_code_num);
        StringBuilder mqb = new StringBuilder(); //main query builder
        mqb.append("SELECT a.*, av.* "); //all columns from 
        
        // sysout
        // if lat lon provided we need to one more column
        if (longitude != null && latitude != null){
            mqb.append(", ( 3959 * acos( cos( radians(" + latitude+ ") ) "
                + " * cos( radians( latitude ) ) "
                + " * cos( radians( longitude ) "
                + " - radians(" + longitude + ") ) "
                + " + sin( radians(" + latitude+") ) "
                + " * sin( radians( latitude ) ) ) ) "
                + " AS distance ");
        }
        
        
        mqb.append(" FROM Listing a "); // selecting the listing table
        mqb.append(" inner join Availability av on av.listing_id=a.id ");

        
        if(amenitiesList != null && amenitiesList.size() > 0){
            Iterator<String> amenities = amenitiesList.iterator();
            String alist = "(";
            while(amenities.hasNext()){
                alist += "'" + amenities.next()  +"',";
            }
            // System.out.println((alist));
            alist = alist.substring(0, alist.length() -1);
            // System.out.println((alist));
            alist += ")";
            // System.out.println((alist));
            mqb.append("  inner join listing_amenities la on la.amenities_name in " + alist + " ");

        }
        mqb.append(" having 1 ");
        // if there were lat lon then we need to filter by distance
        if(longitude != null && latitude != null){
            mqb.append("  and distance < " + distance);
        }

        if(street_num != null && street_num.toString() != "") mqb.append(" and street_num='" + street_num + "'");
        if(street_name != null && street_name != "") mqb.append(" and street_name='" + street_name+ "'");
        if(city!=null && city != "") mqb.append(" and city='" + city+ "'");
        if(country!=null && country!= "") mqb.append(" and country='" + country+ "'");
        if(postal_code_area!=null && postal_code_area!= "") mqb.append(" and postal_code_area='" + postal_code_area+ "'");
        if(postal_code_num!= null && postal_code_num!= "") mqb.append(" and postal_code_num='" + postal_code_num+ "'");
        if(max_cost != null && min_cost != null) {
            mqb.append(" AND price >= " +  min_cost +" AND "+" price <= " + max_cost);
        }
        
        System.out.println(checkin_date);
        if(checkin_date != null && checkout_date != null 
            && checkin_date != "" && checkout_date != ""){
            mqb.append(" AND date>='" + checkin_date +"'");
            mqb.append(" AND date<='" + checkout_date +"'");

        }
        if(price_low_to_high) {
            mqb.append(" ORDER BY av.price ASC");
        } else {
            mqb.append(" ORDER BY av.price DESC");
        }

        // String q = "select distinct id from (" + mqb.toString() + ") as t";
        System.out.println(mqb.toString());

        List<Object[]> custom_result = listingRepo.findByListingQuery(mqb.toString());
        if(custom_result.isEmpty()){
            redirectAttr.addFlashAttribute("message","No listings found");
            // redirectAttr.addFlashAttribute("amenities",  amenityRepo.findAll());

            return "redirect:searchListings";
        }

        Iterator<Object[]> result_set = custom_result.iterator();
        while(result_set.hasNext()){
            Object res = result_set.next();
            System.out.println(res);
        }
        

        

        // if there were coord show distance////
        custom_result.iterator();
        // listingRepo.findByForListingQuery(mqb.toString());
        // List<Object[]> res = listingRepo.findForQuery(mqb.toString());
        // List<Integer> listings = listingRepo.findByCustomQuery(q, "");
        // List<Object[]> listings = listingRepo.findByForListingQuery(mqb.toString());

        // List<Object[]> listings = listingRepo.findByForListingQuery(q);
        // System.out.println(q);
        // List<Object[]> lints = listingRepo.findForQuery(mqb.toString());
        // List<Listing> ls = listingRepo.findAll();
        // model.addAttribute("listings", listings);
        // sent all available amenities
        // model.addAttribute("ls", ls);
        // redirectAttr.addFlashAttribute("amenities",  amenityRepo.findAll());
// ;        model.addAttribute("amenities", amenityRepo.findAll());
        return "redirect:searchListings";

        //    	System.out.println(lq);
        //  System.out.println(result.getAllErrors());
 //    		System.out.println(lq.getStreet_num());
 //    		  boolean long_lat = false;

//         System.out.println(lq.getAmenitiesList());
        
//         // Iterator<String> res = iterator;
//         // Iterator<String> it = lq.getAmenitiesList().iterator();
//         // while(it.hasNext()){
//         //     System.out.println(it.next());
//         // }
//         //  System.out.println(lq.getCheckin_date());
//          System.out.println();
//              StringBuilder qfilter = new StringBuilder();
//              boolean filtered = false;
//              if(lq.getCheckin_date() != null && lq.getCheckout_date() != null) {
//                  filtered = true;
//                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                  String checkin = format.format(lq.getCheckin_date());
//                  String checkout = format.format(lq.getCheckout_date());
//                  // get dates
//                  LocalDate cin = new LocalDate(checkin);
//                  LocalDate cout = new LocalDate(checkout);
//                  LocalDate curr = cin;
//                  while(curr.isBefore(cout)) {
//                      System.out.println(curr);
//                      curr = curr.plusDays(1);
//                  }
//                  System.out.println(cin);
//                  System.out.println(cout);
//  //    			qfilter.append( date+ )
//              }
//              System.out.println(lq.getMin_cost());
             
//              if(lq.getMax_cost() != 0.0) {
//                  filtered = true;
//                  qfilter.append(" AND price >= " +  lq.getMin_cost() +" AND "+" price <= " + lq.getMax_cost());
//  //    			qfilter.append(" AND");
//              }
             
//              if(lq.isPrice_low_to_high()) {
//                  filtered = true;
//                  qfilter.append(" ORDER BY price ASC");
//              } else {
//                  qfilter.append(" ORDER BY price DESC");
//              }
//  //    		
//  //    		qfilter.append("AND 1");
 
//                if(lq.getLatitude() != 0.0 && lq.getLongitude() != 0.0) {
//                    StringBuilder mqb = new StringBuilder();
                   
//                    mqb.append("SELECT a.*,");
//                    if(filtered) {
//                        mqb.append("av.*,");
//                    }
//                    mqb.append("( 3959 * acos( cos( radians(" + lq.getLatitude() + ") ) "
//                            + " * cos( radians( latitude ) ) "
//                            + " * cos( radians( longitude ) "
//                            + " - radians(" + lq.getLongitude() + ") ) "
//                            + " + sin( radians(" + lq.getLatitude() +") ) "
//                            + " * sin( radians( latitude ) ) ) ) "
//                            + " AS distance ");
//                    mqb.append(" FROM Listing a ");
                           
//                  if(filtered) {

//                      mqb.append(" inner join availability av on av.listing_id=a.id");
//                  }
         
//                            mqb.append(" HAVING distance < " + lq.getDistance());
                   
                   
//  //    			  System.out.println(lq.getDistance());
//  //    			  System.out.println(lq.getLatitude());
//  //    			  List<Listing> listings = listingRepo.findByDistance(lq.getDistance(), lq.getLatitude(), lq.getLongitude());
//                    System.out.println(mqb.toString() + qfilter.toString());
//                    List<Listing> listings = listingRepo.findByCustomQuery(mqb.toString(), qfilter.toString());
                   
//                    model.addAttribute("listings", listings);
//                    model.addAttribute("num", listings.size());
           
//                    Iterable<Amenity> res = amenityRepo.findAll();
//                    System.out.println(res.iterator().next());
//                   model.addAttribute("amenities", res);
//                  return "query_listings";
                   
//                } 
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
   
        //  Iterable<Amenity> res = amenityRepo.findAll();
        //  System.out.println(res.iterator().next());
        // model.addAttribute("amenities", res);
        //  return "query_listings";
     }
     
}