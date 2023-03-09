create database library;
use library;
create table Book(
 timeID int unsigned auto_increment primary key,
 bookID varchar(100) not null,
 bookName varchar (1000) not null,
 author varchar (1000) not null,
 category varchar (1000) not null,
 price varchar(1000) not null,
 lend int DEFAULT 0,
 borrowTime datetime not null,
 returnTime datetime default null
);

create table Bookingroom(
id int unsigned auto_increment primary key,
roomNumber int(10) not null,
BookingId int (9) not null,
BookingName varchar(1000) not null,
Bookingtime timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE users (
  id INT primary key AUTO_INCREMENT,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  role ENUM('student', 'admin') NOT NULL
);

