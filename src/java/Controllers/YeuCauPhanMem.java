/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import static Controllers.TrangChu.checkLogin;
import Dao.ChiTietYeuCauDAO;
import Dao.GiaoVienDAO;
import Dao.PhieuYeuCauPhanMemDAO;
import Dao.PhongMayDAO;
import Models.ChiTietYC;
import Models.PhieuYeuCauPhanMem;
import Models.PhongMay;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "YeuCauPhanMem", urlPatterns = {"/YeuCauPhanMem/"})
public class YeuCauPhanMem extends HttpServlet {

    private PhieuYeuCauPhanMemDAO daoYCPM = new PhieuYeuCauPhanMemDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (checkLogin(request).equals("-1")) {
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
        } else {
            String action = request.getParameter("action");
            System.out.println(action);
            if (action == null) {
                action = "yeu-cau-phan-mem";
            }
            try {
                switch (action) {
                    case "dang-ky":
                        showNewForm(request, response);
                        break;
                    case "them":
                        insert(request, response);
                        break;
                    case "xoa":
                        delete(request, response);
                        break;
                    case "sua":
                        showEditForm(request, response);
                        break;
                    case "cap-nhat":
                        update(request, response);
                        break;
                    case "chi-tiet":
                        chitiet(request, response);
                        break;
                    default:
                        list(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateNow = (java.time.LocalDate.now()).toString();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateNowConv = null;
        try {
            dateNowConv = sdf2.format(sdf1.parse(dateNow));
        } catch (ParseException ex) {
            Logger.getLogger(YeuCauPhanMem.class.getName()).log(Level.SEVERE, null, ex);
        }

        PhongMayDAO daoPM = new PhongMayDAO();

        request.setAttribute("dateNow", dateNow);
        request.setAttribute("dateNowConv", dateNowConv);
        request.setAttribute("listPhongMay", daoPM.selectAll());
        request.setAttribute("page", "YeuCauPhanMem/them");
        request.getRequestDispatcher("/Pages/Center.jsp").forward(request, response);

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String maGV = request.getParameter("maGV");
        String maPhongMay = request.getParameter("maPhongMay");
        String ngayGui = request.getParameter("ngayGui");
        String ghiChu = request.getParameter("ghiChu");
        ghiChu = ghiChu != null ? ghiChu : " ";
        PhieuYeuCauPhanMem entity = new PhieuYeuCauPhanMem(ngayGui, maGV, maPhongMay, ghiChu);

        String[] tenPM = request.getParameterValues("tenPM");
        String[] linkCaiDat = request.getParameterValues("linkCaiDat");
        
        boolean mess = daoYCPM.insertDB(entity);
        String alert = null;
        if (mess == true) {
            String id = daoYCPM.selectID();
            ChiTietYeuCauDAO ctycDAO = new ChiTietYeuCauDAO();
            for (int i = 0; i <= tenPM.length - 1; i++) {
                ChiTietYC ct = new ChiTietYC(id, tenPM[i], linkCaiDat[i], 0);
                ctycDAO.insertDB(ct);
            }
        } else {
            alert = "Gửi yêu cầu thất bại";
        }
        response.sendRedirect("yeu-cau-phan-mem");
        System.out.println(alert);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("maPhieuYC").toString();
        ChiTietYeuCauDAO.deleteDB(id);
        PhieuYeuCauPhanMemDAO.deleteDB(id);
        response.sendRedirect(request.getContextPath() + "/yeu-cau-phan-mem");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("maPhieuYC");
        String dateNow = daoYCPM.select(id).ngayGui;
        ChiTietYeuCauDAO ctycDao = new ChiTietYeuCauDAO();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateNowConv = null;
        try {
            dateNowConv = sdf2.format(sdf1.parse(dateNow));
        } catch (ParseException ex) {
            Logger.getLogger(YeuCauPhanMem.class.getName()).log(Level.SEVERE, null, ex);
        }

        PhongMayDAO daoPM = new PhongMayDAO();

        request.setAttribute("dateNow", dateNow);
        request.setAttribute("dateNowConv", dateNowConv);
        request.setAttribute("listPhongMay", daoPM.selectAll());
        request.setAttribute("phieuyeucau", daoYCPM.select(id));
        request.setAttribute("listYC", ctycDao.selectAllByMaPhieu(id));
        request.setAttribute("page", "YeuCauPhanMem/sua");
        request.getRequestDispatcher("/Pages/Center.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String maPhieu = request.getParameter("maPhieuYC");
        String maGV = request.getParameter("maGV");
        String maPhongMay = request.getParameter("maPhongMay");
        String ngayGui = request.getParameter("ngayGui");
        String ghiChu = request.getParameter("ghiChu");
        ghiChu = ghiChu != null ? ghiChu : " ";
        PhieuYeuCauPhanMem entity = new PhieuYeuCauPhanMem(maPhieu, ngayGui, maGV, maPhongMay, ghiChu);

        String[] tenPM = request.getParameterValues("tenPM");
        String[] linkCaiDat = request.getParameterValues("linkCaiDat");

        boolean mess = daoYCPM.updateDB(entity);
        String alert = null;
        if (mess == true) {
            ChiTietYeuCauDAO ctycDAO = new ChiTietYeuCauDAO();
            ctycDAO.deleteDB(maPhieu);
            for (int i = 0; i < tenPM.length - 1; i++) {
                ChiTietYC ct = new ChiTietYC(daoYCPM.selectID(), tenPM[i], linkCaiDat[i], 0);
                ctycDAO.insertDB(ct);
            }
        } else {

           alert =  "Gửi yêu cầu thất bại";
        }
        response.sendRedirect("yeu-cau-phan-mem");
        System.out.println(alert);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maGV = (String) request.getSession().getAttribute("idlogin");
        request.setAttribute("page", "YeuCauPhanMem/home");
        request.setAttribute("data", daoYCPM.selectAllByGV(maGV));
        request.getRequestDispatcher("/Pages/Center.jsp").forward(request, response);
    }

    private void chitiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("maPhieuYC");
        String dateNow = daoYCPM.select(id).ngayGui;
        ChiTietYeuCauDAO ctycDao = new ChiTietYeuCauDAO();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateNowConv = null;
        try {
            dateNowConv = sdf2.format(sdf1.parse(dateNow));
        } catch (ParseException ex) {
            Logger.getLogger(YeuCauPhanMem.class.getName()).log(Level.SEVERE, null, ex);
        }

        PhongMayDAO daoPM = new PhongMayDAO();
        request.setAttribute("dateNowConv", dateNowConv);
        request.setAttribute("phieuyeucau", daoYCPM.select(id));
        request.setAttribute("listYC", ctycDao.selectAllByMaPhieu(id));
        request.setAttribute("page", "YeuCauPhanMem/chitiet");
        request.getRequestDispatcher("/Pages/Center.jsp").forward(request, response);
    }

}
