/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon {

    private String hd;
    private String sp;
    private int donGia;
    private int soLuong;
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String hd, String sp, int soLuong, int donGia) {
        this.hd = hd;
        this.sp = sp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietHoaDon(String sp, int soLuong, int donGia) {
        this.sp = sp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietHoaDon(String hd) {
        this.hd = hd;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getMasp() {
        return sp;
    }

    public void setMasp(String masp) {
        this.sp = masp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Object[] toDataRow() {
        return new Object[]{hd, sp, soLuong, donGia};
    }
}
