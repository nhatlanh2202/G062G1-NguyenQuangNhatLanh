drop database if exists bai_tap;
create database bai_tap;

use bai_tap;

create table hoc_vien(
	id int,
    ten varchar(50),
    tuoi int,
    khoahoc varchar(50),
    sotien int
);