package model;

public class MatBang {
    private String ma_mat_bang;
    private int id_trang_thai;
    private double dien_tich;
    private int tang;
    private int id_loai_mat_bang;
    private double gia_tien;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    public MatBang(String ma_mat_bang, int id_trang_thai, double dien_tich, int tang, int id_loai_mat_bang, double gia_tien, String ngay_bat_dau, String ngay_ket_thuc) {
        this.ma_mat_bang = ma_mat_bang;
        this.id_trang_thai = id_trang_thai;
        this.dien_tich = dien_tich;
        this.tang = tang;
        this.id_loai_mat_bang = id_loai_mat_bang;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public String getMa_mat_bang() {
        return ma_mat_bang;
    }

    public void setMa_mat_bang(String ma_mat_bang) {
        this.ma_mat_bang = ma_mat_bang;
    }

    public int getId_trang_thai() {
        return id_trang_thai;
    }

    public void setId_trang_thai(int id_trang_thai) {
        this.id_trang_thai = id_trang_thai;
    }

    public double getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(double dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getId_loai_mat_bang() {
        return id_loai_mat_bang;
    }

    public void setId_loai_mat_bang(int id_loai_mat_bang) {
        this.id_loai_mat_bang = id_loai_mat_bang;
    }

    public double getGia_tien() {
        return gia_tien;
    }

    public void setGia_tien(double gia_tien) {
        this.gia_tien = gia_tien;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
