package controller;

import bo.ExamBo;
import model.DTOMatBang;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExamServlet", urlPatterns = {"", "/Exam"})
public class ExamServlet extends HttpServlet {
    ExamBo examBo = new ExamBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createMatBang(request,response);
                break;
        }
    }

    private void createMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma_mat_bang = request.getParameter("ma_mat_bang");
        int id_trang_thai = Integer.parseInt(request.getParameter("id_trang_thai"));
        double dien_tich = Double.parseDouble(request.getParameter("dien_tich"));
        int tang = Integer.parseInt((request.getParameter("tang")));
        int id_loai_mat_bang = Integer.parseInt((request.getParameter("id_loai_mat_bang")));
        double gia_tien = Double.parseDouble((request.getParameter("gia_tien")));
        String ngay_bat_dau = request.getParameter("ngay_bat_dau");
        String ngay_ket_thuc = request.getParameter("ngay_ket_thuc");
        MatBang matBang = new MatBang(ma_mat_bang, id_trang_thai, dien_tich, tang, id_loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc);
        examBo.insertMatBang(matBang);
        request.setAttribute("message", "Bạn đã tạo thành công !!!");
        List<DTOMatBang> dtoMatBangList = examBo.selectAllMatBang();
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        List<LoaiMatBang> loaiMatBangList = examBo.selectAllLoaiMatBang();
        request.setAttribute("loaiMatBangList", loaiMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteMatBang(request,response);
                break;
            case "searchByLoaiMatBang":
                searchByLoaiMatBang(request,response);
                break;
            case "searchByGia":
                searchByGia(request,response);
                break;
            case "searchByTang":
                searchByTang(request,response);
                break;
            default:
                listMatBang(request,response);
                break;
        }
    }

    private void searchByTang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tang = Integer.parseInt(request.getParameter("tang"));
        List<DTOMatBang> dtoMatBangList = examBo.searchByTang(tang);
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double gia_tien = Double.parseDouble(request.getParameter("gia_tien"));
        List<DTOMatBang> dtoMatBangList = examBo.searchByGia(gia_tien);
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByLoaiMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten_loai_mat_bang = request.getParameter("ten_loai_mat_bang");
        List<DTOMatBang> dtoMatBangList = examBo.searchByLoaiMatBang(ten_loai_mat_bang);
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma_mat_bang = request.getParameter("ma_mat_bang");
        examBo.deleteCustomer(ma_mat_bang);
        List<DTOMatBang> dtoMatBangList = examBo.selectAllMatBang();
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DTOMatBang> dtoMatBangList = examBo.selectAllMatBang();
        request.setAttribute("dtoMatBangList", dtoMatBangList);
        List<TrangThai> trangThaiList = examBo.selectAllTrangThai();
        request.setAttribute("trangThaiList", trangThaiList);
        List<LoaiMatBang> loaiMatBangList = examBo.selectAllLoaiMatBang();
        request.setAttribute("loaiMatBangList", loaiMatBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/exam/list.jsp");
        dispatcher.forward(request, response);
    }
}
