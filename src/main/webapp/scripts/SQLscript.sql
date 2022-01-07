-- IMPORTANT: 
-- You must use exactly the same database names, table names, column names
-- and values as specified in context.xml and SQLScript.sql. 
-- The only thing you can change is the password for root. 
-- A 50-100% penalty will be applied if anything else than 
-- the root password is change. 

create database java3final;
use java3final;

-- create workers table 
create table workers (
  id varchar(20) not null,
  fullname varchar(40) not null,
  salary double not null,
  primary key (id)
);

insert into workers values ('cs123','Jack Anna', 34.5),('sys234','Joke Banna', 45.6),
  ('prog345','Jake Canna', 56.7),('dbas456', 'Jike Danna', 67.8), ('it567', 'Juke Eanna', 78.9);

-- create two tables for security - access control
create table clients (
	clientname varchar(15) not null, 
	password varchar(15) not null,
	primary key (clientname)
);

insert into clients values ('admin', 'admin');
insert into clients values ('guest', 'guest');

create table clientrole (
	clientname varchar(15) not null,
	rolename varchar(15) not null,
	primary key (clientname, rolename)
);

insert into clientrole values ('admin', 'admin');
insert into clientrole values ('guest', 'guest');

-- a quick check
select * from workers;
select * from clients;
select * from clientrole;
