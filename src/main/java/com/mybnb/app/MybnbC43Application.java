package com.mybnb.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;
import com.mybnb.app.models.User;
import com.mybnb.app.repository.HostRepository;
import com.mybnb.app.repository.ListingRepository;
import com.mybnb.app.repository.RenterRepository;

@SpringBootApplication
public class MybnbC43Application implements  ApplicationRunner{

	@Autowired
	private HostRepository hostRepository;
	@Autowired
	private RenterRepository renterRepository;
	
	@Autowired
	private ListingRepository listingRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MybnbC43Application.class, args);
	}
	
   @Override
   public void run(ApplicationArguments arg0) {
      
	   System.out.println("Seeding data...");
	   
	   
	   this.insertRenters(25);
	   // creates 15 hosts with random amount of listing
	   // from 0 to 5 per host
	   this.insertHostsAndListing(15, 5);
	   // insert 25 renters
//       this.createBookings()
              
}
   
   private void insertHostsAndListing(int host_count, int listing_count) {
	   for(int i = 0; i < host_count; i++) {
		   Host host = this.insertOneHost();
		   for(int j = 0; j < new Random().nextInt(listing_count); j++) {
			   this.insertOneListing(host);
		   }
	   }
   }
   
   private void insertRenters(int renter_count) {
	   for(int i = 0; i < renter_count; i++) {
		  insertOneRenter();
	   }
   }
   
   // inserts 1 renter 
   private Renter insertOneRenter() {
	   Renter renter = new Renter();
	   int ssn = 100000000 + new Random().nextInt(899999999);
	   renter.setSIN(ssn);
	   renter.setActive(true);
	   renter.setFirst_name(new Faker().name().firstName());
	   renter.setLast_name(new Faker().name().lastName());
	   renter.setOccupation(new Faker().job().title());
	   renterRepository.save(renter);
	   return renterRepository.findById(renter.getSIN()).orElse(null);
   }
   
   
//   private Booking createOneBooking(Renter renter, Listing listing) {
//	   	
//	   
//	   return null;
//   }
   private Host insertOneHost() {
	   Host host = new Host();
	   int ssn = 100000000 + new Random().nextInt(899999999);
	   host.setSIN(ssn);
	   host.setActive(true);
	   host.setFirst_name(new Faker().name().firstName());
	   host.setLast_name(new Faker().name().lastName());
	   host.setOccupation(new Faker().job().title());
	   hostRepository.save(host);
	   Host host1 = hostRepository.findById(host.getId()).orElse(null);
	   if(host1 == null) {
		   System.out.println("HOST NOT SAVED");
		   return null;
	   }
	   
	   return hostRepository.findById(host.getId()).orElse(null);
   }
   
   private void insertOneListing(Host host) {
	   ArrayList<String> types = new ArrayList<>();
	   types.add("Full House");
	   types.add("Room");
	   types.add("Apartment");
	   
	   
	   Listing listing = new Listing();
	   listing.setActive(true);
	   listing.setCountry(new Faker().address().country());
	   listing.setLatitude((Float.parseFloat(new Faker().address().latitude())));
	   listing.setLongitude((Float.parseFloat(new Faker().address().longitude())));
	   listing.setListed_on(new Faker().date().past(5, TimeUnit.HOURS));
	   listing.setName(new Faker().lorem().sentence(5));
	   //listing.setPostal_code(new Faker().address().zipCode());
	   listing.setStreet_name(new Faker().address().streetName());
	   listing.setStreet_num(Integer.parseInt(new Faker().address().streetAddressNumber()));
	   listing.setUnit(new Faker().address().buildingNumber());
//	   listing.setHost(host);
	   listing.setType(types.get(new Random().nextInt(types.size() - 1)));
	   listingRepository.save(listing);
   }
   
//   private void insertListings() {
//	   
//	   // for all hosts present
//	   Iterable<Host> res = hostRepository.findAll();
//	   Iterator<Host> hosts = res.iterator();
//	   ArrayList<Integer> ints = new ArrayList<>();
//	   ArrayList<Host> hh = new ArrayList<>();
//	   // get all host ids
//	   while(hosts.hasNext()) {
//		   Host host =  hosts.next();
//		   ints.add(host.getSIN());
//		   hh.add( host);
//		   
//	   }
//
//	   ArrayList<String> types = new ArrayList<>();
//	   types.add("Full House");
//	   types.add("House");
//	   types.add("Room");
//	   types.add("Apartment");
//	   // num of listings have to be less than
//	   // or equal to hosts so
//	   int limit = hh.size();
//	   for(int i = 0; i < limit; i++) {
//		   // chose an index from 0 to length
//		   // of the host_ids
//		   int index = new Random().nextInt(limit-1);
//		   Listing listing = new Listing();
//		   listing.setActive(true);
//		   listing.setCountry(new Faker().address().country());
//		   listing.setLatitude((Float.parseFloat(new Faker().address().latitude())));
//		   listing.setLongitude((Float.parseFloat(new Faker().address().longitude())));
//		   listing.setListed_on(new Faker().date().past(5, TimeUnit.HOURS));
//		   listing.setName(new Faker().lorem().sentence(5));
//		   listing.setPostal_code(new Faker().address().zipCode());
//		   listing.setStreet_name(new Faker().address().streetName());
//		   listing.setStreet_num(Integer.parseInt(new Faker().address().streetAddressNumber()));
//		   listing.setUnit(new Faker().address().buildingNumber());
//		   listing.setHost(hostRepository.findById(ints.get(new Random().nextInt(ints.size()-1))).orElse(null));
//		   listing.setType(types.get(new Random().nextInt(types.size() - 1)));
//		   listingRepository.save(listing);
//	   }
//	   
//	   
//   }

}
