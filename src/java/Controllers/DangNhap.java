/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import static Controllers.TrangChu.checkLogin;
import Dao.DangNhapDAO;
import Dao.GiaoVienDAO;
import Models.GiaoVien;
import Models.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "DangNhap", urlPatterns = {"/DangNhap"})
public class DangNhap extends HttpServlet {

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

        if (checkLogin(request).equals("-1")) {
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("/Pages/DangNhap.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
        }
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

        processRequest(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String matKhau = request.getParameter("password").toString();
        String email = request.getParameter("email").toString();
        int quyentruycap = DangNhapDAO.kTraDangNhap(email, matKhau);
        
        HttpSession session = request.getSession();
        if (quyentruycap != 0) {
            switch (quyentruycap) {
                case 1:
                    GiaoVien gv = DangNhapDAO.DangNhapGV(email, matKhau);
                    DangNhapDAO.themCookie(response, gv.maGV);
                    session.setAttribute("idlogin", gv.maGV);
                    session.setAttribute("taikhoan", new TaiKhoan(gv.maGV, gv.tenGV, gv.maQuyen));
                    request.setAttribute("Message", "Đăng nhập thành công");
                    processRequest(request, response);
                    break;
                case 2:
                    //canbo
                    break;
                case 3:
                    //sinh vien
                    break;
            }
        } else {

            request.setAttribute("Message", "Tài khoản hoặc mật khẩu không đúng");
            processRequest(request, response);
        }
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

}
