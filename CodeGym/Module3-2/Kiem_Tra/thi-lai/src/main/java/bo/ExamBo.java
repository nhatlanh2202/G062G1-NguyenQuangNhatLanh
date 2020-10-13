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
    public String insertMatBang(MatBang matBang) {
        String message;
        if (!Validation.regexID(matBang.getMa_mat_bang())){
            message = "format id ....";
        }else if (!Validation.regexArea(String.valueOf(matBang.getDien_tich()))){
            message = "format area ....";
        }else if (!Validation.regexFloors(String.valueOf(matBang.getTang()))){
            message = "format floors ....";
        }else if (!Validation.regexPrice(String.valueOf(matBang.getGia_tien()))){
            message = "format price ....";
        }else message = this.examDao.insertMatBang(matBang);
//        examDao.insertMatBang(matBang);

        return message;
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
