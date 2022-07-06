/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class TaiKhoan {
    String IDTK,tenTK;
    int maQuyen;

    public TaiKhoan(String IDTK, String tenTK, int maQuyen) {
        this.IDTK = IDTK;
        this.tenTK = tenTK;
        this.maQuyen = maQuyen;
    }

    public String getIDTK() {
        return IDTK;
    }

    public void setIDTK(String IDTK) {
        this.IDTK = IDTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    
           
}
