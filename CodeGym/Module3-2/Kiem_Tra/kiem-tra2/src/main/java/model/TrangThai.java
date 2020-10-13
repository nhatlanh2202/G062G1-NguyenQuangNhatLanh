package model;

public class TrangThai {
    private int id_trang_thai;
    private String ten_trang_thai;

    public TrangThai(int id_trang_thai, String ten_trang_thai) {
        this.id_trang_thai = id_trang_thai;
        this.ten_trang_thai = ten_trang_thai;
    }

    public TrangThai() {

    }

    public int getId_trang_thai() {
        return id_trang_thai;
    }

    public void setId_trang_thai(int id_trang_thai) {
        this.id_trang_thai = id_trang_thai;
    }

    public String getTen_trang_thai() {
        return ten_trang_thai;
    }

    public void setTen_trang_thai(String ten_trang_thai) {
        this.ten_trang_thai = ten_trang_thai;
    }
}
