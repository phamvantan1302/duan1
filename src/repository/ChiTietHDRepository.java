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
import viewmodel.ChiTietHoaDon;
import viewmodel.HoaDon;
import viewmodel.NhanVienModel;
import viewmodel.SanPhamCT_ViewModel;

/**
 *
 * @author ADMIN
 */
public class ChiTietHDRepository {

    public List<ChiTietHoaDon> getAll() {
        String query = "SELECT [MAHDBH]\n"
                + "      ,[MASP]\n"
                + "      ,[SOLUONG]\n"
                + "      ,[DONGIA]\n"
                + "  FROM [dbo].[CT_HOADONBANHANG]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietHoaDon> listhd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//              
                ChiTietHoaDon tl = new ChiTietHoaDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listhd.add(tl);
            }
            return listhd;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ChiTietHoaDon cthd) {
        String query = "INSERT INTO [dbo].[CT_HOADONBANHANG]\n"
                + "           ([MAHDBH]\n"
                + "           ,[MASP]\n"
                + "           ,[SOLUONG]\n"
                + "           ,[DONGIA])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, cthd.getHd());
            ps.setObject(2, cthd.getMasp());
            ps.setObject(3, cthd.getSoLuong());
            ps.setObject(4, cthd.getDonGia());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addSP(ChiTietHoaDon nv, String ma) {
        String query = "UPDATE [dbo].[CT_HOADONBANHANG]\n"
                + "   SET [MASP] = ?\n"
                + "      ,[SOLUONG] = ?\n"
                + "      ,[DONGIA] = ?\n"
                + " WHERE [MAHDBH] = ?";
        int check = 0;
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMasp());
            ps.setObject(2, nv.getSoLuong());
            ps.setObject(3, nv.getDonGia());
            ps.setObject(8, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updatesl(SanPhamCT_ViewModel nv, String ma) {
        String query = "UPDATE [dbo].[CHITIETSANPHAM]\n"
                + "   SET [SoLuong] = ?\n"
                + " WHERE [MaSanPham] = ?";
        int check = 0;
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getSoLuong());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public SanPhamCT getOne(String ma) {
        String query = "SELECT [MAHDBH]\n"
                + "  FROM [dbo].[HOADONBANHANG] WHERE [MAHDBH]= ?";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SanPhamCT();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
