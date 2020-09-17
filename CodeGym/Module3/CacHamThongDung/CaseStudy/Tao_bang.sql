drop database if exists furama_resort_demo;
create database furama_resort_demo;
use furama_resort_demo;

-- 1.bảng vị trí nhân viên
create table Vi_Tri(
	id_vi_tri int primary key not null auto_increment,
    ten_vi_tri varchar(45)
);

-- 2.bảng trình độ nhân viên
create table Trinh_Do(
	id_trinh_do int primary key not null auto_increment,
    ten_trinh_do varchar(45)
);


-- 3.bảng bộ phận
create table Bo_Phan(
	id_bo_phan int primary key not null auto_increment,
    ten_bo_phan varchar(45)
);

-- 4.bảng loại khách hàng
create table Loai_Khach(
	id_loai_khach int primary key not null auto_increment,
    ten_loai_khach varchar(45)
);

-- 5.bảng kiểu thuê của khách hàng
create table Kieu_Thue(
	id_kieu_thue int primary key not null auto_increment,
    ten_kieu_thue varchar(45),
    gia int
);

-- 6.bảng các loại dịch vụ 
create table Loai_Dich_Vu(
	id_loai_dich_vu int primary key not null auto_increment,
    ten_loai_dich_vu varchar(45)
);

-- 7.bảng dịch vụ đi kèm
create table Dich_Vu_Di_Kem(
	id_dich_vu_di_kem int primary key not null auto_increment,
    ten_dich_vu_di_kem varchar(45),
    gia int,
    don_vi int,
    trang_thai_kha_dung varchar(45)
);

-- 8.bảng khách hàng
create table Khach_Hang(
	id_khach_hang int primary key not null auto_increment,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    id_loai_khach int,
    foreign key(id_loai_khach) references Loai_Khach(id_loai_khach)
);

-- 9.bảng dịch vụ
create table Dich_Vu(
	id_dich_vu int primary key not null auto_increment,
    ten_dich_vu varchar(45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da varchar(45),
    chi_phi_thue varchar(45),
    trang_thai varchar(45),
    id_kieu_thue int,
    id_loai_dich_vu int,
    foreign key(id_kieu_thue) references Kieu_Thue(id_kieu_thue),
    foreign key(id_loai_dich_vu) references Loai_Dich_Vu(id_loai_dich_vu)
);

-- 10.bảng nhân viên
create table Nhan_Vien(
	id_nhan_vien int primary key not null auto_increment,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(45),
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    foreign key(id_vi_tri) references Vi_Tri(id_vi_tri),
    foreign key(id_trinh_do) references Trinh_Do(id_trinh_do),
    foreign key(id_bo_phan) references Bo_Phan(id_bo_phan)
);


-- 11.bảng hợp đồng
create table Hop_Dong(
	id_hop_dong int primary key not null auto_increment,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    foreign key(id_nhan_vien) references Nhan_Vien(id_nhan_vien),
    foreign key(id_khach_hang) references Khach_Hang(id_khach_hang),
    foreign key(id_dich_vu) references Dich_Vu(id_dich_vu)
);

-- 12.bảng hợp đồng chi tiết
create table Hop_Dong_Chi_Tiet(
	id_hop_dong_chi_tiet int primary key not null auto_increment,
    so_luong int,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    foreign key(id_hop_dong) references Hop_Dong(id_hop_dong),
    foreign key(id_dich_vu_di_kem) references Dich_Vu_Di_Kem(id_dich_vu_di_kem)
);

