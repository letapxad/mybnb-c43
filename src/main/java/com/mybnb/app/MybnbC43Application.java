package com.mybnb.app;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.mybnb.app.models.Host;
import com.mybnb.app.repository.HostRepository;

@SpringBootApplication
public class MybnbC43Application{

	@Autowired
	private HostRepository hostRepository;
	
//	private ListingRepo
	
	private Faker faker;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MybnbC43Application.class, args);
	}
	
	
//   @Override
//   public void run(ApplicationArguments arg0) throws Exception {
//      
//	   System.out.println("Seeding data...");
//	   
//	   this.insertHosts(15);
//	   
//      
//      
//      
//   }
//   
//   private void insertHosts(int limit) {
//	   for(int i = 0; i < limit; i++) {
//		   Host host = new Host();
//		   int ssn = 100000000 + new Random().nextInt(899999999);
//		   host.setSIN(ssn);
//		   host.setActive(true);
//		   System.out.println();
//		   host.setFirst_name("Dax");
//		   host.setLast_name("Patel");
//		   host.setOccupation("Student");
//		   System.out.println();
//		   hostRepository.save(host);
//	   }
//   }

}
