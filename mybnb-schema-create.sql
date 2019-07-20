
    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table amenity_listings (
       amenity_name varchar(255) not null,
        listings_host_sin integer not null,
        listings_id integer not null
    ) engine=InnoDB

    create table availability (
       date date,
        price float not null,
        listing_host_sin integer not null,
        listing_id integer not null,
        primary key (listing_host_sin, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null auto_increment,
        end_date date,
        start_date date,
        status varchar(255),
        renter_sin integer not null,
        listing_host_sin integer not null,
        listing_id integer not null,
        comments_booking_id integer,
        comments_booking_listing_host_sin integer,
        comments_booking_listing_id integer,
        comments_booking_renter_sin integer,
        comments_renter_sin integer,
        primary key (id, listing_host_sin, listing_id, renter_sin)
    ) engine=InnoDB

    create table host (
       sin integer not null,
        active bit,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (sin)
    ) engine=InnoDB

    create table listing (
       id integer not null,
        active bit not null,
        country varchar(255),
        latitude double precision not null,
        listed_on date,
        longitude double precision not null,
        name varchar(255),
        postal_code varchar(255),
        street_name integer not null,
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_sin integer not null auto_increment,
        primary key (host_sin, id)
    ) engine=InnoDB

    create table listing_amenities (
       listing_host_sin integer not null,
        listing_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       sin integer not null,
        active bit,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (sin)
    ) engine=InnoDB

    create table renter_comments (
       renter_sin integer not null,
        comments_booking_id integer not null,
        comments_booking_listing_host_sin integer not null,
        comments_booking_listing_id integer not null,
        comments_booking_renter_sin integer not null,
        comments_renter_sin integer not null
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        renter_sin integer not null,
        booking_id integer not null,
        booking_listing_host_sin integer not null,
        booking_listing_id integer not null,
        booking_renter_sin integer not null,
        primary key (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)
    ) engine=InnoDB

    alter table renter_comments 
       add constraint UK_69mc8q5cw3cc5iswt8dmxikjw unique (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin)

    alter table renter_comment_listing 
       add constraint UK_5ejlbwxcmr55rklhtint4xq3s unique (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin)

    alter table amenity_listings 
       add constraint FKgkthva7s9dp6nuhpml2avq6un 
       foreign key (listings_host_sin, listings_id) 
       references listing (host_sin, id)

    alter table amenity_listings 
       add constraint FKej9njr2l5rrqewjfr97m1vivc 
       foreign key (amenity_name) 
       references amenity (name)

    alter table availability 
       add constraint FK1ql065a594nl11988cte49m93 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table booking 
       add constraint FKc7wbe9rw3cy0vskg8p6et723u 
       foreign key (renter_sin) 
       references renter (sin)

    alter table booking 
       add constraint FKfg2hapnt3wck1ppb14ub7qcgb 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table booking 
       add constraint FK9ptnhfodku0e86m2xw41dutsn 
       foreign key (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin) 
       references renter_comment_listing (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)

    alter table listing 
       add constraint FK6n9wffdlem39mvju15xy9u5o7 
       foreign key (host_sin) 
       references host (sin)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKtimjppursn6ymnxfwqjroq1co 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table renter_comments 
       add constraint FK6t0omb4wrwrpy1vy5a15dk7rj 
       foreign key (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin) 
       references renter_comment_listing (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)

    alter table renter_comments 
       add constraint FKcl15s2vb3nw498au7rgamyvd 
       foreign key (renter_sin) 
       references renter (sin)

    alter table renter_comment_listing 
       add constraint FKdidqj81ai92k3ywi2p5wi3ia1 
       foreign key (renter_sin) 
       references renter (sin)

    alter table renter_comment_listing 
       add constraint FKnmveb25r2n694sey8ymu5000 
       foreign key (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin) 
       references booking (id, listing_host_sin, listing_id, renter_sin)

    create table amenity (
       name varchar(255) not null,
        primary key (name)
    ) engine=InnoDB

    create table amenity_listings (
       amenity_name varchar(255) not null,
        listings_host_sin integer not null,
        listings_id integer not null
    ) engine=InnoDB

    create table availability (
       date date,
        price float not null,
        listing_host_sin integer not null,
        listing_id integer not null,
        primary key (listing_host_sin, listing_id)
    ) engine=InnoDB

    create table booking (
       id integer not null auto_increment,
        end_date date,
        start_date date,
        status varchar(255),
        renter_sin integer not null,
        listing_host_sin integer not null,
        listing_id integer not null,
        comments_booking_id integer,
        comments_booking_listing_host_sin integer,
        comments_booking_listing_id integer,
        comments_booking_renter_sin integer,
        comments_renter_sin integer,
        primary key (id, listing_host_sin, listing_id, renter_sin)
    ) engine=InnoDB

    create table host (
       sin integer not null,
        active bit,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        primary key (sin)
    ) engine=InnoDB

    create table listing (
       id integer not null,
        active bit not null,
        country varchar(255),
        latitude double precision not null,
        listed_on date,
        longitude double precision not null,
        name varchar(255),
        postal_code varchar(255),
        street_name integer not null,
        street_num integer not null,
        type varchar(255),
        unit varchar(255),
        host_sin integer not null auto_increment,
        primary key (host_sin, id)
    ) engine=InnoDB

    create table listing_amenities (
       listing_host_sin integer not null,
        listing_id integer not null,
        amenities_name varchar(255) not null
    ) engine=InnoDB

    create table renter (
       sin integer not null,
        active bit,
        first_name varchar(255),
        last_name varchar(255),
        occupation varchar(255),
        card_num bigint,
        exp_date date,
        primary key (sin)
    ) engine=InnoDB

    create table renter_comments (
       renter_sin integer not null,
        comments_booking_id integer not null,
        comments_booking_listing_host_sin integer not null,
        comments_booking_listing_id integer not null,
        comments_booking_renter_sin integer not null,
        comments_renter_sin integer not null
    ) engine=InnoDB

    create table renter_comment_listing (
       added_on date,
        rating float not null,
        text varchar(255),
        renter_sin integer not null,
        booking_id integer not null,
        booking_listing_host_sin integer not null,
        booking_listing_id integer not null,
        booking_renter_sin integer not null,
        primary key (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)
    ) engine=InnoDB

    alter table renter_comments 
       add constraint UK_69mc8q5cw3cc5iswt8dmxikjw unique (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin)

    alter table renter_comment_listing 
       add constraint UK_5ejlbwxcmr55rklhtint4xq3s unique (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin)

    alter table amenity_listings 
       add constraint FKgkthva7s9dp6nuhpml2avq6un 
       foreign key (listings_host_sin, listings_id) 
       references listing (host_sin, id)

    alter table amenity_listings 
       add constraint FKej9njr2l5rrqewjfr97m1vivc 
       foreign key (amenity_name) 
       references amenity (name)

    alter table availability 
       add constraint FK1ql065a594nl11988cte49m93 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table booking 
       add constraint FKc7wbe9rw3cy0vskg8p6et723u 
       foreign key (renter_sin) 
       references renter (sin)

    alter table booking 
       add constraint FKfg2hapnt3wck1ppb14ub7qcgb 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table booking 
       add constraint FK9ptnhfodku0e86m2xw41dutsn 
       foreign key (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin) 
       references renter_comment_listing (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)

    alter table listing 
       add constraint FK6n9wffdlem39mvju15xy9u5o7 
       foreign key (host_sin) 
       references host (sin)

    alter table listing_amenities 
       add constraint FKrt5d2o2yf8xvosxxak19mbter 
       foreign key (amenities_name) 
       references amenity (name)

    alter table listing_amenities 
       add constraint FKtimjppursn6ymnxfwqjroq1co 
       foreign key (listing_host_sin, listing_id) 
       references listing (host_sin, id)

    alter table renter_comments 
       add constraint FK6t0omb4wrwrpy1vy5a15dk7rj 
       foreign key (comments_booking_id, comments_booking_listing_host_sin, comments_booking_listing_id, comments_booking_renter_sin, comments_renter_sin) 
       references renter_comment_listing (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin, renter_sin)

    alter table renter_comments 
       add constraint FKcl15s2vb3nw498au7rgamyvd 
       foreign key (renter_sin) 
       references renter (sin)

    alter table renter_comment_listing 
       add constraint FKdidqj81ai92k3ywi2p5wi3ia1 
       foreign key (renter_sin) 
       references renter (sin)

    alter table renter_comment_listing 
       add constraint FKnmveb25r2n694sey8ymu5000 
       foreign key (booking_id, booking_listing_host_sin, booking_listing_id, booking_renter_sin) 
       references booking (id, listing_host_sin, listing_id, renter_sin)
