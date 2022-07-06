/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.PhieuYeuCauPhanMem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class PhieuYeuCauPhanMemDAO {

    private static Database db = new Database();
    private static String table = "phieuyeucaupm";
    private static String nameID = "maPhieuYC";

    public PhieuYeuCauPhanMemDAO() {
    }

    public PhieuYeuCauPhanMem select(String id) {
        PhieuYeuCauPhanMem phieuYeuCauPhanMem = null;
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + " WHERE " + nameID + " ='" + id + "'");
            while (rs.next()) {
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String maGV = rs.getObject("maGV").toString();
                String maPhongMay = rs.getObject("maPhongMay").toString();
                String ngayGui = rs.getObject("ngayGui").toString();
                String ghiChu = rs.getObject("ghiChu").toString();
                phieuYeuCauPhanMem = new PhieuYeuCauPhanMem(maPhieuYC, ngayGui, maGV, maPhongMay, ghiChu);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return phieuYeuCauPhanMem;
    }

    public List< PhieuYeuCauPhanMem> selectAll() {

        List<PhieuYeuCauPhanMem> phieuYeuCauPhanMems = new ArrayList<PhieuYeuCauPhanMem>();
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + " ORDER BY " + nameID + " DESC");
            while (rs.next()) {
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String maGV = rs.getObject("maGV").toString();
                String maPhongMay = rs.getObject("maPhongMay").toString();
                String ngayGui = rs.getObject("ngayGui").toString();
                String ghiChu = rs.getObject("ghiChu").toString();
                phieuYeuCauPhanMems.add(new PhieuYeuCauPhanMem(maPhieuYC, ngayGui, maGV, maPhongMay, ghiChu));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return phieuYeuCauPhanMems;
    }

    public boolean insertDB(PhieuYeuCauPhanMem phieuYeuCauPhanMem) throws SQLException {
        boolean rowInsert = true;
        try {
            String query = "INSERT INTO " + table + "(maGV,maPhongMay,ngayGui,ghiChu)"
                    + " VALUES('"
                    + phieuYeuCauPhanMem.maGV + "','"
                    + phieuYeuCauPhanMem.maPhongMay + "','"
                    + phieuYeuCauPhanMem.ngayGui + "','"
                    + phieuYeuCauPhanMem.ghiChu + "')";
            rowInsert = db.update(query);

            System.out.println(query);

        } catch (Exception e) {
            System.err.print(e);
        }
        return rowInsert;
    }

    public boolean updateDB(PhieuYeuCauPhanMem phieuYeuCauPhanMem) throws SQLException {
        boolean rowUpdated = true;
        try {
            String query = "UPDATE " + table
                    + " SET maGV= '" + phieuYeuCauPhanMem.maGV
                    + "',maPhongMay= '" + phieuYeuCauPhanMem.maPhongMay
                    + "',ngayGui= '" + phieuYeuCauPhanMem.ngayGui
                    + "',ghichu = '" + phieuYeuCauPhanMem.ghiChu + "'"
                    + " WHERE " + nameID + " ='" + phieuYeuCauPhanMem.maPhieuYC+"'";
            System.out.println(query);
            
            rowUpdated = db.update(query);
        } catch (Exception e) {
            rowUpdated = false;
            System.err.print(e);
        }
        return rowUpdated;
    }

    public static void deleteDB(String id) throws SQLException {
        try {
            db.update("DELETE FROM "+ table+" WHERE maPhieuYC='"+id+"'");
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public List< PhieuYeuCauPhanMem> selectAllByGV(String id) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateNowConv = null;
        
        List<PhieuYeuCauPhanMem> phieuYeuCauPhanMems = new ArrayList<PhieuYeuCauPhanMem>();
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + " WHERE maGV ='" + id + "' ORDER BY " + nameID + " DESC");
            while (rs.next()) {
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String maGV = rs.getObject("maGV").toString();
                String maPhongMay = rs.getObject("maPhongMay").toString();
                String ngay = rs.getObject("ngayGui").toString();
                dateNowConv = sdf2.format(sdf1.parse(ngay));
                String ngayGui = dateNowConv.toString();
                String ghiChu = rs.getObject("ghiChu").toString();
                phieuYeuCauPhanMems.add(new PhieuYeuCauPhanMem(maPhieuYC, ngayGui, maGV, maPhongMay, ghiChu));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return phieuYeuCauPhanMems;
    }

    public String selectID() {
        String maPhieuYC = null;
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + " ORDER BY  maphieuYC DESC  LIMIT 1");
            while (rs.next()) {
                maPhieuYC = rs.getObject("maPhieuYC").toString();
                System.err.print(maPhieuYC);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return maPhieuYC;
    }
    
    public int checkEdit(String id) {
        String idChiTiet = null;
        try {
            String q ="SELECT * FROM chitietyc WHERE maPhieuYC = '"+ id +"' AND trangThai = 1";
            System.out.println(q);
            ResultSet rs = db.select(q);
            while (rs.next()) {
                idChiTiet = rs.getObject("IDChiTiet").toString();
                
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        if(idChiTiet != null)
            return 1;
        else
            return 0;
    }
}
