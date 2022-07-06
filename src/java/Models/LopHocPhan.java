/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class LopHocPhan {
    String maLHP,tenLHP,maGV;

    public LopHocPhan(String maLHP, String tenLHP, String maGV) {
        this.maLHP = maLHP;
        this.tenLHP = tenLHP;
        this.maGV = maGV;
    }

    public LopHocPhan() {
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }
    
}
