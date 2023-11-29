/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import unility.JDBC_Helper;
import viewmodel.KhachHang;

/**
 *
 * @author Dell
 */
public class KhachHangRepository {

    public List<KhachHang> getALl() {
        List<KhachHang> listkh = new ArrayList<>();
        String sql = "SELECT [MAKH]\n"
                + "      ,[TENKH]\n"
                + "      ,[NGAYSINH]\n"
                + "      ,[SODT]\n"
                + "      ,[DIACHI]\n"
                + "      ,[QUOCGIA]\n"
                + "      ,[GIOITINH]\n"
                + "  FROM [dbo].[KHACHHANG]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                Date ngaySinh = rs.getDate("NGAYSINH");
                String sdt = rs.getString("SODT");
                String diaChi = rs.getString("DIACHI");
                String quocGia = rs.getString("QUOCGIA");
                int gioiTinh = rs.getInt("GIOITINH");
                KhachHang kh = new KhachHang(ma, tenkh, ngaySinh, sdt, diaChi, quocGia, gioiTinh);
                listkh.add(kh);

            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KHACHHANG]\n"
                + "           ([MAKH]\n"
                + "           ,[TENKH]\n"
                + "           ,[NGAYSINH]\n"
                + "           ,[SODT]\n"
                + "           ,[DIACHI]\n"
                + "           ,[QUOCGIA]\n"
                + "           ,[GIOITINH])\n"
                + "              VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = unility.SQLSeverConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getSdt());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, kh.getQuocGia());
            ps.setObject(7, kh.getGioiTinh());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[KHACHHANG]\n"
                + "      WHERE [MAKH] = ?";
        int check = 0;
        try (Connection con = unility.SQLSeverConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhachHang kh, String ma) {
        String query = "UPDATE [dbo].[KHACHHANG]\n"
                + "SET [TENKH] = ?\n"
                + "    ,[NGAYSINH] = ?\n"
                + "    ,[SODT] = ?\n"
                + "    ,[DIACHI] = ?\n"
                + "    ,[QUOCGIA] = ?\n"
                + "    ,[GIOITINH] = ?\n"
                + "WHERE [MAKH] = ?";
        int check = 0;
        try (Connection con = unility.SQLSeverConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getNgaySinh());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getQuocGia());
            ps.setObject(6, kh.getGioiTinh());
            ps.setObject(7, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        new KhachHangRepository().getALl().forEach(s -> System.out.println(s.toString()));
    }
}
