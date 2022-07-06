/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class ChiTietYC {
    public String IDChiTiet,maPhieuYC,tenPhanMem,linkFile,maCanBo;
    public int trangThai;

    public ChiTietYC() {
    }

    public ChiTietYC(String IDChiTiet, String maPhieuYC, String tenPhanMem, String linkFile, String maCanBo, int trangThai) {
        this.IDChiTiet = IDChiTiet;
        this.maPhieuYC = maPhieuYC;
        this.tenPhanMem = tenPhanMem;
        this.linkFile = linkFile;
        this.maCanBo = maCanBo;
        this.trangThai = trangThai;
    }

    public ChiTietYC(String maPhieuYC, String tenPhanMem, String linkFile, int trangThai) {
        this.maPhieuYC = maPhieuYC;
        this.tenPhanMem = tenPhanMem;
        this.linkFile = linkFile;
        this.trangThai = trangThai;
    }

    public ChiTietYC(String maPhieuYC, String tenPhanMem, String linkFile, String maCanBo, int trangThai) {
        this.maPhieuYC = maPhieuYC;
        this.tenPhanMem = tenPhanMem;
        this.linkFile = linkFile;
        this.maCanBo = maCanBo;
        this.trangThai = trangThai;
    }

    public String getIDChiTiet() {
        return IDChiTiet;
    }

    public void setIDChiTiet(String IDChiTiet) {
        this.IDChiTiet = IDChiTiet;
    }

    public String getMaPhieuYC() {
        return maPhieuYC;
    }

    public void setMaPhieuYC(String maPhieuYC) {
        this.maPhieuYC = maPhieuYC;
    }

    public String getTenPhanMem() {
        return tenPhanMem;
    }

    public void setTenPhanMem(String tenPhanMem) {
        this.tenPhanMem = tenPhanMem;
    }

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ChiTietYC{" + "IDChiTiet=" + IDChiTiet + ", maPhieuYC=" + maPhieuYC + ", tenPhanMem=" + tenPhanMem + ", linkFile=" + linkFile + ", maCanBo=" + maCanBo + ", trangThai=" + trangThai + '}';
    }
    
}
