/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.*;
//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienModel {

    private String ma;
    private String ten;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String email;
    private String sdt;
    private String diaChi;
    private String matKhau;
    private boolean trangThai;

    public NhanVienModel() {
    }

    public NhanVienModel(String ma, String ten, boolean gioiTinh, Date ngaySinh, String email, String sdt, String diaChi, String matKhau, boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public NhanVienModel(String ma, String ten, boolean gioiTinh, Date ngaySinh, String email, String sdt, String diaChi, boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public NhanVienModel(String ma, String ten, String email, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "ma=" + ma + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email + ", sdt=" + sdt + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", trangThai=" + trangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, gioiTinh == true ? "Nam" : "Nữ", ngaySinh, email, sdt, diaChi, trangThai == true ? "Đang làm" : "Nghỉ"};
    }

}
