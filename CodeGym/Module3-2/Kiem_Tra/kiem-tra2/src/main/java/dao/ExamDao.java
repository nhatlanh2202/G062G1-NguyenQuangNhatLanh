package dao;

import model.DTOMatBang;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao implements IExamDao {
    DBConnection dBConnection = new DBConnection();
    private static final String SELECT_ALL_DTO_MAT_BANG = "select mb.ma_mat_bang, tt.ten_trang_thai, mb.dien_tich, mb.tang, lmb.ten_loai_mat_bang, mb.gia_tien, mb.ngay_bat_dau, mb.ngay_ket_thuc " +
            "from mat_bang mb " +
            "join trang_thai tt on mb.id_trang_thai = tt.id_trang_thai " +
            "join loai_mat_bang lmb on mb.id_loai_mat_bang = lmb.id_loai_mat_bang;";
    private static final String SELECT_ALL_TRANG_THAI = "select * from trang_thai;";
    private static final String SELECT_ALL_LOAI_MAT_BANG = "select * from loai_mat_bang;";
    private static final String INSERT_NEW_MAT_BANG = "insert into mat_bang(ma_mat_bang, id_trang_thai, dien_tich, tang, id_loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc) values (?,?,?,?,?,?,?,?);";
    private static final String DELETE_MAT_BANG = "delete from mat_bang where ma_mat_bang = ?;";
    private static final String SELECT_MAT_BANG_BY_GIA = "select mb.ma_mat_bang, tt.ten_trang_thai, mb.dien_tich, mb.tang, lmb.ten_loai_mat_bang, mb.gia_tien, mb.ngay_bat_dau, mb.ngay_ket_thuc\n" +
            "from mat_bang mb \n" +
            "join trang_thai tt on mb.id_trang_thai = tt.id_trang_thai\n" +
            "join loai_mat_bang lmb on mb.id_loai_mat_bang = lmb.id_loai_mat_bang\n" +
            "where mb.gia_tien = ?;";
    private static final String SELECT_MAT_BANG_BY_TANG = "select mb.ma_mat_bang, tt.ten_trang_thai, mb.dien_tich, mb.tang, lmb.ten_loai_mat_bang, mb.gia_tien, mb.ngay_bat_dau, mb.ngay_ket_thuc\n" +
            "from mat_bang mb \n" +
            "join trang_thai tt on mb.id_trang_thai = tt.id_trang_thai\n" +
            "join loai_mat_bang lmb on mb.id_loai_mat_bang = lmb.id_loai_mat_bang\n" +
            "where mb.tang = ?;";
    private static final String SELECT_MAT_BANG_BY_LOAI_MAT_BANG = "select mb.ma_mat_bang, tt.ten_trang_thai, mb.dien_tich, mb.tang, lmb.ten_loai_mat_bang, mb.gia_tien, mb.ngay_bat_dau, mb.ngay_ket_thuc\n" +
            "from mat_bang mb \n" +
            "join trang_thai tt on mb.id_trang_thai = tt.id_trang_thai\n" +
            "join loai_mat_bang lmb on mb.id_loai_mat_bang = lmb.id_loai_mat_bang\n" +
            "where lmb.ten_loai_mat_bang like ?;";

    @Override
    public List<DTOMatBang> selectAllMatBang() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DTOMatBang> dtoMatBangList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_DTO_MAT_BANG);
                resultSet = statement.executeQuery();
                DTOMatBang dtoMatBang = null;
                while (resultSet.next()) {
                    dtoMatBang = new DTOMatBang();
                    dtoMatBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                    dtoMatBang.setTen_trang_thai(resultSet.getString("ten_trang_thai"));
                    dtoMatBang.setDien_tich(resultSet.getDouble("dien_tich"));
                    dtoMatBang.setTang(resultSet.getInt("tang"));
                    dtoMatBang.setTen_loai_mat_bang(resultSet.getString("ten_loai_mat_bang"));
                    dtoMatBang.setGia_tien(resultSet.getInt("gia_tien"));
                    dtoMatBang.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                    dtoMatBang.setNgay_ket_thuc(resultSet.getString("ngay_ket_thuc"));
                    dtoMatBangList.add(dtoMatBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return dtoMatBangList;
    }

    @Override
    public List<TrangThai> selectAllTrangThai() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<TrangThai> trangThaiList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_TRANG_THAI);
                resultSet = statement.executeQuery();
                TrangThai trangThai = null;
                while (resultSet.next()) {
                    trangThai = new TrangThai();
                    trangThai.setId_trang_thai(resultSet.getInt("id_trang_thai"));
                    trangThai.setTen_trang_thai(resultSet.getString("ten_trang_thai"));
                    trangThaiList.add(trangThai);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return trangThaiList;
    }

    @Override
    public List<LoaiMatBang> selectAllLoaiMatBang() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_LOAI_MAT_BANG);
                resultSet = statement.executeQuery();
                LoaiMatBang loaiMatBang = null;
                while (resultSet.next()) {
                    loaiMatBang = new LoaiMatBang();
                    loaiMatBang.setId_loai_mat_bang(resultSet.getInt("id_loai_mat_bang"));
                    loaiMatBang.setTen_loai_mat_bang(resultSet.getString("ten_loai_mat_bang"));
                    loaiMatBangList.add(loaiMatBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return loaiMatBangList;
    }

    @Override
    public void insertMatBang(MatBang matBang) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_MAT_BANG);
                statement.setString(1, matBang.getMa_mat_bang());
                statement.setInt(2, matBang.getId_trang_thai());
                statement.setDouble(3, matBang.getDien_tich());
                statement.setInt(4, matBang.getTang());
                statement.setDouble(5, matBang.getId_loai_mat_bang());
                statement.setDouble(6, matBang.getGia_tien());
                statement.setString(7, matBang.getNgay_bat_dau());
                statement.setString(8, matBang.getNgay_ket_thuc());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
    }

    @Override
    public boolean deleteCustomer(String ma_mat_bang) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_MAT_BANG);
                statement.setString(1, ma_mat_bang);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

    @Override
    public List<DTOMatBang> searchByTang(int tang) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DTOMatBang> dtoMatBangList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_MAT_BANG_BY_TANG);
                statement.setInt(1, tang);
                resultSet = statement.executeQuery();
                DTOMatBang dtoMatBang = null;
                while (resultSet.next()) {
                    dtoMatBang = new DTOMatBang();
                    dtoMatBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                    dtoMatBang.setTen_trang_thai(resultSet.getString("ten_trang_thai"));
                    dtoMatBang.setDien_tich(resultSet.getDouble("dien_tich"));
                    dtoMatBang.setTang(resultSet.getInt("tang"));
                    dtoMatBang.setTen_loai_mat_bang(resultSet.getString("ten_loai_mat_bang"));
                    dtoMatBang.setGia_tien(resultSet.getInt("gia_tien"));
                    dtoMatBang.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                    dtoMatBang.setNgay_ket_thuc(resultSet.getString("ngay_ket_thuc"));
                    dtoMatBangList.add(dtoMatBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return dtoMatBangList;
    }

    @Override
    public List<DTOMatBang> searchByGia(double gia_tien) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DTOMatBang> dtoMatBangList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_MAT_BANG_BY_GIA);
                statement.setDouble(1, gia_tien);
                resultSet = statement.executeQuery();
                DTOMatBang dtoMatBang = null;
                while (resultSet.next()) {
                    dtoMatBang = new DTOMatBang();
                    dtoMatBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                    dtoMatBang.setTen_trang_thai(resultSet.getString("ten_trang_thai"));
                    dtoMatBang.setDien_tich(resultSet.getDouble("dien_tich"));
                    dtoMatBang.setTang(resultSet.getInt("tang"));
                    dtoMatBang.setTen_loai_mat_bang(resultSet.getString("ten_loai_mat_bang"));
                    dtoMatBang.setGia_tien(resultSet.getInt("gia_tien"));
                    dtoMatBang.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                    dtoMatBang.setNgay_ket_thuc(resultSet.getString("ngay_ket_thuc"));
                    dtoMatBangList.add(dtoMatBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return dtoMatBangList;
    }

    @Override
    public List<DTOMatBang> searchByLoaiMatBang(String ten_loai_mat_bang) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DTOMatBang> dtoMatBangList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_MAT_BANG_BY_LOAI_MAT_BANG);
                statement.setString(1, "%"+ten_loai_mat_bang+"%");
                resultSet = statement.executeQuery();
                DTOMatBang dtoMatBang = null;
                while (resultSet.next()) {
                    dtoMatBang = new DTOMatBang();
                    dtoMatBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                    dtoMatBang.setTen_trang_thai(resultSet.getString("ten_trang_thai"));
                    dtoMatBang.setDien_tich(resultSet.getDouble("dien_tich"));
                    dtoMatBang.setTang(resultSet.getInt("tang"));
                    dtoMatBang.setTen_loai_mat_bang(resultSet.getString("ten_loai_mat_bang"));
                    dtoMatBang.setGia_tien(resultSet.getInt("gia_tien"));
                    dtoMatBang.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                    dtoMatBang.setNgay_ket_thuc(resultSet.getString("ngay_ket_thuc"));
                    dtoMatBangList.add(dtoMatBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return dtoMatBangList;
    }
}

