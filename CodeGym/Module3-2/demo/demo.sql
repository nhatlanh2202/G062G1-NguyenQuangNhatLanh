drop database if exists demo_md3;
create database demo_md3;
use demo_md3;


create table demo(
	id int primary key,
    `name` varchar(45),
    price int,
    quantity int,
    color varchar(45),
    `description` varchar(45)
);

insert into demo
values
	(1,'red',1000,5,'red','nice'),
	(2,'blue',1000,5,'blue','nice'),
	(3,'green',1000,5,'green','nice'),
	(4,'yellow',1000,5,'yellow','nice')