package com.mybnb.app.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.repository.HostRepository;
import com.mybnb.app.repository.ListingRepository;

@Controller
public class MainController {
	@Autowired
	private ListingRepository listingRepo;
	
	@Autowired
	private HostRepository hostRepo;
	
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
}
