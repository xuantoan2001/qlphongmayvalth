/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class PhongMay {
    public String maPhongMay,maCanBo,tinhTrang;
    public int slQuat,slMayChieu,slDieuHoa;

    public PhongMay() {
    }
    
    public PhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }
    
    public PhongMay(String maPhongMay, String maCanBo, String tinhTrang, int slQuat, int slMayChieu, int slDieuHoa) {
        this.maPhongMay = maPhongMay;
        this.maCanBo = maCanBo;
        this.tinhTrang = tinhTrang;
        this.slQuat = slQuat;
        this.slMayChieu = slMayChieu;
        this.slDieuHoa = slDieuHoa;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSlQuat() {
        return slQuat;
    }

    public void setSlQuat(int slQuat) {
        this.slQuat = slQuat;
    }

    public int getSlMayChieu() {
        return slMayChieu;
    }

    public void setSlMayChieu(int slMayChieu) {
        this.slMayChieu = slMayChieu;
    }

    public int getSlDieuHoa() {
        return slDieuHoa;
    }

    public void setSlDieuHoa(int slDieuHoa) {
        this.slDieuHoa = slDieuHoa;
    }
    
    
}
