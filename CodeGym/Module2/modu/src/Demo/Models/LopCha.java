package Demo.Models;

public abstract class LopCha {
    private int idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private String giaBan;
    private String soLuong;
    private String nhaSanXuat;

    public LopCha() {
    }

    public LopCha(int idSanPham, String maSanPham, String tenSanPham, String giaBan, String soLuong, String nhaSanXuat) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return "LopCha{" +
                "Id San Pham =" + idSanPham +
                ", Ma San Pham ='" + maSanPham + '\'' +
                ", Ten San Pham ='" + tenSanPham + '\'' +
                ", Gia Ban ='" + giaBan + '\'' +
                ", So Luong ='" + soLuong + '\'' +
                ", Nha San Xuat ='" + nhaSanXuat + '\'' +
                '}';
    }
}
