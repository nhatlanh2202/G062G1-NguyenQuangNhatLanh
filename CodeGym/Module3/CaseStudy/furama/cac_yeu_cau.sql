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
SELECT kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
		SUM(chi_phi_thue + so_luong * gia) AS tong_tien
FROM khach_hang kh
	LEFT JOIN loai_khach lk ON kh.id_loai_khach = lk.id_loai_khach
    LEFT JOIN hop_dong hd ON hd.id_khach_hang = kh.id_khach_hang
    LEFT JOIN dich_vu dv ON dv.id_dich_vu = hd.id_dich_vu
    LEFT JOIN hop_dong_chi_tiet hdct ON hd.id_hop_dong = hdct.id_hop_dong
    LEFT JOIN dich_vu_di_kem dvdk ON hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
    GROUP BY kh.id_khach_hang;
    
    
-- 6. Hiển thị "id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu" của tất cả các loại 
-- 		dịch vụ chưa từng được khách hàng đặt từ quý 1 của năm 2019(quý 1 là tháng 1, 2, 3).
SELECT dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
	LEFT JOIN loai_dich_vu ldv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
    WHERE dv.id_dich_vu NOT IN (
		SELECT dv.id_dich_vu
		FROM dich_vu dv
		LEFT JOIN hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
		WHERE (MONTH(hd.ngay_lam_hop_dong)) = 1 OR MONTH(hd.ngay_lam_hop_dong) = 2 OR MONTH(hd.ngay_lam_hop_dong) = 3
		AND YEAR(hd.ngay_lam_hop_dong) = 2019);
        
        
-- 7. Hiển thị thông tin "id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
-- 		của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2018 nhưng chưa từng được 
-- 		khách hàng đặt phòng trong năm 2019.
SELECT dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
	LEFT JOIN loai_dich_vu ldv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
    LEFT JOIN hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2018 AND hd.id_dich_vu NOT IN (
		SELECT id_dich_vu
        FROM hop_dong
        WHERE YEAR(ngay_lam_hop_dong) = 2019);
    
    


