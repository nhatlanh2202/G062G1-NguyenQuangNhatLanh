package bo;

import dao.ExamDao;
import model.DTOMatBang;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.util.List;

public class ExamBo implements IExamBo {
    ExamDao examDao = new ExamDao();
    @Override
    public List<DTOMatBang> selectAllMatBang() {
        return examDao.selectAllMatBang() ;
    }

    @Override
    public List<TrangThai> selectAllTrangThai() {
        return examDao.selectAllTrangThai();
    }

    @Override
    public List<LoaiMatBang> selectAllLoaiMatBang() {
        return examDao.selectAllLoaiMatBang();
    }

    @Override
    public void insertMatBang(MatBang matBang) {
        examDao.insertMatBang(matBang);
    }


    @Override
    public boolean deleteCustomer(String ma_mat_bang) {
        return examDao.deleteCustomer(ma_mat_bang);
    }

    @Override
    public List<DTOMatBang> searchByTang(int tang) {
        return examDao.searchByTang(tang);
    }

    @Override
    public List<DTOMatBang> searchByGia(double gia_tien) {
        return examDao.searchByGia(gia_tien);
    }

    @Override
    public List<DTOMatBang> searchByLoaiMatBang(String ten_loai_mat_bang) {
        return examDao.searchByLoaiMatBang(ten_loai_mat_bang);
    }

}
