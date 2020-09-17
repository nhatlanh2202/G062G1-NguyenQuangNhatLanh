create database lop_c0620g1;

use lop_c0620g1;

create table offices
(officeCode varchar(10) not null primary key,
 city varchar(50) not null,
 phone varchar(50) not null,
 addressLine1 varchar(50) not null,
 addressLine2 varchar(50),
 state varchar(50),
 country varchar(50) not null,
 postalCode varchar(15) not null
);

create table productlines
(productLine varchar(50) not null primary key,
 textDescription text,
 image varchar(255)
);

create table products
(productCode varchar(15) not null primary key,
 productName varchar(70) not null,
 productScale varchar(10) not null,
 productVendor varchar(50) not null,
 productDescription text not null,
 quantityInStock int not null,
 buyPrice float not null,
 MSRP float not null,
 productLine varchar(50) not null,
 foreign key(productLine) references productlines(productLine)
);

create table employees
(employeeNumber int not null primary key,
 lastName varchar(50) not null,
 firstName varchar(50) not null,
 email varchar(100) not null,
 jobTitle varchar(50) not null,
 reportTo int not null,
 foreign key(reportTo) references employees(employeeNumber),
 officeCode varchar(10) not null,
 foreign key (officeCode) references offices(officeCode)
);

create table customers
(customerNumber int not null primary key,
 customerName varchar(50) not null,
 contactFirstName varchar(50) not null,
 phone varchar(50) not null,
 addressLine1 varchar(50) not null,
 addressLine2 varchar(50),
 city varchar(50) not null,
 state varchar(50) not null,
 postalCode varchar(50) not null,
 country varchar(50) not null,
 creditLimit float,
 salesRepEmployeeNumber int not null,
 foreign key(salesRepEmployeeNumber) references employees(employeeNumber)
);

create table orders
(orderNumber int not null primary key,
 orderDate date not null,
 requiredDate date not null,
 shippedDate date not null,
 `status` varchar(15) not null,
 comments text not null,
 quantityOrdered int not null,
 priceEach float not null,
 customerNumber int,
 foreign key (customerNumber) references customers(customerNumber)
);

create table orderDetails
(orderNumber int not null,
 productCode varchar(15) not null,
 primary key (orderNumber, productCode),
 foreign key (orderNumber) references orders(orderNumber),
 foreign key (productCode) references products(productCode)
);

create table payments
(customerNumber int not null,
 checkNumber varchar(50) not null,
 paymentDate date not null,
 amount float not null,
 foreign key (customerNumber) references customers(customerNumber)
);