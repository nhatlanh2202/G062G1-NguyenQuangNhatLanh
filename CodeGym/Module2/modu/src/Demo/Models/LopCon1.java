package Demo.Models;

public class LopCon1 extends LopCha {
    private String giaNhapKhau;
    private String tinhThanhNhap;
    private String thueNhapKhau;

    public LopCon1(){
    }

    public LopCon1(int idSanPham, String maSanPham, String tenSanPham, String giaBan, String soLuong, String nhaSanXuat,
                   String giaNhapKhau, String tinhThanhNhap, String thueNhapKhau) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public String getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(String giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public String getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(String thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String showInfo(){
        return this.getIdSanPham() + "," + this.getMaSanPham() + "," + this.getTenSanPham() + "," + this.getGiaBan()
                 + "," + this.getSoLuong() + "," + this.getNhaSanXuat() + "," + this.giaNhapKhau + "," + this.tinhThanhNhap
                + "," + this.thueNhapKhau;
    }

    @Override
    public String toString() {
        return "LopCon1{" + super.toString() +
                "Gia Nhap Khau ='" + giaNhapKhau + '\'' +
                ", Tinh Thanh Nhap ='" + tinhThanhNhap + '\'' +
                ", Thue Nhap Khau ='" + thueNhapKhau + '\'' +
                '}';
    }
}
