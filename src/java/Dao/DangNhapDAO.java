/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.GiaoVien;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class DangNhapDAO {

    private static Database db = new Database();

    public static int kTraDangNhap(String email, String matKhau) {
        if (DangNhapGV(email, matKhau) != null) {
            return 1;//giao vien
        }
        if (DangNhapCB(email, matKhau) != null) {
            return 2;//can bo
        }
        if (DangNhapSV(email, matKhau) != null) {
            return 3;//sinh vien
        }
        return 0;//ko tìm thấy
    }

    public static GiaoVien DangNhapGV(String email, String matKhau) {
        DangNhapDAO taiKhoan = null;
        GiaoVien gv = null;
        try {
            ResultSet rs = db.select("SELECT * FROM giaovien WHERE email='" + email + "' AND matkhau='" + matKhau + "'");

            while (rs.next()) {
                String maGV = rs.getObject("maGV").toString();
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = rs.getObject("ngaySinh").toString();
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email_gv = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                gv = new GiaoVien(maGV, tenGV, namSinh, gioiTinh, email_gv, matkhau, maQuyen, trangThai);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return gv;
    }

    public static GiaoVien DangNhapSV(String email, String matKhau) {
        DangNhapDAO taiKhoan = null;
        GiaoVien gv = null;
        try {
            //String pw = md5Hash(matKhau);
            ResultSet rs = db.select("SELECT * FROM giaovien WHERE email='" + email + "' AND matkhau='" + matKhau + "'");
            System.out.println("SELECT * FROM giaovien WHERE email='" + email + "' AND matkhau='" + matKhau + "'");
            while (rs.next()) {
                String maGV = rs.getObject("maGV").toString();
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = rs.getObject("ngaySinh").toString();
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email_gv = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                gv = new GiaoVien(maGV, tenGV, namSinh, gioiTinh, email_gv, matkhau, maQuyen, trangThai);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return gv;
    }

    public static GiaoVien DangNhapCB(String email, String matKhau) {
        DangNhapDAO taiKhoan = null;
        GiaoVien gv = null;
        try {
            //String pw = md5Hash(matKhau);
            ResultSet rs = db.select("SELECT * FROM giaovien WHERE email='" + email + "' AND matkhau='" + matKhau + "'");
            System.out.println("SELECT * FROM giaovien WHERE email='" + email + "' AND matkhau='" + matKhau + "'");
            while (rs.next()) {
                String maGV = rs.getObject("maGV").toString();
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = rs.getObject("ngaySinh").toString();
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email_gv = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                gv = new GiaoVien(maGV, tenGV, namSinh, gioiTinh, email_gv, matkhau, maQuyen, trangThai);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return gv;
    }

    public static void themCookie(HttpServletResponse response, String id) {
        Cookie idCookie = new Cookie("idTaiKhoan", id);
        idCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(idCookie);
    }

    public static void xoaCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("idTaiKhoan") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

}
