package BTNew;

import java.io.Serializable;

public class DanhBa implements Serializable {
    public static final String FORMAT = "%5d | %10s | %10s| %10s | %10s | %10s | %10s";
    private int id;
    private String hoTen;
    private String soDienThoai;
    private String nhom;
    private String gioiTinh;
    private String emali;
    private String điaChi;

    public DanhBa() {
    }

    public DanhBa(String hoTen, String soDienThoai, String nhom, String gioiTinh, String emali, String điaChi) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.nhom = nhom;
        this.gioiTinh = gioiTinh;
        this.emali = emali;
        this.điaChi = điaChi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmali() {
        return emali;
    }

    public void setEmali(String emali) {
        this.emali = emali;
    }

    public String getĐiaChi() {
        return điaChi;
    }

    public void setĐiaChi(String điaChi) {
        this.điaChi = điaChi;
    }

    @Override
    public String toString() {
        return String.format(FORMAT,id, hoTen, soDienThoai, nhom, gioiTinh, emali, getĐiaChi());
    }

}
