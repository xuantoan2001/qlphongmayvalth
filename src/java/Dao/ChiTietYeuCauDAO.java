/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.ChiTietYC;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class ChiTietYeuCauDAO {

    private static Database db = new Database();
    private static String table = "chitietyc";
    private static String nameID = "IDchiTiet";

    public ChiTietYeuCauDAO() {
    }

    public ChiTietYC select(String id) {
        ChiTietYC chitietyeucau = null;
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + " WHERE " + nameID + " ='" + id + "'");
            while (rs.next()) {
                String IDChiTiet = rs.getObject("IDChiTiet").toString();
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String tenPhanMem = rs.getObject("tenPhanMem").toString();
                String linkFile = rs.getObject("linkFile").toString();
                String maCanBo = rs.getObject("maCanBo").toString();
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());
                chitietyeucau = new ChiTietYC(IDChiTiet, maPhieuYC, tenPhanMem, linkFile, maCanBo, trangThai);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return chitietyeucau;
    }

    public List< ChiTietYC> selectAll() {

        List<ChiTietYC> chitietyeucaus = new ArrayList<ChiTietYC>();
        try {
            ResultSet rs = db.select("SELECT * FROM " + table + "ORDER BY " + nameID + " DESC");
            while (rs.next()) {
                String IDChiTiet = rs.getObject("IDChiTiet").toString();
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String tenPhanMem = rs.getObject("tenPhanMem").toString();
                String linkFile = rs.getObject("linkFile").toString();
                String maCanBo = rs.getObject("maCanBo").toString();
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());
                chitietyeucaus.add(new ChiTietYC(IDChiTiet, maPhieuYC, tenPhanMem, linkFile, maCanBo, trangThai));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return chitietyeucaus;
    }

    public boolean insertDB(ChiTietYC chitietyeucau) throws SQLException {
        boolean rowInsert = true;
        try {
            String query = "INSERT INTO " + table + "(maPhieuYC,tenPhanMem,linkFile,trangThai)"
                    + " VALUES('"
                    + chitietyeucau.maPhieuYC + "','"
                    + chitietyeucau.tenPhanMem + "','"
                    + chitietyeucau.linkFile + "','"
                    + chitietyeucau.trangThai + "')";
            System.out.println(query);
            rowInsert = db.update(query);
            

        } catch (Exception e) {
            System.err.print(e);
        }
        return rowInsert;
    }

    public boolean updateDB(ChiTietYC chitietyeucau) throws SQLException {
        boolean rowUpdated;
        try {
            String query = "UPDATE INTO " + table
                    + " SET maPhieuYC =' " + chitietyeucau.maPhieuYC
                    + "',tenPhanMem = '" + chitietyeucau.tenPhanMem
                    + "',maCanBo= '" + chitietyeucau.maCanBo
                    + "',trangThai ='" + chitietyeucau.trangThai + "'"
                    + " WHERE " + nameID + " ='" + chitietyeucau.IDChiTiet;

            db.update(query);
            rowUpdated = true;
        } catch (Exception e) {
            rowUpdated = false;
            System.err.print(e);
        }
        return rowUpdated;
    }

    public static void deleteDB(String id) throws SQLException {
        try {
            db.update("DELETE FROM " + table + " WHERE maPhieuYC='" + id + "'");
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public List< ChiTietYC> selectAllByMaPhieu(String id) {

        List<ChiTietYC> chitietyeucaus = new ArrayList<ChiTietYC>();
        try {
            String query = "SELECT * FROM " + table + " WHERE maPhieuYC = '"+ id +"'";
            ResultSet rs = db.select(query);
            System.out.println(query);
            while (rs.next()) {
                String IDChiTiet = rs.getObject("IDChiTiet").toString();
                String maPhieuYC = rs.getObject("maPhieuYC").toString();
                String tenPhanMem = rs.getObject("tenPhanMem").toString();
                String linkFile = rs.getObject("linkFile").toString();
                String maCanBo = null;
                int trangThai = Integer.parseInt(rs.getObject("trangThai").toString());
                chitietyeucaus.add(new ChiTietYC(IDChiTiet, maPhieuYC, tenPhanMem, linkFile, maCanBo, trangThai));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        System.out.println(chitietyeucaus.size());
        return chitietyeucaus;
    }
}
