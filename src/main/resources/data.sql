
use mybnbauto;
insert into host (active, first_name, last_name, occupation, sin, id) 
	values 
		(1, "Dax", "Patel", "Student", 123456785, 1),
		(0, "A", "A", "Professor", 123456787, 2),
		(0, "B", "B", "Student", 123456723, 3),
		(0, "C", "C", "Student", 123456712, 4),
		(1, "Syed Sohail", "Ahmed", "Philosopher", 123456742, 5);
		
insert into renter (active, first_name, last_name, occupation, card_num, exp_date, sin, id) 
	values 
		(1, "Nick", "Koudas", "Professor", 1111111111, "2020-10-01", 123456999, 6),
		(0, "D", "D", "Professor", 2222222222, "2020-09-01", 123456888, 7),
		(0, "E", "E", "Student", 3333333333, "2020-01-01", 123456777, 8),
		(0, "F", "F", "Student", 4444444444, "2020-02-01", 123456555, 9),
		(1, "Richard", "Pancer", "Professor", 5555555555, "2020-06-01", 123454444, 10);
		
insert into amenity (name)
	values
		("Closet"),
		("Drawers"),
		("TV"), 
		("Heat"),
		("Air_Conditioning"), 
		("Breakfast");

insert into listing (id, active, country, latitude, listed_on, longitude, name, postal_code, street_name, street_num, type, unit, host_sin, host_id) 
	values 
		(1, 1, "Canada", 10.00, "2019-08-01", 10.0, "Listing A", "ABC100", "Markham", 10, "Full House", 1, 123456785, 1),
		(2, 1, "Canada", 20.00, "2019-08-02", 20.0, "Listing B", "DEF200", "Eglinton", 20, "Room", 2, 123456742, 5),
		(3, 1, "Canada", 30.00, "2019-08-03", 30.0, "Listing C", "GHI300", "Military Trail", 30, "Apartment", 3, 123456742, 5),
		(4, 0, "Canada", 40.00, "2019-08-04", 40.0, "Listing D", "JKL400", "Markham", 40, "Full House", 4, 123456785, 1);
		
insert into availability (date, price, listing_host_sin, listing_id, listing_host_id)
	values
		("2019-08-05", 2000.00, 123456785, 1, 1),
		("2019-08-06", 2000.00, 123456785, 1, 1),
		("2019-08-07", 3000.00, 123456742, 2, 5),
		("2019-08-08", 3000.00, 123456742, 2, 5),
		("2019-08-09", 4000.00, 123456742, 3, 5),
		("2019-08-10", 4000.00, 123456742, 3, 5);
		
insert into booking (id, cost, date, status, renter_sin, renter_id, listing_host_sin, listing_id, listing_host_id)
	values
		(1, 2000.00, "2019-08-05", "Booked", 123456999, 6, 123456785, 1, 1),
		(2, 3000.00, "2019-08-07", "Booked", 123456999, 6, 123456742, 2, 5),
		(3, 4000.00, "2019-08-09", "Booked", 123454444, 10, 123456742, 3, 5);