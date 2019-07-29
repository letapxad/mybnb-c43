package com.mybnb.app.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.lang.reflect.Array;
import java.math.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.apache.commons.collections4.IterableUtils;
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
import org.thymeleaf.expression.Arrays;

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


    @PostMapping("hostReport")
    public String hostReport(
      Model model, RedirectAttributes redirAttrs,
      @RequestParam(value="start_date", required=true) String start_date,
      @RequestParam(value="end_date", required=true) String end_date,
      @RequestParam(value="city", required=false) String city){
        System.out.println(city);
        System.out.println(start_date);
        Iterable<Renter> renters = null;
        List<Integer> ranks = new ArrayList<Integer>();
        if(city==null || city.equals("")){
          List<Object[]> result = bookingRepo.rankRentersByBookingCount(start_date, end_date);
          List<Integer> renter_ids = new ArrayList<Integer>();
          for(Object[] cancels: result){
            Integer renter_id = (Integer)cancels[0];
            renter_ids.add(renter_id);
            Integer count =  (Integer.parseInt(cancels[1].toString()));
            ranks.add(count);
          }

          System.out.println(renter_ids);
          renters = renterRepo.findAllById(renter_ids);

        } else {

        List<Object[]> result = bookingRepo.rankRentersByBookingCountInCity(start_date, end_date, city);
        
        redirAttrs.addFlashAttribute("city", city);
        List<Integer> renter_ids = new ArrayList<Integer>();
          for(Object[] cancels: result){
            Integer renter_id = (Integer)cancels[0];
            renter_ids.add(renter_id);
            Integer count =  (Integer.parseInt(cancels[1].toString()));
            ranks.add(count);
          }
          System.out.println(renter_ids);
          renters = renterRepo.findAllById(renter_ids);
        }
         
          ArrayList<Renter> rlist = (ArrayList<Renter>) IterableUtils.toList(renters);
          System.out.println(rlist);
          // Arrays.
          redirAttrs.addFlashAttribute("sdate", start_date);
          redirAttrs.addFlashAttribute("edate", end_date);

          redirAttrs.addFlashAttribute("rank", ranks);
          redirAttrs.addFlashAttribute("rentersrank", rlist);

      return "redirect:reports";
    }


    // select renter_id, count(*) as cancel_count from (select distinct renter_id,id  from booking WHERE cancelled_by="RENTER" start_date>='2020-01-01' and end_date<='2020-12-31') as t group by renter_id order by cancel_count desc;
