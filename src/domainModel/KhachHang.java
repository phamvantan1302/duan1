/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {

    private int id;
    private String ma;
    private String tenKH;
    private boolean gioiTinh;
    private Date date;
    private String soCMND;
    private String sdt;
    private String email;
    private String nguyenQuan;
    private String ngheNghiep;

    public KhachHang() {
    }

    public KhachHang(int id, String ma, String tenKH, boolean gioiTinh, Date date, String soCMND, String sdt, String email, String nguyenQuan, String ngheNghiep) {
        this.id = id;
        this.ma = ma;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.date = date;
        this.soCMND = soCMND;
        this.sdt = sdt;
        this.email = email;
        this.nguyenQuan = nguyenQuan;
        this.ngheNghiep = ngheNghiep;
    }

    public KhachHang(String tenKH, String email) {
        this.tenKH = tenKH;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

}
