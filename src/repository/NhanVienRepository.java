/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import unility.SQLSeverConnection;
import viewmodel.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {

    public List<NhanVienModel> getAll() {
        String query = "SELECT [MANV]\n"
                + "      ,[TENNV]\n"
                + "      ,[GIOITINH]\n"
                + "      ,[NGAYSINH]\n"
                + "      ,[EMAIL]\n"
                + "      ,[SODT]\n"
                + "      ,[DIACHI]\n"
                + "      ,[TRANGTHAI]\n"
                + "  FROM [dbo].[NHANVIEN]";
        try ( Connection con = SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NhanVienModel> listnv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel tl = new NhanVienModel(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
                listnv.add(tl);
            }
            return listnv;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhanVienModel nv) {
        String query = "INSERT INTO [dbo].[NHANVIEN]\n"
                + "           ([MANV]\n"
                + "           ,[TENNV]\n"
                + "           ,[GIOITINH]\n"
                + "           ,[NGAYSINH]\n"
                + "           ,[EMAIL]\n"
                + "           ,[SODT]\n"
                + "           ,[DIACHI]\n"
                + "           ,[MATKHAU]\n"
                + "           ,[TRANGTHAI])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.isGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getMatKhau());
            ps.setObject(9, nv.isTrangThai());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[NHANVIEN]\n"
                + "      WHERE [MANV] = ?";
        int check = 0;
        try ( Connection con = SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVienModel nv, String ma) {
        String query = "UPDATE [dbo].[NHANVIEN]\n"
                + "   SET [TENNV] = ?\n"
                + "      ,[GIOITINH] = ?\n"
                + "      ,[NGAYSINH] = ?\n"
                + "      ,[EMAIL] = ?\n"
                + "      ,[SODT] = ?\n"
                + "      ,[DIACHI] = ?\n"
                + "      ,[TRANGTHAI] = ?\n"
                + " WHERE [MANV] = ?";
        int check = 0;
        try ( Connection con = SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getTen());
            ps.setObject(2, nv.isGioiTinh());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getEmail());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.isTrangThai());
            ps.setObject(8, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        new NhanVienRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}