//  select host_id, count(*) as cancel_count,h.* from (select distinct host_id,id  from booking WHERE cancelled_by="HOST" and start_date>='2020-01-01' and end_date<='2020-12-31') as t inner join host h on h.id=host_id group by host_id order by cancel_count desc;    
@PostMapping("cancelReport")
    public String getCancelReport(
      Model model, RedirectAttributes redirAttrs,
      @RequestParam(value="year", required=false) Number year){


        List<Integer> resss = bookingRepo.findByRenterDistinctRId(1);
        System.out.println(resss); 
      if(year == null) return "redirect:reports";
       StringBuilder qhost = new StringBuilder();
      //StringBuilder qrenter = new StringBuilder();
       qhost.append("select host_id, count(*) ,h from ");
       qhost.append("(select distinct host_id,id  from booking  WHERE id=1 and start_date>='");
       qhost.append(year);
       qhost.append("-01-01' and end_date<='");
       qhost.append(year);
       qhost.append("-12-31')  as t ");
       qhost.append(" inner join host h on h.id=host_id group by host_id order by count(*) desc");
    
        // String temp = "select renter_id,count(*) as cancel_count from Booking b where status='Cancelled' and cancelled_by='RENTER' group by b.renter_id  order by cancel_count  desc";
        List<Object[]> result = bookingRepo.getRenterCancellation();
        List<Object[]> hostResult = bookingRepo.getHostCancellation();

        List<Integer> renter_ids = new ArrayList<Integer>();
        List<Integer> counts = new ArrayList<Integer>();
        for(Object[] cancels: result){
          Integer renter_id = (Integer)cancels[0];
          renter_ids.add(renter_id);
          Integer count =  (Integer.parseInt(cancels[1].toString()));
          counts.add(count);
       }

       List<Integer> host_ids = new ArrayList<Integer>();
        List<Integer> host_counts = new ArrayList<Integer>();
        for(Object[] cancels: hostResult){
          Integer host_id = (Integer)cancels[0];
          host_ids.add(host_id);
          Integer host_count =  (Integer.parseInt(cancels[1].toString()));
          host_counts.add(host_count);
       }

        // get all renters
         Iterable<Renter> renters =  renterRepo.findAllById(renter_ids);
         Iterable<Host> hosts =  hostRepo.findAllById(host_ids);

        //  Map<Renter,Integer> renter_map = new HashMap<Renter,Integer>();
        //   while (itr.hasNext() && cancel_counts.hasNext()) {
        //       Renter r = itr.next();
        //       Integer c = cancel_counts.next(); 
        //       System.out.println(r.getId()+ " " + c); 
        //       renter_map.put(r,c);
        //   }
          // renters.iterator()
          // model.addAttribute("renterCancels", renter_map);
          redirAttrs.addFlashAttribute("renters",  renters.iterator());
          redirAttrs.addFlashAttribute("hosts", hosts.iterator());
          // System.out.println(result.get(0));
        // Iterator<Object[]> can_iterator = result.iterator();
        // while(can_iterator.hasNext()){
        //   Object intt = can_iterator.next();
        //   System.out.println((List<Integer>) intt);
        // }
        //    List<Booking> res = bookingRepo.getBookingReport("select distinct host_id,id  from booking  WHERE cancelled_by='HOST'", "");
    // List<Booking> res = bookingRepo.getBookingReport(qhost.toString(), "");
        // List<Booking> res = bookingRepo.getBookigDax();
        // System.out.println(res.get(0));
        // System.out.println(qhost.toString());
          // List<Object> res = bookingRepo.getCancelReport(qhost.toString());
          // System.out.println(res);
        // System.out.println(res.get(0).getHost().getFirst_name());
      // List<Listing> listings = listingRepo.findByCustomQuery(sb.toString(), "");
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

    private class RenterResult{
        public Renter renter;
        public int rank;
        public String sdate;
        public String edate;
    }

    @PostMapping("renterBookingRank")
    public String getRenterBookingRank(
      Model model, RedirectAttributes redirAttrs,
      
      @RequestParam(value="start_date", required=true) String start_date,
      @RequestParam(value="end_date", required=true) String end_date,
      @RequestParam(value="city", required=false) String city){
        System.out.println(city);
        System.out.println(start_date);
        // ArrayList<RenterResult> rr = new ArrayList<RenterResult>();
        Iterable<Renter> renters = null;
        List<Integer> ranks = new ArrayList<Integer>();
        if(city==null || city.equals("")){
          List<Object[]> result = bookingRepo.rankRentersByBookingCount(start_date, end_date);
          List<Integer> renter_ids = new ArrayList<Integer>();
          for(Object[] cancels: result){
            Integer renter_id = (Integer)cancels[0];
            renter_ids.add(renter_id);
            Integer count =  (Integer.parseInt(cancels[1].toString()));
            ranks.add(count);
          }

          System.out.println(renter_ids);
          renters = renterRepo.findAllById(renter_ids);

        } else {

        List<Object[]> result = bookingRepo.rankRentersByBookingCountInCity(start_date, end_date, city);
        
        redirAttrs.addFlashAttribute("city", city);
        List<Integer> renter_ids = new ArrayList<Integer>();
          for(Object[] cancels: result){
            Integer renter_id = (Integer)cancels[0];
            renter_ids.add(renter_id);
            Integer count =  (Integer.parseInt(cancels[1].toString()));
            ranks.add(count);
          }
          System.out.println(renter_ids);
          renters = renterRepo.findAllById(renter_ids);
        }
         
          // List<Renter> rlist = IterableUtils.toList(renters);    
          redirAttrs.addFlashAttribute("sdate", start_date);
          redirAttrs.addFlashAttribute("edate", end_date);

          redirAttrs.addFlashAttribute("rank", ranks);
          redirAttrs.addFlashAttribute("rentersrank", renters);

      return "redirect:reports";
    }

}