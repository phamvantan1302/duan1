/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class KhachHang {

    private String ma;

    private String ten;

    private Date ngaySinh;

    private String sdt;

    private String diaChi;

    private String quocGia;

    private int gioiTinh;

    public KhachHang() {
    }

    @Override
    public String toString() {
        return "KhachHang{" + "ma=" + ma + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", quocGia=" + quocGia + ", gioiTinh=" + gioiTinh + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, ngaySinh, sdt};
    }

    public KhachHang(String ma, String ten, Date ngaySinh, String sdt, String diaChi, String quocGia, int gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.quocGia = quocGia;
        this.gioiTinh = gioiTinh;
    }

    public KhachHang(String ma, String ten, Date ngaySinh, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
    }

    public String getMa() {
        return ma;
    }

    public KhachHang(String ma, String ten, String sdt, String diaChi, int gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String htGioiTinh() {
        if (gioiTinh == 0) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
}
