alter table availability drop foreign key FKb0xjjf2edppaxdwf7r38nnh6s
alter table booking drop foreign key FKjjxd5f7vv6vcmc4b4at4shv7a
alter table booking drop foreign key FKmx68ulwt3f5bo242cs4ib8gpl
alter table booking drop foreign key FKa3vsvmgga5x01a5tid4781qi5
alter table host_comment_renter drop foreign key FKbicl7iitd9hlyo7ijuvnkdaks
alter table listing drop foreign key FKh8cqaansssk6ofx9vm93wjmfy
alter table listing_amenities drop foreign key FKrt5d2o2yf8xvosxxak19mbter
alter table listing_amenities drop foreign key FKdiq65w5ppkuqu27eco5caq11n
alter table renter_comment_host drop foreign key FKc9hfkb0qjw6geges5pv3plhkw
alter table renter_comment_listing drop foreign key FKnphojkbh8pv5o3blcxj3ocu08
drop table if exists amenity
drop table if exists availability
drop table if exists booking
drop table if exists host
drop table if exists host_comment_renter
drop table if exists listing
drop table if exists listing_amenities
drop table if exists renter
drop table if exists renter_comment_host
drop table if exists renter_comment_listing
