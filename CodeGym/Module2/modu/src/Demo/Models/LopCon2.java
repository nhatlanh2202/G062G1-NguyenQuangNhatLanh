package Demo.Models;

public class LopCon2 extends LopCha {
    private String giaXuatKhau;
    private String quocGiaNhapSanPham;

    public LopCon2() {
    }

    public LopCon2(int idSanPham, String maSanPham, String tenSanPham, String giaBan, String soLuong, String nhaSanXuat, String giaXuatKhau, String quocGiaNhapSanPham) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public String getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(String giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String showInfo(){
        return this.getIdSanPham() + "," + this.getMaSanPham() + "," + this.getTenSanPham() + "," + this.getGiaBan()
                + "," + this.getSoLuong() + "," + this.getNhaSanXuat() + "," + this.giaXuatKhau + "," + this.quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return "LopCon2{" + super.toString() +
                "Gia Xuat Khau ='" + giaXuatKhau + '\'' +
                ", Quoc Gia Nhap San Pham ='" + quocGiaNhapSanPham + '\'' +
                '}';
    }
}
