drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table customer_type(
customer_type_id 	int primary key,
customer_type_name varchar(45)
);
 create table rent_type(
 rent_type_id int primary key,
 rent_type_name varchar(45),
 rent_type_cost double
 );
 
 create table attach_service(
 attach_service_id int primary key,
 attach_service_name varchar(45),
 attach_service_cost double,
 attach_service_unit int,
 attach_service_status varchar(45)
 );
 

create table customer(
customer_id varchar(45) primary key,
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender bit(2),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),	
foreign key (customer_type_id) references customer_type(customer_type_id) on delete cascade 
on update cascade
);



create table service_type(
	service_type_id int primary key,
    service_type_name varchar(45)
);

create table position_employee(
position_id int primary key,
position_name varchar(45)
);

create table education_degree(
education_degree_id int primary key,
education_degree_name varchar(45)
);
 
 create table division(
 division_id int primary key,
 division_name varchar(45)
 );
 
 create table user(
 user_name varchar(255) primary key,
 password varchar(255)
 );
 
 create table role(
 role_id int primary key,
 role_name varchar(255)
 );
 
create table service(
service_id int primary key,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenionce varchar(45),
pool_area double,
number_of_floors int,
foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade 
on update cascade,
foreign key (service_type_id) references service_type(service_type_id) on delete cascade 
on update cascade
);

create table employee(
employee_id int primary key,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references position_employee(position_id) on delete cascade 
on update cascade,
foreign key (education_degree_id) references education_degree(education_degree_id) on delete cascade 
on update cascade,
foreign key (division_id) references division(division_id) on delete cascade 
on update cascade,
foreign key (username) references user(user_name) on delete cascade 
on update cascade

);

create table contract(
contract_id varchar(45) primary key,
contract_start_date date,
contract_end_date date,
contract_deposit double,
contract_total_money double,
employee_id  int,
customer_id varchar(45),
service_id int,
foreign key(employee_id) references employee(employee_id) on delete cascade 
on update cascade,
foreign key(customer_id) references customer(customer_id) on delete cascade 
on update cascade,
foreign key(service_id) references service(service_id) on delete cascade 
on update cascade
);

 create table user_role(
 user_name varchar(255),
 role_id int,
primary key(user_name,role_id),
foreign key(user_name) references user(user_name) on delete cascade 
on update cascade,
foreign key(role_id) references role(role_id) on delete cascade 
on update cascade
 );
 
 create table contract_detail(
 contract_detail_id int primary key,
 contract_id varchar(45),
 attach_service_id int,
 quanlity int,
 foreign key (attach_service_id) references attach_service(attach_service_id) on delete cascade 
on update cascade,
 foreign key (contract_id) references contract(contract_id) on delete cascade 
on update cascade
 );
 
insert into position_employee(position_id,position_name )
values ("1","Lễ tân"),
	   ("2","Phục vụ"),
	   ("3","Chuyên viên"),
	   ("4","Giám sát"),
	   ("5","Quản lý"),
	   ("6","Giám đốc");
insert into education_degree(education_degree_id,education_degree_name)
values ("1","Trung cấp"),
       ("2","Cao đẳng"),
       ("3","Đại học"),
       ("4","Sau đại học");
insert into division(division_id,division_name)
value ("1","Sale marketing"),
	  ("2","Hành Chính"),
	  ("3","Phục vụ"),
	  ("4","Quản lý");
	
insert into user(user_name,password)
value ("Vu","130801"),
	  ("Chau","120900"),
	  ("Lanh","040199"),
	  ("Khanh","121296");
insert into role(role_id,role_name)
value ("1","a"),
	  ("2","b"),
	  ("3","c"),
	  ("4","d");
insert into user_role(role_id,user_name)
value ("1","Vu"),
	  ("2","Chau"),
	  ("3","Lanh"),
	  ("4","Khanh");
insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)
value ("1","Lanh","1999/01/01","123",200.0,"0466764237","kimochi@gmail.com","Viet Nam","1","1","2","Khanh"),
      ("2","Dat","2000/01/01","234",200.0,"0566764237","yamate@gmail.com","Viet Nam","2","2","1","Lanh"),
      ("3","Chau","1998/01/01","345",200.0,"0468964237","hehehegmail.com","Viet Nam","3","1","3","Chau"),
      ("4","Vu","1995/01/01","456",200.0,"0366764237","hahahag@gmail.com","Viet Nam","4","4","1","Khanh"),
      ("5","Khanh","1996/01/01","567",200.0,"0196764237","hihihi@gmail.com","Viet Nam","5","3","2","Lanh"),
      ("6","Din","1997/01/01","678",200.0,"0166764237","aaaa@gmail.com","Viet Nam","6","1","4","Vu");
insert into customer_type(customer_type_id,customer_type_name)
value ("1","Diamond"),
	  ("2","Platinium"),
	  ("3","Gold"),
	  ("4","Silver"),
	  ("5","Member");
insert into customer (customer_id ,customer_type_id ,customer_name, customer_birthday,customer_gender,customer_id_card ,customer_phone ,customer_email ,customer_address)
value ("1","2","Lanh",'1999-03-17',1,"433","0394772917","Lanh@gmail.com","Viet Nam"),
	("2","2","Dat",'1950-09-09',1,"433","0394772917","Dat@gmail.com","Viet Nam"),
	("3","2","Chau",'2020-09-09',2,"433","0394772917","Chau@gmail.com","Viet Nam"),
	("4","2","Vu",'1900-09-09',1,"433","0394772917","Vu@gmail.com","Viet Nam"),
	("5","2","Khanh",'2100-09-09',1,"433","0394772917","Khanh@gmail.com","Viet Nam");
insert into service_type(service_type_id,service_type_name)
value ("1","Villa"),
	  ("2","House"),
	  ("3","Room");
	
insert into rent_type(rent_type_id,rent_type_name,rent_type_cost)
value ("1","Thuê theo năm",30.0),
	  ("2","Thuê theo tháng",20.0),
	  ("3","Thuê theo ngày",10.0),
	  ("4","Thuê theo giờ",5.0);
insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id ,service_type_id,standard_room ,description_other_convenionce,pool_area,number_of_floors)
value ("1","Villa",40,50,3,1,1,"Vip","2 phòng ngủ",30,4),
      ("2","House",20,60,4,2,2,"thường","1 phòng tắm",20,6),
	  ("3","Room",40,50,5,3,3,"Vip","1 giường",30,3);
	
insert into contract(contract_id,contract_start_date ,contract_end_date ,contract_deposit,contract_total_money,employee_id,customer_id,service_id )
value ("1","2020/09/04","2020/09/11",100.0,200.0,"1","1","2"),
		("2","2020/09/04","2020/09/11",100.0,200.0,"4","1","2"),
		("4","2020/09/04","2020/09/11",100.0,200.0,"3","4","1"),
		("3","2020/09/04","2020/09/11",100.0,200.0,"5","3","3"),
		("5","2020/09/04","2020/09/11",100.0,200.0,"6","2","2");
insert into attach_service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
value ("1","massage",100.0,2,"có sẵn"),
	  ("2","karaoke",50.0,4,"có sẵn"),
	  ("3","thức ăn",10.0,4,"có sẵn"),
	  ("4","nước uống",10.0,4,"có sẵn"),
	  ("5","thuê xe",10.0,4,"có sẵn");
insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quanlity)
value ("1","1","1",1),
	  ("2","2","2",5),
      ("3","3","3",2),
      ("4","4","5",3),
      ("5","5","4",2);

 select customer.customer_id, customer.customer_name, service.service_id, service.service_name, contract.contract_id, attach_service.attach_service_name
 from customer
 join contract on customer.customer_id = contract.customer_id
 join service on service.service_id = contract.service_id
 join contract_detail on contract.contract_id = contract_detail.contract_id
 join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;
