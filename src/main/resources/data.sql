
use mybnbauto;

 
 insert into host (active, first_name, last_name, occupation, sin, dob) 
 	values 
 		(1, "Dax", "Patel", "Student", 123456785, "2000-07-25"),
 		(0, "A", "A", "Professor", 123456787, "2000-07-26"),
 		(0, "B", "B", "Student", 123456723, "2000-07-27"),
 		(0, "C", "C", "Student", 123456712, "2000-07-28"),
 		(1, "Syed Sohail", "Ahmed", "Philosopher", 123456742, "2000-07-29");
 
 insert into renter (active, first_name, last_name, occupation, card_num, exp_date, sin, dob) 
 	values 
 		(1, "Nick", "Koudas", "Professor", 1111111111, "2020-10-01", 123456999,"1980-07-25"),
 		(0, "D", "D", "Professor", 2222222222, "2020-09-01", 123456888, "1980-07-26"),
 		(0, "E", "E", "Student", 3333333333, "2020-01-01", 123456777, "1980-07-27"),
 		(0, "F", "F", "Student", 4444444444, "2020-02-01", 123456555, "1980-07-28"),
 		(1, "Richard", "Pancer", "Professor", 5555555555, "2020-06-01", 123454444, "1980-07-29");
		
 insert into amenity (name)
 	values
 		("Closet"),
 		("Drawers"),
 		("TV"), 
 		("Heat"),
 		("Air_Conditioning"), 
		("Breakfast");

 insert into listing (active, country, latitude, listed_on, longitude, name, city, postal_code_area, postal_code_num, street_name, street_num, type, unit, host_id) 
 	values 
 		(1, "Canada", 10.00, "2019-08-01", 10.0, "Listing A", "Toronto", "ABC", "100", "Markham", 10, "Full House", 1, 1),
 		(1, "Canada", 20.00, "2019-08-02", 20.0, "Listing B", "Toronto", "DEF", "200", "Eglinton", 20, "Room", 2, 5),
 		(1, "Canada", 30.00, "2019-08-03", 30.0, "Listing C", "Toronto", "GHI", "300", "Military Trail", 30, "Apartment", 3, 5),
 		(0, "Canada", 40.00, "2019-08-04", 40.0, "Listing D", "Toronto", "JKL", "400", "Markham", 40, "Full House", 4, 1);

 insert into listing (active,city, country,latitude,longitude,name, postal_code_area, postal_code_num, street_name, street_num,type, unit, host_id) 
 values (1,"Toronto","Canada",43.787389,-79.194757,"my home", "E3F","W3R","Mornelle ct", 100,"Apartment",2000, 2);		
 
 
--  insert into availability (date, price, listing_id)
--  	values
--  		("2019-08-05", 2000.00, 1),
--  		("2019-08-06", 2000.00, 1),
--  		("2019-08-07", 3000.00, 2),
--  		("2019-08-08", 3000.00, 2),
--  		("2019-08-09", 4000.00, 3),
--  		("2019-08-10", 4000.00, 3);
		
--  insert into booking (cost, start_date, end_date, status, listing_id, renter_id, host_id)
--  	values
--  		(2000.00, "2019-08-05", "2019-08-09", "Booked", 1, 1, 1),
--  		(3000.00, "2019-08-07", "2019-08-015", "Booked", 2, 5, 5),
--  		(4000.00, "2019-08-09", "2019-08-011", "Booked", 3, 5, 5);
 		
--  insert into renter_comment_host (added_on , rating, text, booking_id)
--  	values
--  		("2019-07-29", 5, "You are a great host", 1),
--  		("2019-07-29", 1, "You are a bad host", 2);
 		
--  insert into renter_comment_listing (added_on , rating, text, booking_id)
--  	values
--  		("2019-07-29", 5, "I loved it", 1),
--  		("2019-07-29", 1, "I hated it", 2);
 		
--  insert into host_comment_renter (added_on , rating, text, booking_id)
--  	values
--  		("2019-07-29", 5, "You are a great renter", 1),
--  		("2019-07-29", 1, "You are a bad renter", 2);
 		
 