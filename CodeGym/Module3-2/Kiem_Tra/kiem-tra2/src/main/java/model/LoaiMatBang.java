package model;

public class LoaiMatBang {
    private int id_loai_mat_bang;
    private String ten_loai_mat_bang;

    public LoaiMatBang(int id_loai_mat_bang, String ten_loai_mat_bang) {
        this.id_loai_mat_bang = id_loai_mat_bang;
        this.ten_loai_mat_bang = ten_loai_mat_bang;
    }

    public LoaiMatBang() {

    }

    public int getId_loai_mat_bang() {
        return id_loai_mat_bang;
    }

    public void setId_loai_mat_bang(int id_loai_mat_bang) {
        this.id_loai_mat_bang = id_loai_mat_bang;
    }

    public String getTen_loai_mat_bang() {
        return ten_loai_mat_bang;
    }

    public void setTen_loai_mat_bang(String ten_loai_mat_bang) {
        this.ten_loai_mat_bang = ten_loai_mat_bang;
    }

}
