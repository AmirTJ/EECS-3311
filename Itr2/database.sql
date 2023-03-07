create database library;
use library;
create table Book(
 timeID int unsigned auto_increment primary key,
 bookID varchar(100) not null,
 bookName varchar (1000) not null,
 author varchar (1000) not null,
 category varchar (1000) not null,
 price varchar(1000) not null,
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

create table Student (
	Student_ID INT NOT NULL,
    UserPassword VARCHAR(255),
    PRIMARY KEY(Student_ID)
);

create TABLE DevTeam (
	DevTeam_ID INT NOT NULL,
    UserPassword VARCHAR(255),
    PRIMARY KEY(DevTeam_ID)
);
