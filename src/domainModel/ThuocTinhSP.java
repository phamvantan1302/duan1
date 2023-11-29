/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModel;

/**
 *
 * @author asus
 */
public class ThuocTinhSP {
    private String MaThuocTinh;
    private String TenThuocTinh;
    private int TrangThai;
    public ThuocTinhSP() {
    }

    public ThuocTinhSP(String MaThuocTinh, String TenThuocTinh, int TrangThai) {
        this.MaThuocTinh = MaThuocTinh;
        this.TenThuocTinh = TenThuocTinh;
        this.TrangThai = TrangThai;
    }

    public String getMaThuocTinh() {
        return MaThuocTinh;
    }

    public void setMaThuocTinh(String MaThuocTinh) {
        this.MaThuocTinh = MaThuocTinh;
    }

    public String getTenThuocTinh() {
        return TenThuocTinh;
    }

    public void setTenThuocTinh(String TenThuocTinh) {
        this.TenThuocTinh = TenThuocTinh;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
}
