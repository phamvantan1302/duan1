/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainModel.SanPhamCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import viewmodel.HoaDon;
import viewmodel.KhachHang;
import viewmodel.NhanVienModel;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "SELECT [MAHDBH]\n"
                + "      ,[TINHTRANG]\n"
                + "  FROM [dbo].[HOADONBANHANG]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listhd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon tl = new HoaDon(rs.getString(1), rs.getInt(2));
                listhd.add(tl);
            }
            return listhd;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllhd() {
        String query = "SELECT [MAHDBH]\n"
                + "      ,[NGAYLAPHD]\n"
                + "      ,[TONGTIEN]\n"
                + "      ,[TINHTRANG]\n"
                + "  FROM [dbo].[HOADONBANHANG]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listhd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon tl = new HoaDon(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                listhd.add(tl);
            }
            return listhd;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhachHang> getAllkh() {
        String query = "SELECT [MAKH]\n"
                + "      ,[TENKH]\n"
                + "      ,[NGAYSINH]\n"
                + "      ,[SODT]\n"
                + "  FROM [dbo].[KHACHHANG]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<KhachHang> listkh = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang tl = new KhachHang(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4));
                listkh.add(tl);
            }
            return listkh;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPhamCT_ViewModel> getAllsp() {
        String query = "SELECT [MaSanPham]\n"
                + "      ,[TenMU]\n"
                + "      ,[GiaBan]\n"
                + "      ,[SoLuong]\n"
                + "  FROM [dbo].[CHITIETSANPHAM]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamCT_ViewModel> listkh = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT_ViewModel tl = new SanPhamCT_ViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listkh.add(tl);
            }
            return listkh;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDon hd) {
        String query = "INSERT INTO [dbo].[HOADONBANHANG]\n"
                + "           ([MAHDBH]\n"
                + "           ,[MANV]\n"
                + "           ,[NGAYLAPHD]\n"
                + "           ,[TONGTIEN]\n"
                + "           ,[TINHTRANG])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, hd.getMaHoaDon());
            ps.setObject(2, hd.getNv());
            ps.setObject(3, hd.getNgayLap());
            ps.setObject(4, hd.getTongTien());
            ps.setObject(5, hd.getTinhTrang());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[HOADONBANHANG]\n"
                + "      WHERE [MAHDBH] = ?";
        int check = 0;
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
