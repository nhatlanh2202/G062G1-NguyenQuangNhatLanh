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
        
-- TAST 8: Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
select kh.ho_ten
from khach_hang kh
union
select kh.ho_ten
from khach_hang kh;


-- TAST 9: Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
-- 			 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong) as 'Tháng',count(id_khach_hang) as 'Số lượng khách hàng đặt phòng'
from hop_dong 
where year(ngay_lam_hop_dong) = 2019
group by ngay_lam_hop_dong;

-- TAST 10: Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- 			Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong,
-- 			NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select h.id_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, count(hc.id_hop_dong_chi_tiet) as 'số lượng dịch vụ đi kèm'
from hop_dong h
join hop_dong_chi_tiet hc on h.id_hop_dong = hc.id_hop_dong
group by id_hop_dong;

-- TAST 11:	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- 				TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select k.ho_ten, k.dia_chi, lk.ten_loai_khach, dv.ten_dich_vu_di_kem
from khach_hang k
join loai_khach lk on k.id_loai_khach = lk.id_loai_khach
left join hop_dong h on k.id_khach_hang = h.id_khach_hang
left join hop_dong_chi_tiet hc on h.id_hop_dong = hc.id_hop_dong
left join dich_vu_di_kem dv on hc.id_dich_vu_di_kem = dv.id_dich_vu_di_kem 
where ten_loai_khach = 'Diamond' and (dia_chi = 'vinh' or dia_chi = 'quang ngai')
group by ho_ten, ten_dich_vu_di_kem;

-- TAST 12: Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select h.id_hop_dong, nv.ho_ten as 'nhân viên', kh.ho_ten as 'khách hàng', kh.SDT, dv.ten_dich_vu, sum(ct.so_luong), h.tien_dat_coc
from hop_dong h
join nhan_vien nv on h.id_nhan_vien = nv.id_nhan_vien 
join khach_hang kh on h.id_khach_hang = kh.id_khach_hang
join dich_vu dv on h.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet ct on h.id_hop_dong = ct.id_hop_dong
where (month(h.ngay_lam_hop_dong) > 9 
and h.id_hop_dong not in(
select id_hop_dong
from hop_dong
where month(hop_dong.ngay_lam_hop_dong) <10))
and year(h.ngay_lam_hop_dong) = 2019
group by id_hop_dong;

-- TAST 13:	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều 
-- như nhau)
create view max
as
select  dv.ten_dich_vu_di_kem, count(dv.id_dich_vu_di_kem) as 'so_luong_lon_nhat'
from hop_dong h
left join hop_dong_chi_tiet hc on h.id_hop_dong = hc.id_hop_dong
left join dich_vu_di_kem dv on hc.id_dich_vu_di_kem = dv.id_dich_vu_di_kem 
group by  ten_dich_vu_di_kem
having count(dv.id_dich_vu_di_kem)
order by count(dv.id_dich_vu_di_kem) desc;

select *
from max
group by ten_dich_vu_di_kem
having so_luong_lon_nhat = (select max(so_luong_lon_nhat) from max);

-- TAST 14:	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem,
-- SoLanSuDung.

select h.id_hop_dong, ldv.ten_loai_dich_vu, dk.ten_dich_vu_di_kem, count(dk.id_dich_vu_di_kem) as 'so_lan_su_dung'
from hop_dong h
join dich_vu dv on h.id_dich_vu = dv.id_dich_vu
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong_chi_tiet hc on h.id_hop_dong = hc.id_hop_dong
join dich_vu_di_kem dk on hc.id_dich_vu_di_kem = dk.id_dich_vu_di_kem
group by dk.ten_dich_vu_di_kem
having count(dk.id_dich_vu_di_kem) <= 1;

-- TAST 15:	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng 
-- từ năm 2018 đến 2019.

select nv.id_nhan_vien, nv.ho_ten, b.ten_bo_phan, nv.SDT, nv.dia_chi, count(hd.id_nhan_vien) 
from nhan_vien nv
join trinh_do td on nv.id_trinh_do = td.id_trinh_do
join bo_phan b on nv.id_bo_phan = b.id_bo_phan
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where year(hd.ngay_lam_hop_dong) in (2018, 2019) 
group by nv.id_nhan_vien
having  count(hd.id_nhan_vien) <= 3; 

-- TAST 16:	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhan_vien 
where id_nhan_vien not in (
select id_nhan_vien
from (select nv.id_nhan_vien from nhan_vien nv
join hop_dong on nv.id_nhan_vien = hop_dong.id_nhan_vien 
where year( hop_dong.ngay_lam_hop_dong) in (2017, 2019)) as c);

-- TAST 17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update khach_hang
set id_loai_khach = 1
where id_loai_khach in (select id_loai_khach 
from (select kh.id_loai_khach from khach_hang kh 
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
where year(hd.ngay_lam_hop_dong) = 2019 and hd.tong_tien > 10000000 and kh.id_loai_khach = 2
group by kh.ho_ten, kh.id_loai_khach) as c);

-- TAST 18:	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

SET FOREIGN_KEY_CHECKS = 0;
delete from khach_hang
where id_khach_hang in (select id_khach_hang
from (select kh.id_khach_hang from khach_hang kh 
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
where year(hd.ngay_lam_hop_dong) < 2016) as c);
SET FOREIGN_KEY_CHECKS = 1;

-- TAST 19:	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem 
set gia = gia * 2
where gia in (select gia
from(select dvdk.gia, dvdk.id_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having sum(hdct.so_luong) > 10) as g );

-- select dvdk.id_dich_vu_di_kem, sum(hdct.so_luong), dvdk.gia
-- from dich_vu_di_kem dvdk
-- join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
-- group by dvdk.id_dich_vu_di_kem
-- having sum(hdct.so_luong) > 10 

create view gia
as
select dvdk.gia, dvdk.id_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having sum(hdct.so_luong) > 10;

update dich_vu_di_kem dvdk
join gia on dvdk.id_dich_vu_di_kem = gia.id_dich_vu_di_kem
set dvdk.gia = dvdk.gia * 2;


-- TAST 20:	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select nv.id_nhan_vien as 'id', nv.ho_ten, nv.email, nv.SDT, nv.ngay_sinh, nv.dia_chi, 'nhân viên' as 'phân loại'
from nhan_vien nv 
union
select kh.id_khach_hang , kh.ho_ten, kh.email, kh.SDT, kh.ngay_sinh, kh.dia_chi, 'khách hàng' as 'phân loại'
from khach_hang kh ;
    


