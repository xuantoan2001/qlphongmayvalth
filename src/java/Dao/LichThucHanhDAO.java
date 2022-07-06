/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.GiaoVien;
import Models.LichThucHanh;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class LichThucHanhDAO {

    private static Database db = new Database();
    private static String table = "lichthuchanh";
    private static String nameID = "maLHP";

    public LichThucHanhDAO() {
    }

    public List<LichThucHanh> selectAllByGV(String id) {
        List<LichThucHanh> lichthuchanhs = new ArrayList<LichThucHanh>();
        try {
            String q = "SELECT * FROM lichthuchanh ,lophocphan "
                    + "WHERE  lichthuchanh.maLHP=lophocphan.maLHP "
                    + "and lophocphan.maGV = '" + id + "' ORDER BY lichthuchanh.thu ASC";
            System.out.println(q);
            ResultSet rs = db.select(q);
            while (rs.next()) {
                String maLHP = rs.getObject("maLHP").toString();
                String maPhongMay = rs.getObject("maPhongMay").toString();
                String ngayHieuLuc = "";
                int thu = Integer.parseInt(rs.getObject("thu").toString());
                int tietBatDau = Integer.parseInt(rs.getObject("tietBatDau").toString());
                int tietKetThuc = Integer.parseInt(rs.getObject("tietKetThuc").toString());

                lichthuchanhs.add(new LichThucHanh(maLHP, maPhongMay, ngayHieuLuc, thu, tietBatDau, tietKetThuc));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        System.out.println(lichthuchanhs.size());
        return lichthuchanhs;
    }

    public String selectMHBYLHP(String id) {
        String giaovien = null;
        try {
            String q = "SELECT tenLHP FROM lophocphan"
                    + " WHERE lophocphan.maLHP = '"+id+"'";
            System.out.println(q);
            ResultSet rs = db.select(q);
            while (rs.next()) {
                giaovien = rs.getObject("tenLHP").toString();
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return giaovien;
    }
}
