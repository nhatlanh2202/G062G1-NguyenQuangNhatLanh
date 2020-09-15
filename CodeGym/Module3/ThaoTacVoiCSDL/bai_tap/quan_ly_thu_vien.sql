create database quan_ly_thu_vien;

use quan_ly_thu_vien;

create table category(
	category_id int primary key,
    category_name varchar(50)
);

create table book(
	book_id int primary key,
    book_name varchar(50),
    author varchar(50),
    year_publish varchar(50),
    number_of_publication int,
    price double,
    image varchar(50),
    category_id int,
    foreign key (category_id) references category(category_id)
);


create table student(
	student_number int primary key,
    student_name varchar(50),
    birthday date,
    address varchar(50),
    email varchar(50),
    image varchar(50)
);


create table borroworder(
	borrow_order_id int primary key,
    student_number int,
    foreign key (student_number) references student(student_number)
);

create table borrowbook(
	
):