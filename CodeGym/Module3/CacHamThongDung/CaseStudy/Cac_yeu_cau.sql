use furama_resort_demo;

-- 2. Hiển thị thông tin tất cả các nhân viên có trong hệ thống có họ tên bất đầu
--    trong các ký tự "H","T" hoặc "K" và có tối đa 15 ký tự.
select *
from nhan_vien
where ho_ten 
regexp '(H|K|T)[:alpha:]*$' and length(ho_ten) <= 15;


-- 3. Hiển thị thông tin tất cả khách hàng có độ tuổi từ 18 đến 50 và có đia chỉ 
--    ở " Đà Nẵng " hoặc " Quảng Trị ".
select *
from khach_hang
where (year(now())- year(ngay_sinh) between 18 and 50) and (dia_chi in ('Đà Nẵng','Quảng Trị'));


-- 4. Đếm khách hàng đã đặt hàng bao nhiêu lần. Hiển thị kết quả được sắp xếp tăng dần
--    theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng có tên loại khách hàng là "Diamond".
select count(hd.id_khach_hang) as 'so_lan_dat_phong', kh.ho_ten, lk.ten_loai_khach
from hop_dong hd
right join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
inner join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
where lk.ten_loai_khach = 'Diamond'
group by kh.id_khach_hang
order by count(hd.id_khach_hang);


-- 5. Hiển thị 'id_khach_hang', 'ho_ten', 'ten_loai_khach', 'id_hop_dong', 'ten_dich_vu', 
-- 		'ngay_lam_hop_dong', 'ngay_ket_thuc', 'tong_tien'
--  Công thức: 'chi_phi_thue' + 'so_luong' * 'gia' ( với 'so_luong' và 'gia' là từ bảng 'dich_vu_di_kem')
-- 				cho tất các khách hàng đã từng đặt phòng(những khách hàng nào chưa đặt cũng hiển thị ra).
select kh.id_khach_hang, ho_ten, lk.ten_loai_khach, hd.id_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, sum(chi_phi_thue + so_luong * gia) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
left join hop_dong hd on kh.id_hop_dong = hd.id_hop_dong
left join hop_dong_chi_tiet hdct on kh.id_hop_dong_chi_tiet = hdct.id_hop_dong_chi_tiet
left join dich_vu_di_kem dvdk on kh.id_dich_vu_di_kem = dvhk.id_dich_vu_di_kem
group by kh.id_khach_hang 

    
