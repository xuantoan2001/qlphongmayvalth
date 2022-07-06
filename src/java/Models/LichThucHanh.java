/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class LichThucHanh {
    String maLHP,maPhongMay,ngayHieuLuc;
    int thu,tietBatDau,tietKetThuc;

    public LichThucHanh() {
    }

    public LichThucHanh(String maLHP, String maPhongMay, String ngayHieuLuc, int thu, int tietBatDau, int tietKetThuc) {
        this.maLHP = maLHP;
        this.maPhongMay = maPhongMay;
        this.ngayHieuLuc = ngayHieuLuc;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.tietKetThuc = tietKetThuc;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getNgayHieuLuc() {
        return ngayHieuLuc;
    }

    public void setNgayHieuLuc(String ngayHieuLuc) {
        this.ngayHieuLuc = ngayHieuLuc;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(int tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public int getTietKetThuc() {
        return tietKetThuc;
    }

    public void setTietKetThuc(int tietKetThuc) {
        this.tietKetThuc = tietKetThuc;
    }
    
}
