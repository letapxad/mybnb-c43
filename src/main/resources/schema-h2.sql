drop database if exists mybnb;

create database mybnb;

use mybnb;

create table mybnb.User (
	SIN INT(9), 
	first_name VARCHAR(255), 
	last_name VARCHAR(255), 
	DOB DATE, 
	occupation VARCHAR(255), 
	active TINYINT(1),
	PRIMARY KEY (SIN)
);

create table mybnb.Renter (
	SIN INT, 
	card_num INT, 
	exp_date DATE,
	PRIMARY KEY (SIN),
	FOREIGN KEY (SIN) REFERENCES User(SIN)
);

create table mybnb.Host (
	SIN INT,
	PRIMARY KEY (SIN),
	FOREIGN KEY (SIN) REFERENCES User(SIN)
);

create table mybnb.Listing (
	listing_id INT, 
	host_SIN INT, 
	longitude INT, 
	latitude INT, 
	type VARCHAR (255), 
	street_num INT,
	 street_name VARCHAR(255), 
	 unit INT, 
	 Postal_code VARCHAR(255), 
	 city VARCHAR (255), 
	 country VARCHAR(255), 
	 listed_on DATE, 
	 active TINYINT(1),
	 PRIMARY KEY (listing_id),
	 FOREIGN KEY (host_SIN) REFERENCES Host(SIN)
);

create table mybnb.Availability (
	host_SIN INT, 
	listing_id INT, 
	date DATE, 
	price FLOAT,
	FOREIGN KEY (host_SIN) REFERENCES Host(SIN),
	FOREIGN KEY (listing_id) REFERENCES Listing(listing_id)
);

create table mybnb.Amenities(
	name VARCHAR(255),
	type VARCHAR(255),
	PRIMARY KEY (name, type)
);

create table mybnb.Booking(
	booking_id INT,
	start_date DATE, 
	end_date DATE,
	PRIMARY KEY (booking_id)
);

create table mybnb.Status(
	name VARCHAR(255),
	PRIMARY KEY (name)
);

create table mybnb.Booking_Made_by(
	booking_id INT,
	SIN INT,
	PRIMARY KEY (booking_id)
);

create table mybnb.Booking_Of(
	booking_id INT,
	listing_id INT,
	PRIMARY KEY (booking_id)
);

create table mybnb.Host_comment_renter(
	host_SIN INT,
	renter_SIN INT,
	listing_id INT, 
	booking_id INT, 
	added_on DATE, 
	text LONGTEXT, 
	rating FLOAT,
	PRIMARY KEY (host_SIN,renter_SIN,listing_id,booking_id)
);

create table mybnb.Renter_comment_host(
	renter_SIN INT, 
	host_SIN INT , 
	listing_id INT , 
	booking_id INT , 
	added_on DATE, 
	text LONGTEXT, 
	rating FLOAT,
	PRIMARY KEY (renter_SIN, host_SIN,listing_id,booking_id)
);

create table mybnb.Renter_comment_listing(
	renter_SIN INT, 
	listing_id INT ,
	host_SIN INT , 
	booking_id INT , 
	added_on DATE, 
	text LONGTEXT, 
	rating FLOAT,
	PRIMARY KEY (renter_SIN, host_SIN,listing_id,booking_id)

);

create table mybnb.Provides(
	name VARCHAR(255),
	type VARCHAR(255), 
	SIN INT,
	listing_id INT,
	PRIMARY KEY (name, type, SIN, listing_id)
);


INSERT INTO User values (12345678,"Dax","Patel", "1995-07-18", "student", 1);
INSERT INTO User values (456234567,"Pax","Datel", "1959-07-18", "student", 1);

