drop database if exists furama;
create database furama;
use furama;

CREATE TABLE vi_tri (
    id_vi_tri INT auto_increment,
    ten_vi_tri VARCHAR(45),
    PRIMARY KEY (id_vi_tri)
);
CREATE TABLE trinh_do (
    id_trinh_do INT auto_increment,
    trinh_do VARCHAR(45),
    PRIMARY KEY (id_trinh_do)
);
CREATE TABLE bo_phan (
    id_bo_phan INT auto_increment,
    ten_bo_phan VARCHAR(45),
    PRIMARY KEY (id_bo_phan)
);
CREATE TABLE nhan_vien (
    id_nhan_vien INT auto_increment,
    ho_ten VARCHAR(50),
    ngay_sinh DATE,
    so_CMND VARCHAR(45),
    luong VARCHAR(45),
    SDT VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    id_vi_tri INT,
    id_trinh_do INT,
    id_bo_phan INT,
    PRIMARY KEY (id_nhan_vien),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);
CREATE TABLE loai_khach (
    id_loai_khach INT auto_increment,
    ten_loai_khach VARCHAR(45),
    PRIMARY KEY (id_loai_khach)
);
CREATE TABLE khach_hang (
    id_khach_hang INT auto_increment,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_CMND VARCHAR(45),
    SDT VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    id_loai_khach INT,
    PRIMARY KEY (id_khach_hang),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);
CREATE TABLE kieu_thue (
    id_kieu_thue INT auto_increment,
    ten_kieu_thue VARCHAR(45),
    gia INT,
    PRIMARY KEY (id_kieu_thue)
);
CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT auto_increment,
    ten_loai_dich_vu VARCHAR(45),
    PRIMARY KEY (id_loai_dich_vu)
);
CREATE TABLE dich_vu (
    id_dich_vu INT auto_increment,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da VARCHAR(45),
    chi_phi_thue INT,
    trang_thai VARCHAR(45),
    id_kieu_thue INT,
    id_loai_dich_vu INT,
    PRIMARY KEY (id_dich_vu),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
);
CREATE TABLE hop_dong (
    id_hop_dong INT auto_increment,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    id_nhan_vien INT,
    id_khach_hang INT,
    id_dich_vu INT,
    PRIMARY KEY (id_hop_dong),
	constraint fk_nhan_vien FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
	constraint fk_khach_hang FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)	
);
CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT auto_increment,
    ten_dich_vu_di_kem VARCHAR(45),
    gia INT,
    don_vi INT,
    trang_thai_kha_dung VARCHAR(45),
    PRIMARY KEY (id_dich_vu_di_kem)
);
CREATE TABLE hop_dong_chi_tiet (
    id_hop_dong_chi_tiet INT auto_increment,
    so_luong INT,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    PRIMARY KEY (id_hop_dong_chi_tiet),
    constraint fk_hop_dong FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem)
);

alter table hop_dong
drop foreign key fk_nhan_vien;

alter table hop_dong
add constraint fk_nhan_vien foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) on delete cascade
on update cascade;

alter table hop_dong
drop foreign key fk_khach_hang;
 
alter table hop_dong
add constraint fk_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang) on delete cascade
on update cascade;
 
alter table hop_dong_chi_tiet
drop foreign key fk_hop_dong;
 
alter table hop_dong_chi_tiet
add constraint fk_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong) on delete cascade
on update cascade;