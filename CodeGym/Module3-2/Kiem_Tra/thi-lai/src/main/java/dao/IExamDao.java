package dao;



import model.DTOMatBang;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.util.List;

public interface IExamDao {
    List<DTOMatBang> selectAllMatBang();

    List<TrangThai> selectAllTrangThai();

    List<LoaiMatBang> selectAllLoaiMatBang();

    String insertMatBang(MatBang matBang);

    boolean deleteCustomer(String ma_mat_bang);

    List<DTOMatBang> searchByTang(int tang);

    List<DTOMatBang> searchByGia(double gia_tien);

    List<DTOMatBang> searchByLoaiMatBang(String ten_loai_mat_bang);
}
