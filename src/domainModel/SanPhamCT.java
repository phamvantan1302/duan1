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
public class SanPhamCT {

    private String MaSP;
    private String TenMu;
    private String MaHang;
    private String MaChatLieu;
    private String MaMauSac;
    private String Size;
    private String MaKieuMu;
    private String MaKinh;
    private double GiaBan;
    private int SoLuong;
    private String Anh;

    public SanPhamCT() {
    }

    public SanPhamCT(String MaSP, String TenMu, String MaHang, String MaChatLieu, String MaMauSac, String Size, String MaKieuMu, String MaKinh, double GiaBan, int SoLuong, String Anh) {
        this.MaSP = MaSP;
        this.TenMu = TenMu;
        this.MaHang = MaHang;
        this.MaChatLieu = MaChatLieu;
        this.MaMauSac = MaMauSac;
        this.Size = Size;
        this.MaKieuMu = MaKieuMu;
        this.MaKinh = MaKinh;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.Anh = Anh;
    }

    public SanPhamCT(String MaSP, String TenMu, double GiaBan, int SoLuong) {
        this.MaSP = MaSP;
        this.TenMu = TenMu;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    public SanPhamCT(String TenMu, double GiaBan) {
        this.TenMu = TenMu;
        this.GiaBan = GiaBan;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenMu() {
        return TenMu;
    }

    public void setTenMu(String TenMu) {
        this.TenMu = TenMu;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(String MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getMaKieuMu() {
        return MaKieuMu;
    }

    public void setMaKieuMu(String MaKieuMu) {
        this.MaKieuMu = MaKieuMu;
    }

    public String getMaKinh() {
        return MaKinh;
    }

    public void setMaKinh(String MaKinh) {
        this.MaKinh = MaKinh;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public Object[] toDataRow() {
        return new Object[]{MaSP, TenMu, GiaBan, SoLuong};
    }

}
