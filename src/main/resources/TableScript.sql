drop database lattice;
create database lattice;
use lattice;
Drop table if exists device;
Drop table if exists protocol;
Drop table if exists user;
Drop table if exists tag;


create table protocol(
Protocol_id int  not null primary key,
Title varchar(200),
Created_on timestamp,
Effectivity_date timestamp
); 

create table tag(
Tag_id int not null primary key,
Description varchar(200),
Is_active ENUM('Y','N'),
Created_on timestamp
);

create table user(
User_id int  not null primary key,
User_name varchar(500),
Email varchar(200),
Device_id int references Device(Device_id),
Tag_id int not null references Tag(Tag_id)
);

create table device(
Device_id int  not null primary key,
Description varchar(500),
Status ENUM('working','idle','complete') not null,
Operator_id int references User(User_id),
Protocol_id int references Protocol(Protocol_id)
);

Insert into protocol values(1,'HTTP','2018-08-21 00.03.05','2018-08-27 00.03.05');
Insert into protocol values(2,'SMTP','2018-04-21 00.03.05','2018-09-27 00.03.05');
Insert into protocol values(3,'ATP','2018-03-21 00.03.05','2018-08-27 00.03.05');
Insert into protocol values(4,'TCP','2017-09-21 00.03.05','2018-01-27 00.03.05');
Insert into protocol values(5,'UTP','2018-12-21 00.03.05','2018-12-27 00.03.05');

Insert into tag values(1,'Admin','Y','2018-12-21 00.03.05');
Insert into tag values(2,'Admin','N','2018-10-21 00.03.05');
Insert into tag values(3,'Manager','Y','2018-02-21 00.03.05');
Insert into tag values(4,'Operator','N','2018-07-21 00.03.05');
Insert into tag values(5,'Manager','n','2018-01-21 00.03.05');
Insert into tag values(6,'Operator','Y','2018-05-21 00.03.05');

Insert into Device values(1,'Mobile','working','1','2');
Insert into Device values(2,'Mobile','working','1','2');
Insert into Device values(3,'Mobile','working','1','2');
Insert into Device values(4,'Mobile','working','1','2');
Insert into Device values(6,'Mobile','working','1','2');
Insert into Device values(7,'Mobile','working','1','2');
Insert into Device values(8,'Mobile','working','1','2');
Insert into Device values(9,'Mobile','working','1','2');