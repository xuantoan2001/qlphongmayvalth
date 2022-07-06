package Models;

public class GiaoVien {

    public String maGV,tenGV,namSinh,gioiTinh,email,matkhau;
    public int maQuyen,trangThai;
    
    
    public GiaoVien() {
    }

    public GiaoVien(String maGV, String tenGV, String namSinh, String gioiTinh, String email, String matkhau, int maQuyen, int trangThai) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.matkhau = matkhau;
        this.maQuyen = maQuyen;
        this.trangThai = trangThai;
    }
    

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GiaoVien{" + "maGV=" + maGV + ", tenGV=" + tenGV + ", namSinh=" + namSinh + ", gioiTinh=" + gioiTinh + ", email=" + email + ", matkhau=" + matkhau + ", maQuyen=" + maQuyen + ", trangThai=" + trangThai + '}';
    }

    
  
    

}
