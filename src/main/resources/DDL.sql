DROP DATABASE IF EXISTS mybnbauto;

CREATE DATABASE mybnbauto;

use mybnbauto;


CREATE TABLE `amenity` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
),

CREATE TABLE `availability` (
  `date` date NOT NULL,
  `price` double NOT NULL,
  `listing_id` int(11) NOT NULL,
  PRIMARY KEY (`date`,`listing_id`),
  KEY `FKb0xjjf2edppaxdwf7r38nnh6s` (`listing_id`),
  CONSTRAINT `FKb0xjjf2edppaxdwf7r38nnh6s` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cancelled_by` varchar(255) DEFAULT NULL,
  `cost` double NOT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `host_id` int(11) DEFAULT NULL,
  `listing_id` int(11) DEFAULT NULL,
  `renter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjjxd5f7vv6vcmc4b4at4shv7a` (`host_id`),
  KEY `FKmx68ulwt3f5bo242cs4ib8gpl` (`listing_id`),
  KEY `FKa3vsvmgga5x01a5tid4781qi5` (`renter_id`),
  CONSTRAINT `FKa3vsvmgga5x01a5tid4781qi5` FOREIGN KEY (`renter_id`) REFERENCES `renter` (`id`),
  CONSTRAINT `FKjjxd5f7vv6vcmc4b4at4shv7a` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `FKmx68ulwt3f5bo242cs4ib8gpl` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `host` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `sin` int(11) DEFAULT NULL,
  `active` tinyint(4) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ktvn52iy65bgncfxdtqt2282h` (`sin`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `host_comment_renter` (
  `booking_id` int(11) NOT NULL,
  `added_on` datetime(6) NOT NULL,
  `rating` float NOT NULL,
  `text` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  CONSTRAINT `FKbicl7iitd9hlyo7ijuvnkdaks` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `listing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(4) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `latitude` double NOT NULL,
  `listed_on` date DEFAULT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `postal_code_area` varchar(3) DEFAULT NULL,
  `postal_code_num` varchar(3) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `street_num` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `host_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lis` (`host_id`),
  CONSTRAINT `fk_lis` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `listing_amenities` (
  `listings_id` int(11) NOT NULL,
  `amenities_name` varchar(255) NOT NULL,
  KEY `FKrt5d2o2yf8xvosxxak19mbter` (`amenities_name`),
  KEY `FKdiq65w5ppkuqu27eco5caq11n` (`listings_id`),
  CONSTRAINT `FKdiq65w5ppkuqu27eco5caq11n` FOREIGN KEY (`listings_id`) REFERENCES `listing` (`id`),
  CONSTRAINT `FKrt5d2o2yf8xvosxxak19mbter` FOREIGN KEY (`amenities_name`) REFERENCES `amenity` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `renter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `sin` int(11) DEFAULT NULL,
  `active` tinyint(4) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `card_num` bigint(20) NOT NULL,
  `exp_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f4hy8korr64ji1kxjnb532icd` (`sin`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `renter_comment_host` (
  `booking_id` int(11) NOT NULL,
  `added_on` datetime(6) NOT NULL,
  `rating` float NOT NULL,
  `text` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  CONSTRAINT `FKc9hfkb0qjw6geges5pv3plhkw` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci,

CREATE TABLE `renter_comment_listing` (
  `booking_id` int(11) NOT NULL,
  `added_on` datetime(6) NOT NULL,
  `rating` float NOT NULL,
  `text` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  CONSTRAINT `FKnphojkbh8pv5o3blcxj3ocu08` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci