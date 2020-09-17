USE furama;

-- 2. Hiển thị thông tin của tất cả các nhân viên có trong hệ thống có tên bất đầu
--   	là một trong các ký tự 	"H", "T" hoặc "K" và có tối đa là 15 ký tự.
SELECT *
FROM nhan_vien
WHERE 
	(ho_ten LIKE 'H%' OR ho_ten LIKE 'T%' OR ho_ten LIKE 'K%') AND LENGTH(ho_ten) <= 15;


-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 và có địa chỉ
-- 		ở "Đà Nẵng" hoặc "Quảng Trị".
SELECT *, (YEAR(CURDATE()) - YEAR(ngay_sinh)) AS age
FROM khach_hang
HAVING age <= 50 AND age >= 18
    AND (dia_chi = 'da nang'
    OR dia_chi = 'quang tri');
    
    
-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả
-- 		hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm
-- 		những khách hàng nào có tên loại khách hàng là "Diamond".
SELECT kh.ho_ten, COUNT(hd.id_khach_hang) AS 'so_lan_dat_phong', lk.ten_loai_khach
FROM khach_hang kh
        JOIN hop_dong hd ON kh.id_khach_hang = hd.id_khach_hang
        JOIN loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
WHERE kh.id_loai_khach = 1
GROUP BY kh.ho_ten
ORDER BY COUNT(hd.id_khach_hang);


-- 5. Hiển Thị "id_khach_hang, ho_ten, ten_loai_khach, id_hop_dong, ten_dich_vu, ngay_lam_hop_dong, 
-- 		ngay_ket_thuc, tong_tien"(với công thức tính "tong_tien = chi_phi_thue + so_luong * gia")
-- 		cho tất cả khách hàng từng đặt phòng(những khách hàng chưa đặt cũng hiển thị ra).
select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
		sum(chi_phi_thue + so_luong * gia) as tong_tien
from khach_hang kh
	left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
    left join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
    left join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
    left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
    group by kh.id_khach_hang;
    


