drop database if exists product_db;
create database product_db;
use product_db;

create table category (
	category_id int primary key,
    category_name varchar(50)
);

create table product(
	id int,
	product_name varchar(45),
	price double,
    quantity int,
    color varchar(45),
    `description` varchar(45),
    category_id int,
    foreign key (category_id) references category(category_id) on delete cascade on update cascade
);

DELIMITER //
create procedure update_product (id_update int, name_update varchar(50), price_update int, quantity_update int, 
color_update varchar (50), description_update varchar (50), category_id_update int)
begin
	update product
	set product_name = name_update, price = price_update, quantity = quantity_update, color = color_update,
    `description` = description_update, category_id = category_id_update
    where id = id_update;
end //
DELIMITER ;

DELIMITER //
create procedure delete_product(id_need_delete int)
begin
	delete from product
    where id = id_need_delete;
end //
DELIMITER ;

insert into category
values 
	(1,'Phone'),
    (2,'Tivi'),
    (3,'Tủ Lạnh'),
    (4,'Máy giặt');

insert into product
 values 
	(1,'iPhone 11',799,12,'Black, Yellow, Green',1),
	(2,'iPhone 11 Pro',1100,12,'Black, Yellow, Green',1),
	(3,'iPhone X',749,12,'Black, Yellow, Green',1),
	(4,'Smart Tivi 55 inch',799,12,'Black, Yellow, Green',2),
	(5,'Tủ lạnh 2 cánh Toshiba',799,12,'Black, Yellow, Green',3),
	(5,'Máy giặt cửa ngang SamSung',320,12,'Black, Yellow, Green',4);

select * from product;