drop database if EXISTS demo;

create database demo;

use demo;

create table Products (
	id int,
    product_code varchar(50),
    product_name varchar(50),
    product_price varchar(50),
    product_amount varchar(50),
    product_description varchar(50),
    product_status varchar(50)
);

