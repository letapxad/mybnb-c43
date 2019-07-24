    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table availability (
       date date not null,
        price float not null,
        listing_id integer not null,
        primary key (date, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null,
        cost float not null,
        date date,
        status varchar(255),
        renter_id integer not null,
        listing_id integer not null,
        primary key (id, listing_id, renter_id)
    ) engine=InnoDB

    create table host (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table host_comment_renter (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table listing (
       id integer not null auto_increment,
        active TINYINT,
        city varchar(255),
        country varchar(255),
        latitude double precision not null,
        listed_on datetime(6),
        longitude double precision not null,
        name varchar(255),
        postal_code_area varchar(255),
        postal_code_num varchar(255),
        street_name varchar(255),
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_id integer,
        primary key (id)
    ) engine=InnoDB

    create table listing_amenities (
       listings_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       id integer not null auto_increment,
        sin integer,
        active TINYINT,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (id)
    ) engine=InnoDB

    create table renter_comment_host (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        booking_id integer not null,
        booking_listing_id integer not null,
        booking_renter_id integer not null,
        primary key (booking_id, booking_listing_id, booking_renter_id)
    ) engine=InnoDB

    alter table host 
       add constraint UK_ktvn52iy65bgncfxdtqt2282h unique (sin)

    alter table renter 
       add constraint UK_f4hy8korr64ji1kxjnb532icd unique (sin)

    alter table availability 
       add constraint FKb0xjjf2edppaxdwf7r38nnh6s 
       foreign key (listing_id) 
       references listing (id)

    alter table booking 
       add constraint FKa3vsvmgga5x01a5tid4781qi5 
       foreign key (renter_id) 
       references renter (id)

    alter table booking 
       add constraint FKmx68ulwt3f5bo242cs4ib8gpl 
       foreign key (listing_id) 
       references listing (id)

    alter table host_comment_renter 
       add constraint FKrechp82f22ivjorw0g9r8vtfd 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table listing 
       add constraint FKh8cqaansssk6ofx9vm93wjmfy 
       foreign key (host_id) 
       references host (id)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKdiq65w5ppkuqu27eco5caq11n 
       foreign key (listings_id) 
       references listing (id)

    alter table renter_comment_host 
       add constraint FKob2bbyq601bysplde9pyukjmy 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)

    alter table renter_comment_listing 
       add constraint FKi2q72f8r2lkwr4585c16weo6y 
       foreign key (booking_id, booking_listing_id, booking_renter_id) 
       references booking (id, listing_id, renter_id)
