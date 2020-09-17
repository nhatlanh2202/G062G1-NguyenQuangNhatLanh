use demo;

insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
values
	(1,'dn01','iphone','1000','10','normal','available'),
    (2,'dn02','samsung','1000','10','normal','available'),
    (3,'dn03','oppo','1000','10','normal','available');

-- Bước 3:
-- Tạo unique index trên bảng products(sử dụng cột products	để tạo chỉ mục)
create unique index index_product_code
on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index composite_index_products
on products(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain 
select *
from products
where product_code = 2;

-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view view_product as
select product_code, product_name, product_price, product_status
from products;

select *
from view_product;

-- Tiến hành sửa đổi view
create view view_product as
select id, product_code, product_name, product_price, product_amount, product_description, product_status
from products;

select *
from view_product;

insert into view_product
values (4,'dn04','bmw','1000','10','normal','available');

-- Tiến hành xoá view
drop view view_product;

-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter // 
create procedure allrecords()
begin
	select *
    from products;
end//
delimiter ;

call allrecords();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(id int, product_code varchar(50), product_name varchar(50), product_price varchar(50),
							product_amount varchar(50), product_description varchar(50), product_status varchar(50))
begin
	insert into products
    values (5,'dn05','honda','1000','10','normal','available');
end//
delimiter ;







