package Demo.Views;

import Demo.Commons.DocGhiFile;
import Demo.Commons.Validate;
import Demo.Models.LopCha;
import Demo.Models.LopCon1;


import java.util.List;

public class ChucNang {
    private static int bienDemId;

    public static int demId(){
        List<LopCha> lopChaList = DocGhiFile.read();
        if (lopChaList.isEmpty()) bienDemId = 1;
        else {
            bienDemId = lopChaList.get(lopChaList.size() - 1).getIdSanPham() + 1;
        }
        return bienDemId;
    }

    public static void themMoi() {
        int id = demId();
        String maSanPham = Validate.kiemTraNhapChu("ma san pham");
        String tenSanPham = Validate.kiemTraNhapChu("ten san pham");
        String giaBan = Validate.kiemTraNhapSo("gia ban");
        String soLuong = Validate.kiemTraNhapSo("so luong");
        String tenNhaSanXuat = Validate.kiemTraNhapChu("ten nha san xuat");
        String giaNhapKhau = Validate.kiemTraNhapSo("gia nhap khau");
        String tenTinhNhap = Validate.kiemTraNhapChu("ten tinh nhap hang");
        String thue = Validate.kiemTraNhapSo("thue");
        LopCha lopCha = new LopCon1(id,)
    }

    public static void xoa() {
    }


    public static void xemDanhSach() {
    }

    public static void timKiem() {
    }






}
