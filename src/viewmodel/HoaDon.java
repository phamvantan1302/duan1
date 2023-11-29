package viewmodel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Phong
 */
public class HoaDon {

    private String maHoaDon;
    private KhachHang kh;
    private String nv;
    private String ngayLap;
    private int tongTien;
    private int tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, KhachHang kh, String nv, String ngayLap, int tongTien, int tinhTrang) {
        this.maHoaDon = maHoaDon;
        this.kh = kh;
        this.nv = nv;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHoaDon, String nv, String ngayLap, int tongTien, int tinhTrang) {
        this.maHoaDon = maHoaDon;
        this.nv = nv;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHoaDon, String ngayLap, int tongTien, int tinhTrang) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(String maHoaDon, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.tinhTrang = trangThai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int trangThai) {
        this.tinhTrang = tinhTrang;
    }

    public Object[] toDataRow() {
        return new Object[]{maHoaDon, ngayLap, tinhTrang == 0 ? "Chờ thanh toán" : "Đã thanh toán"};
    }

    public Object[] toDataRoww() {
        return new Object[]{maHoaDon, ngayLap, tongTien, tinhTrang == 0 ? "Chờ thanh toán" : "Đã thanh toán"};
    }
}
