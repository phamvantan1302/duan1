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
import viewmodel.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public class DangNhapRepository {

    public List<NhanVienModel> getAll() {
        String query = "SELECT [MANV]\n"
                + "      ,[TENNV]\n"
                + "      ,[GIOITINH]\n"
                + "      ,[NGAYSINH]\n"
                + "      ,[EMAIL]\n"
                + "      ,[SODT]\n"
                + "      ,[DIACHI]\n"
                + "      ,[MATKHAU]\n"
                + "      ,[TRANGTHAI]\n"
                + "  FROM [dbo].[NHANVIEN]";
        try ( Connection con = unility.SQLSeverConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NhanVienModel> listnv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel tl = new NhanVienModel(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getBoolean(9));
                listnv.add(tl);
            }
            return listnv;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
