USE furama;

INSERT INTO furama.`bo_phan` (ten_bo_phan)
 VALUES
 ('sale_maketing'),
 ('hanh chinh'),
 ('phuc vu'),
 ('quan ly');
 INSERT INTO furama.`trinh_do` (trinh_do)
 VALUES 
 ('trung cap'),
 ('cao dang'),
 ('dai hoc'),
 ('sau dai hoc');
INSERT INTO furama.`vi_tri` (ten_vi_tri) 
VALUES 
('le tan'),
('phuc vu'),
('chuyen vien'),
('giám sát'),
('quan ly'),
('giam doc');
INSERT INTO furama.`loai_khach` (ten_loai_khach) 
VALUES 
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

INSERT INTO furama.`khach_hang` (ho_ten, ngay_sinh, so_CMND, SDT, email, dia_chi, id_loai_khach) 
VALUES 
('Khang', '2000-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', 1),
('Thien', '2000-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', 2),
('Phong', '2000-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang nam', 1),
('Hoai', '2000-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', 4),
('Lanh', '2000-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', 5);


 INSERT INTO furama.`nhan_vien` (ho_ten, ngay_sinh, so_CMND, luong, SDT, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan) 
 VALUES 
 ('Chau', '1999-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', 1 , 1 , 3),
 ('Khanh', '1993-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', 2, 1, 4),
 ('Vu', '1989-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', 1, 2, 1),
 ('Thanh', '1982-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', 1, 1, 3),
 ('Linh', '1999-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', 1, 2, 1);
 INSERT INTO furama.`loai_dich_vu` (ten_loai_dich_vu) 
 VALUES 
 ('villa'),
 ('house'),
 ('room');
 INSERT INTO furama.`kieu_thue` (ten_kieu_thue, gia) 
VALUES 
('nam', 120),
('thang', 10),
('ngay', 3),
('gio', 1);
 INSERT INTO furama.`dich_vu` (ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, trang_thai, id_kieu_thue, id_loai_dich_vu)
 VALUES 
 ('villa1', 30, 2, '10', 30, 'avairable', 1, 1),
 ('villa2', 30, 1, '5', 15, 'avairable', 1, 1),
 ('house1', 30, 2, '10', 20, 'avairable', 2, 2),
 ('house2', 30, 1, '5', 10, 'avairable', 2, 2),
 ('room1', 30, 2, '10', 15, 'avairable', 3, 3),
 ('room2', 30, 1, '5', 8, 'avairable', 3, 3);
INSERT INTO furama.`hop_dong` (ngay_lam_hop_dong, ngay_ket_thuc, id_nhan_vien, id_khach_hang, id_dich_vu) 
VALUES 
('2019-10-19', '2019-10-22', 1, 1, 1),
('2019-03-19', '2019-04-19', 3, 3, 3),
('2019-04-19', '2020-04-19', 4, 4, 4);
INSERT INTO furama.`dich_vu_di_kem` (ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung) 
VALUES 
('massage', 15, 2, 'avairable'),
('karaoke', 15, 3, 'avairable'),
('thuc an', 15, 4, 'avairable'),
('nuoc uong', 15, 4, 'avairable'),
('thue xe', 15, 5, 'avairable');
INSERT INTO furama.`hop_dong_chi_tiet` (so_luong, id_hop_dong, id_dich_vu_di_kem) 
VALUES 
(2, 1, 1),
(2, 2, 1),
(2, 3, 2),
(2, 1, 3);
