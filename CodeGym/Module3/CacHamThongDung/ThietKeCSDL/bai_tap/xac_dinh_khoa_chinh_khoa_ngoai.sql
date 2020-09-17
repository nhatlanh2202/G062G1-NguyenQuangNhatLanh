create table customers
( customer_number int not null auto_increment,
  fullname varchar(50) not null,
  email varchar(50) not null,
  phonenumbers int,
  primary key (customer_number)
);

create table accounts
(account_number int primary key,
 account_type varchar(10),
 open_day datetime,
 balance varchar(50),
 customer_number int,
 foreign key (customer_number) references customers(customer_number)
);

create table transactions
(tran_number bigint primary key,
 account_number bigint,
 date_transactions datetime,
 amounts bigint,
 descriptions text(500),
 foreign key (account_number) references accounts(account_number)
);