
use mybnbauto;

insert into host (active, first_name, last_name, occupation, sin) 
	values 
		(1, "Dax", "Patel", "Student", 123456785),
		(0, "A", "A", "Professor", 123456787),
		(0, "B", "B", "Student", 123456723),
		(0, "C", "C", "Student", 123456712),
		(1, "Syed Sohail", "Ahmed", "Philosopher", 123456742);
		
insert into renter (active, first_name, last_name, occupation, card_num, exp_date, sin) 
	values 
		(1, "Nick", "Koudas", "Professor", 1111111111, "2020-10-01", 123456999),
		(0, "D", "D", "Professor", 2222222222, "2020-09-01", 123456888),
		(0, "E", "E", "Student", 3333333333, "2020-01-01", 123456777),
		(0, "F", "F", "Student", 4444444444, "2020-02-01", 123456555),
		(1, "Richard", "Pancer", "Professor", 5555555555, "2020-06-01", 123454444);
		
insert into amenity (name)
	values
		("Closet"),
		("Drawers"),
		("TV"), 
		("Heat"),
		("Air_conditioning"), 
		("Breakfast");

insert into listing (id, active, country, latitude, listed_on, longitude, name, postal_code, street_name, street_num, type, unit, host_sin) 
	values 
		(1, 1, "Canada", 10.00, "2019-08-05", 10.0, "Listing A", "ABC100", "Markham", 10, "Full House", 1, 123456785),
		(2, 1, "Canada", 20.00, "2019-08-10", 20.0, "Listing B", "DEF200", "Eglinton", 20, "Room", 2, 123456742),
		(3, 1, "Canada", 30.00, "2019-08-15", 30.0, "Listing C", "GHI300", "Military Trail", 30, "Apartment", 3, 123456742),
		(4, 0, "Canada", 40.00, "2019-08-20", 40.0, "Listing D", "JKL400", "Markham", 40, "Full House", 4, 123456785);