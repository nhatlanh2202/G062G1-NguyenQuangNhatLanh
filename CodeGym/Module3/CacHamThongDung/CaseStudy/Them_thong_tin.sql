use furama_resort_demo;


-- 1. Thêm vị trí nhân viên.
insert into Vi_Tri (ten_Vi_Tri)
values
	('Lễ tân'),
    ('Phục vụ'),
    ('Chuyên viên'),
    ('Giám sát'),
    ('Quản lý'),
    ('Giám đốc');
    
-- 2.Thêm trình độ nhân viên.
insert into Trinh_Do(ten_Trinh_Do)
values
	('Trung cấp'),
    ('Cao đẳng'),
    ('Đại học'),
    ('Sau đại học');


-- 3.Thêm bộ phận nhân viên.
insert into Bo_Phan(ten_bo_phan)
values
	('Sale-Marketing'),
    ('Hành chính'),
    ('Phục vụ'),
    ('Quản lý');
    
    
-- 4.Thêm loại khách hàng.
insert into Loai_Khach(ten_loai_khach)
values
	('Diamond'),
    ('Platium'),
    ('Gold'),
    ('Silver'),
    ('Member');


-- 5.Thêm kiểu thuê.
insert into kieu_thue(ten_kieu_thue,gia)
values
	('Nửa ngày',10000),
    ('Một ngày',5000),
    ('Một tuần',5000);
    
    
-- 6.Thêm loại dịch vụ.
insert into loai_dich_vu(ten_loai_dich_vu)
values
	('Villa'),
    ('House'),
    ('Room');
    
    
-- 7. Thêm dịch vụ.
insert into dich_vu(id_kieu_thue, id_loai_dich_vu,ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue,
					trang_thai)
values
	(2,1,'Hội họp',100,10,20,15000,'còn chỗ'),
    (1,1,'Tiệc cưới',100,4,50,20000,'còn chỗ'),
    (3,2,'Đi du lịch',50,5,4,10000,'còn chỗ'),
    (3,3,'Tuần trăng mật',30,2,2,5000,'còn chỗ');
     
 
 -- 8.Thêm dịch vụ đi kèm
insert into Dich_Vu_Di_Kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
values
	('Thức ăn',1000,10,'còn hàng'),
    ('xe',1500,10,'còn hàng'),
    ('karaoke',1000,10,'còn hàng'),
    ('massage',1000,10,'còn hàng');
    
    
-- 9.Thêm nhân viên.
insert into Nhan_Vien(id_vi_tri,id_trinh_do,id_bo_phan,ho_ten,ngay_sinh,so_cmnd,luong,sdt,email,diachi)
values
	(6,4,4,'Trần Thánh Thiên','1990-02-20','1111111111','10000USD','012345678','thien@gmail.com','Đà Nẵng'),
    (5,3,4,'Nguyễn Ngọc Ngân','1992-12-12','2222222222','5000USD','123456789','ngan@gmail.com','Hà Nội'),
    (4,3,2,'Hồ Long Khang','1995-11-30','33333333333','3000USD','09627248','lan@gmail.com','Đà Nẵng'),
    (3,2,1,'Võ Văn Vũ','2000-02-20','4444444444','1000USD','01293823','vu@gmail.com','Đà Nẵng'),
    (2,2,3,'Diệp Dương','2000-12-20','555555555','500USD','01438223','duong@gmail.com','Đà Nẵng'),
    (1,1,3,'Mai Hân','1997-10-04','66666666','200USD','013438223','lemai@gmail.com','Đà Nẵng');
    
-- 10.Thêm khách hàng.
insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
values
	(1,'Nguyễn Quang Nhật Lành','2000-02-22','2017202029','079558875','lanh@gmail.com','Đà Nẵng'),
    (2,'Lương Phú Châu','1998-12-02','2010202010','098765672','chau@gmail.com','Hà Nội'),
    (3,'Trần Đức Vũ','1999-10-19','2016202018','012265479','vutran@gmail.com','Hồ Chí Minh'),
    (4,'Nguyễn Quốc Khánh','1995-07-19','2009202022','098767896','khanh@gmail.com','Đà Nẵng'),
    (5,'Nguyễn Đin','2001-01-10','2019202013','07951232','din@gmail.com','Đà Nẵng');
    
-- 11.Thêm hợp đồng.
insert into Hop_Dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc)
values
	(1,1,1,'2000-10-10','2010-10-10'),
    (2,2,1,'2018-10-10','2020-10-10');

-- 12.Thêm hợp đồng chi tiết
insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,id_hop_dong_chi_tiet,so_luong)
values
	(1,1,1,1),
    (2,2,2,1);