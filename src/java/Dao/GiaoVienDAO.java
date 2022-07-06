/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.GiaoVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class GiaoVienDAO {
    private static Database db = new Database();
    
    public static List<GiaoVien> dsGiaoVien() {
        List<GiaoVien> giaoviens = new ArrayList<GiaoVien>();
        try {
            ResultSet rs = db.select("SELECT * FROM sinhvien ORDER BY maGV DESC");
            while (rs.next()) {
                String maGV = rs.getObject("maGV").toString();
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = rs.getObject("namSinh").toString();
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                giaoviens.add(new GiaoVien( maGV,  tenGV,namSinh, gioiTinh, email, matkhau, maQuyen, trangThai));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return giaoviens;
    }

    public static void themGiaoVien(String maGV, String hoTen, String lop, String queQuan) {
        try {
            db.update("INSERT INTO sinhvien"
                    + " VALUES('" + maGV + "','" + hoTen + "','" + lop + "','" + queQuan + "', default)"
            );
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public static void suaGiaoVien(String maGV, String hoTen, String lop, String queQuan) {
        try {
            db.update("UPDATE sinhvien"
                    + " SET HoTen='" + hoTen + "',Lop='" + lop + "',QueQuan='" + queQuan + "'"
                    + " WHERE MaSV='" + maGV + "'"
            );
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public static void xoaGiaoVien(String maGV) {
        try {
            db.update("DELETE FROM sinhvien WHERE MaSV='"+maGV+"'");
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public static GiaoVien getGiaoVien(String maGV) {
        GiaoVien giaoVien = null;
        try {
            String q = "SELECT * FROM giaovien WHERE maGV='"+maGV+"'";
            System.out.println(q);
            ResultSet rs = db.select(q);
            while (rs.next()) {
                
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = "";
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                giaoVien = new GiaoVien( maGV,  tenGV,namSinh, gioiTinh, email, matkhau, maQuyen, trangThai);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return giaoVien;
    }
    
    public static List<GiaoVien> timKiemSV(String q) {
        List<GiaoVien> giaoViens = new ArrayList<GiaoVien>();
        try {
            ResultSet rs = db.select("SELECT * FROM sinhvien "
                    + " WHERE MaSV LIKE '%"+q+"%' OR HoTen LIKE '%"+q+"%' OR Lop LIKE '%"+q+"%' OR QueQuan LIKE '%"+q+"%'"
                    + " ORDER BY ThoiGian DESC");
            while (rs.next()) {
                String maGV = rs.getObject("maGV").toString();
                String tenGV = rs.getObject("tenGV").toString();
                String namSinh = rs.getObject("namSinh").toString();
                String gioiTinh = rs.getObject("gioiTinh").toString();
                String email = rs.getObject("email").toString();
                String matkhau = rs.getObject("matkhau").toString();
                int maQuyen = Integer.parseInt(rs.getObject("maQuyen").toString());
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());

                giaoViens.add(new GiaoVien( maGV,  tenGV,namSinh, gioiTinh, email, matkhau, maQuyen, trangThai));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return giaoViens;
    }
    public static void main(String[] srtr) {
        
    }
}
