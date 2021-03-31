
drop database if exists feedback_project;
create database feedback_project;

use feedback_project;

create table feedback (
	id bigint primary key auto_increment,
    sender_name varchar(45),
    sender_email varchar(45),
    title varchar(45),
    content varchar(45),
    send_date date,
    `status` bit
);

insert into feedback
values
	(1,'Lành','nhatlanh2202@gmail.com','máy bay','tôi là ai? tôi đang ở đâu?','2020-12-10',1),
	(2,'Phong','phong@gmail.com','máy bay','tôi là ai? tôi đang ở đâu?','2020-12-11',1),
	(3,'Nguyệt','nguyet@gmail.com','đại lý','tôi là ai? tôi đang ở đâu?','2020-12-12',0)