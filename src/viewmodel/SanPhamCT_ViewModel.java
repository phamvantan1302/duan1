/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author asus
 */
public class SanPhamCT_ViewModel {

    private String MaSP;
    private String TenMu;
    private String TenHang;
    private String TenChatLieu;
    private String TenMauSac;
    private String Size;
    private String TenKieuMu;
    private String TenKinh;
    private int GiaBan;
    private int SoLuong;
    private String Anh;

    public SanPhamCT_ViewModel() {
    }

    public SanPhamCT_ViewModel(String MaSP, String TenMu, String TenHang, String TenChatLieu, String TenMauSac, String Size, String TenKieuMu, String TenKinh, int GiaBan, int SoLuong, String Anh) {
        this.MaSP = MaSP;
        this.TenMu = TenMu;
        this.TenHang = TenHang;
        this.TenChatLieu = TenChatLieu;
        this.TenMauSac = TenMauSac;
        this.Size = Size;
        this.TenKieuMu = TenKieuMu;
        this.TenKinh = TenKinh;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.Anh = Anh;
    }

    public SanPhamCT_ViewModel(String MaSP, String TenMu, String Size, int GiaBan, int SoLuong) {
        this.MaSP = MaSP;
        this.TenMu = TenMu;
        this.Size = Size;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    public SanPhamCT_ViewModel(String MaSP, String TenMu, int GiaBan, int SoLuong) {
        this.MaSP = MaSP;
        this.TenMu = TenMu;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    public SanPhamCT_ViewModel(String TenMu, int GiaBan) {
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

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getTenKieuMu() {
        return TenKieuMu;
    }

    public void setTenKieuMu(String TenKieuMu) {
        this.TenKieuMu = TenKieuMu;
    }

    public String getTenKinh() {
        return TenKinh;
    }

    public void setTenKinh(String TenKinh) {
        this.TenKinh = TenKinh;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
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

    @Override
    public String toString() {
        return "SanPhamCT_ViewModel{" + "MaSP=" + MaSP + ", TenMu=" + TenMu + ", TenHang=" + TenHang + ", TenChatLieu=" + TenChatLieu + ", TenMauSac=" + TenMauSac + ", Size=" + Size + ", TenKieuMu=" + TenKieuMu + ", TenKinh=" + TenKinh + ", GiaBan=" + GiaBan + ", SoLuong=" + SoLuong + ", Anh=" + Anh + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{MaSP, TenMu, GiaBan, SoLuong};
    }
}
