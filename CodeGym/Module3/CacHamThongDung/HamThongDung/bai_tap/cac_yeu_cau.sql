use bai_tap;


-- hiển thị tất cả các tên 'Huong' trong bảng.
select *
from hoc_vien
where ten = 'Huong';

-- Hiển thị tổng số tiền của 'Huong' trong bảng.
select ten, sum(sotien)
from hoc_vien
where ten = 'Huong';

-- Hiển lấy ra tên tất cả học viên, không trùng lập.
select distinct ten
from hoc_vien;





