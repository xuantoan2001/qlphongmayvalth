/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class PhieuYeuCauPhanMem {
    public String maPhieuYC,ngayGui,maGV,maPhongMay,ghiChu;

    public PhieuYeuCauPhanMem(String maPhieuYC, String ngayGui, String maGV, String maPhongMay, String ghiChu) {
        this.maPhieuYC = maPhieuYC;
        this.ngayGui = ngayGui;
        this.maGV = maGV;
        this.maPhongMay = maPhongMay;
        this.ghiChu = ghiChu;
    }

    public PhieuYeuCauPhanMem() {
    }

    public PhieuYeuCauPhanMem(String ngayGui, String maGV, String maPhongMay, String ghiChu) {
        
        this.ngayGui = ngayGui;
        this.maGV = maGV;
        this.maPhongMay = maPhongMay;
        this.ghiChu = ghiChu;
    }

    

    public String getMaPhieuYC() {
        return maPhieuYC;
    }

    public void setMaPhieuYC(String maPhieuYC) {
        this.maPhieuYC = maPhieuYC;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    

    @Override
    public String toString() {
        return "PhieuYeuCauPhanMem{" + "maPhieuYC=" + maPhieuYC + ", ngayGui=" + ngayGui + ", maGV=" + maGV + ", maPhongMay=" + maPhongMay + ", ghiChu=" + ghiChu + '}';
    }
    
}
