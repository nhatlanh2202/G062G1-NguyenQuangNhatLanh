drop database if exists quan_ly_thu_vien;
create database quan_ly_thu_vien;

use quan_ly_thu_vien;

-- bảng student
create table Student(
	id_student int primary key,
    name_student varchar(50),
    address_student varchar(50),
    email_student varchar(50),
    image_student varchar(50)
);

-- bảng loại sách
create table TypeBook(
	id_type_book int primary key,
    name_type_book varchar(50)
);

-- bảng thẻ thuê sách
create table LibaryBook(
	id_libary int primary key,
    number_student_libary int,
    constraint fk foreign key(number_student_libary) references Student(id_student)
);

-- bảng mượn sách
create table BorrowOrder(
	id_order int primary key,
    date_borrow date,
    date_return date,
    borrowoder_libary_number int,
    constraint fk_borroworder foreign key (borrowoder_libary_number) references LibaryBook(id_libary)
);

-- bảng sách
create table Book(
	id_book int primary key,
    name_book varchar(50),
    book_publisher varchar(50),
    author varchar(50),
    year_publish varchar(50),
    number_of_time_publish varchar(50),
    price varchar(50),
    image varchar(50),
	book_borrowoder_number int,
	book_type_number int,
    constraint fk_book_borroworder foreign key(book_borrowoder_number) references BorrowOrder(id_order),
    constraint fk_type_number foreign key(book_type_number) references TypeBook(id_type_book)
);