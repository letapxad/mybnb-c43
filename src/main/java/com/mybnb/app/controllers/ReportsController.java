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
public class ReportsController {

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
	
	@Autowired
	private RenterCommentHostRepository renterCommentHostRepo;
	
	@Autowired
    private RenterCommentListingRepository renterCommentListingRepo;
	
	@Autowired
    private HostCommentRenterRepository hostCommentRenterRepo;
	

    @GetMapping("reports")
    public String getReportsForm(Model model) {

    	return "booking_report";
    }
    
    @PostMapping("bookingsReport")
    public String getBookingReport(
      Model model, RedirectAttributes redirAttrs,
      @RequestParam(value="city", required=false) String city,
      @RequestParam(value="zipArea", required=false) String zipArea,
      @RequestParam(value="zipNum", required=false) String zipNum,
      @RequestParam(value="startDate", required=false) Date startDate,
      @RequestParam(value="endDate", required=false) Date endDate){
      
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT * FROM booking inner join listing l on listing_id=l.id ");
      sb.append(" where start_date >= '" + startDate + "' and end_date <=  '" + endDate + "' ");
      if(city.length() > 0)
        sb.append(" and l.city='" + city+ "'");
      if(zipArea.length()>0)
        sb.append(" and l.postal_code_area='" + zipArea +"'");
      if(zipNum.length() > 0)
        sb.append(" and l.postal_code_num='" + zipNum+ "'");

      List<Booking> bookings = bookingRepo.getBookingReport(sb.toString(), "");
      System.out.println(city);
      
      redirAttrs.addFlashAttribute("num", bookings.size());
      redirAttrs.addFlashAttribute("bookings", bookings);
    	return "redirect:reports";
    }


    @PostMapping("listingsReport")
    public String getListingReport(
      Model model, RedirectAttributes redirAttrs,
      @RequestParam(value="city", required=false) String city,
      @RequestParam(value="zipArea", required=false) String zipArea,
      @RequestParam(value="zipNum", required=false) String zipNum,
      @RequestParam(value="country", required=false) String country){
      
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT * FROM listing l where 1 ");
      if(country.length()>0)
        sb.append(" AND l.country='" + country + "'");
        if(city.length() > 0)
        sb.append(" AND l.city='" + city+ "'");
      if(zipArea.length()>0)
        sb.append(" AND l.postal_code_area='" + zipArea +"'");
      if(zipNum.length() > 0)
        sb.append(" AND l.postal_code_num='" + zipNum+ "'");
        System.out.println(sb.toString());
      List<Listing> listings = listingRepo.findByCustomQuery(sb.toString(), "");
        System.out.println(listings);
      System.out.println(city);
      System.out.println(listings.size());
      redirAttrs.addFlashAttribute("listingCount", listings.size());
      redirAttrs.addFlashAttribute("listings", listings);
    	return "redirect:reports";
//    @GetMapping("bookingsReport")
//    public String getBookingReport(Model model) {
//    	return "booking_report";
//    }
    }

    // select renter_id, count(*) as cancel_count from (select distinct renter_id,id  from booking WHERE cancelled_by="RENTER" start_date>='2020-01-01' and end_date<='2020-12-31') as t group by renter_id order by cancel_count desc;
//  select host_id, count(*) as cancel_count,h.* from (select distinct host_id,id  from booking WHERE cancelled_by="HOST" and start_date>='2020-01-01' and end_date<='2020-12-31') as t inner join host h on h.id=host_id group by host_id order by cancel_count desc;    
@PostMapping("cancelReport")
    public String getCancelReport(
      Model model, RedirectAttributes redirAttrs,
      @RequestParam(value="year", required=false) Number year){
      if(year == null) return "redirect:reports";
       StringBuilder qhost = new StringBuilder();
      //StringBuilder qrenter = new StringBuilder();
       qhost.append("select host_id, count(*),h.* from ");
       qhost.append("(select distinct host_id,id  from booking  WHERE boooking.cancelled_by='HOST' and start_date>='");
       qhost.append(year);
       qhost.append("-01-01' and end_date<='");
       qhost.append(year);
       qhost.append("-12-31')  as t ");
       qhost.append(" inner join host h on h.id=host_id group by host_id order by cancel_count desc");
    //    List<Booking> res = bookingRepo.getBookingReport("select distinct host_id,id  from booking  WHERE cancelled_by='HOST'", "");
        // List<Booking> res = bookingRepo.getBookingReport(qhost.toString(), "");
        List<Booking> res = bookingRepo.getBookigDax();
        System.out.println(res.get(0));
        System.out.println(qhost.toString());
        // System.out.println(res.get(0).getHost().getFirst_name());
    //   List<Listing> listings = listingRepo.findByCustomQuery(sb.toString(), "");
    //     System.out.println(listings);
    //   System.out.println(city);
    //   System.out.println(listings.size());
    //   redirAttrs.addFlashAttribute("listingCount", listings.size());
    //   redirAttrs.addFlashAttribute("hc", res);
    	return "redirect:reports";
//    @GetMapping("bookingsReport")
//    public String getBookingReport(Model model) {
//    	return "booking_report";
//    }
    }

}