drop database if exists project1_ticket_agency;
create database project1_ticket_agency;
use project1_ticket_agency;

CREATE TABLE `role` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40)
);
insert into `role`
values
	(1, "Admin"),
	(2, "Employee"),
	(3, "User");

CREATE TABLE `account` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(40),
    `password` VARCHAR(40),
    role_id BIGINT,
    FOREIGN KEY (role_id)
        REFERENCES `role` (id)
);

CREATE TABLE `admin` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40),
    birth_day DATE,
    address VARCHAR(40),
    email VARCHAR(40),
    gender BIT,
    phone varchar (45),
    account_id BIGINT,
    FOREIGN KEY (account_id)
        REFERENCES `account` (id)
);

CREATE TABLE luggage (
    id BIGINT PRIMARY KEY,
    `name` VARCHAR(40),
    price DOUBLE
);

insert into luggage
values 
	(1,'Gói 15kg',155000),
	(2,'Gói 20kg',175000),
	(3,'Kiện HLQK 20kg',375000);
    
CREATE TABLE user_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45)
);

CREATE TABLE `user` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(45),
    birth_day DATE,
    address VARCHAR(255),
    email VARCHAR(45),
    gender VARCHAR(45),
    number_phone VARCHAR(45),
    `rank` VARCHAR(45),
    account_id BIGINT,
    FOREIGN KEY (account_id)
        REFERENCES `account` (id),
    user_type_id BIGINT,
    FOREIGN KEY (user_type_id)
        REFERENCES user_type (id)
);

CREATE TABLE booking (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_code VARCHAR(40),
    booking_date DATE,
    user_id BIGINT,
    FOREIGN KEY (user_id)
        REFERENCES `user` (id)
);

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_code VARCHAR(40),
    full_name VARCHAR(40),
    birth_day DATE,
    gender VARCHAR(40),
    email VARCHAR(40),
    number_phone VARCHAR(40),
    account_id BIGINT,
    FOREIGN KEY (account_id)
        REFERENCES `account` (id)
);

CREATE TABLE passenger (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50),
    birth_day VARCHAR(50),
    gender BIGINT,
    email VARCHAR(50),
    phone_number VARCHAR(20),
    id_card VARCHAR(50),
    luggage_id BIGINT,
    FOREIGN KEY (luggage_id)
        REFERENCES luggage (id),
    passenger_id BIGINT,
    FOREIGN KEY (passenger_id)
        REFERENCES passenger (id)
);

CREATE TABLE status_payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NULL
);

INSERT INTO status_payment (id, `name`) VALUES (1, 'Cancel');
INSERT INTO status_payment (id, `name`) VALUES (2, 'Pending');
INSERT INTO status_payment (id, `name`) VALUES (3, 'Paid');

CREATE TABLE feedback (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sender_name VARCHAR(45),
    sender_email VARCHAR(45),
    title VARCHAR(45),
    content VARCHAR(45),
    send_date DATE,
    `status` BIT
);

insert into feedback(id,sender_name,sender_email,title,content,send_date,`status`)
values (1, 'Lành', 'nhatlanh2202@gmail.com', 'Chuyến bay', 'tôi không hài lòng về...', '2020-12-10', 1),
(2, 'Phong', 'phong@gmail.com', 'Chuyến bay', 'tôi không hài lòng về...', '2020-12-11', 0);

CREATE TABLE message (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(40),
    send_date DATE,
    `status` BIT
);

CREATE TABLE flight_infomation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    airline VARCHAR(40),
    depature VARCHAR(40),
    arrival VARCHAR(40),
    depature_date DATE,
    arrival_date DATE,
    depature_time TIME,
    arrival_time TIME,
    flight_code VARCHAR(40),
    `type` VARCHAR(40),
    price DOUBLE
);
-- ------ Chuyến đi
insert into flight_infomation(airline,depature,arrival,depature_date,arrival_date,depature_time,arrival_time,flight_code,`type`,price)
-- Đà Nẵng
values('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VJ629','Hạng nhất',2300000 ),
-- -----------------------------------
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng nhất',2300000 ),
-- -----------------------------------
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-18','2020-12-18','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-18','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-18','2020-12-18','11:40','13:05','VJ629','Hạng nhất',2300000 ),
-- -----
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng nhất',2300000 ),
-- ------
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng nhất',2300000 ),
-- --------- viet name
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-16','2020-12-16','11:40','13:05','VN131','Hạng nhất',2300000 ),
-- -----------------------------------
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng nhất',2300000 ),
-- -----------------------------------
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng nhất',2300000 ),
-- -----
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng nhất',2300000 ),
-- ------
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','Đà Nẵng (DAD)','TP Hồ Chí Minh (SGN)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng nhất',2300000 ),
-- --------- chiều về
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VN131','Hạng nhất',2300000),
-- ------
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VN131','Hạng nhất',2300000),
-- ------
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VN131','Hạng nhất',2300000),
-- ------
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VN131','Hạng nhất',2300000),
-- ------
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VN131','Hạng phổ thông',49000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VN131','Hạng thương gia',699000),
('VietnamAirlines','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VN131','Hạng nhất',2300000),
-- ------- Viet ject
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-17','2020-12-17','11:40','13:05','VJ629','Hạng nhất',2300000),
-- ------
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-18','2020-12-18','11:40','13:05','VJ629','Hạng nhất',2300000),
-- ------
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-19','2020-12-19','11:40','13:05','VJ629','Hạng nhất',2300000),
-- ------
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-20','2020-12-20','11:40','13:05','VJ629','Hạng nhất',2300000),
-- ------
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VJ629','Hạng phổ thông',49000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VJ629','Hạng thương gia',699000),
('VietJet','TP Hồ Chí Minh (SGN)','Đà Nẵng (DAD)','2020-12-21','2020-12-21','11:40','13:05','VJ629','Hạng nhất',2300000);
CREATE TABLE invoice (
    id BIGINT PRIMARY KEY,
    invoid_code VARCHAR(40),
    form_code VARCHAR(40),
    date_create DATETIME,
    total_money DOUBLE,
    booking_id BIGINT,
    FOREIGN KEY (booking_id)
        REFERENCES booking (id)
);
CREATE TABLE ticket (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_code VARCHAR(45),
    booking_code VARCHAR(45),
    price_detarture DOUBLE,
    price_arrival DOUBLE,
    flight_id BIGINT,
    customer_type_id BIGINT,
    booking_date DATE,
    status_payment VARCHAR(45),
    status_checkin VARCHAR(45),
    flight_code_id BIGINT,
    FOREIGN KEY (flight_code_id)
        REFERENCES flight_infomation (id),
    passenger_id BIGINT,
    FOREIGN KEY (passenger_id)
        REFERENCES passenger (id),
    status_payment_id BIGINT,
    FOREIGN KEY (status_payment_id)
        REFERENCES status_payment (id),
    employee_id BIGINT,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id),
    invoice_id BIGINT,
    FOREIGN KEY (invoice_id)
        REFERENCES invoice (id)
);