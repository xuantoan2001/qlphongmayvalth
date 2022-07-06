/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.PhongMay;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class PhongMayDAO {

    private static Database db = new Database();
    private static String table = "phongmay";
    private static String nameID = "maphongmay";

    public List< PhongMay> selectAll() {

        List<PhongMay> phongmays = new ArrayList<PhongMay>();
        try {
            ResultSet rs = db.select("SELECT * FROM " + table);
            while (rs.next()) {

                String maPhongMay = rs.getObject("maPhongMay").toString();

                phongmays.add(new PhongMay(maPhongMay));

            }
        } catch (Exception e) {
            System.err.print(e);
        }
        
        return phongmays;
        

    }
}
