/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domainModel.SanPhamCT;
import java.math.BigDecimal;
import unility.JDBC_Helper;
import viewmodel.SanPhamCT_ViewModel;
import java.util.List;
import java.util.ArrayList;
import unility.SQLSeverConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class SanPhamCT_Repository {

    public List<SanPhamCT_ViewModel> getAllSanPhamCT() {
        List<SanPhamCT_ViewModel> listsp = new ArrayList<>();
        String sql = "SELECT MaSanPham,TenMU,TenHang,TenChatLieu,TenMauSac,Size,TenKieuMu,TenKinh,GiaBan,Anh,SoLuong FROM CHITIETSANPHAM INNER JOIN HANGSX ON CHITIETSANPHAM.MaHang = HANGSX.MaHang \n"
                + "				INNER JOIN CHATLIEU ON CHITIETSANPHAM.MaChatLieu = CHATLIEU.MaChatLieu\n"
                + "				INNER JOIN MAUSAC ON CHITIETSANPHAM.MaMauSac = MAUSAC.MaMauSac\n"
                + "				INNER JOIN KIEUMU ON CHITIETSANPHAM.MaKieuMu = KIEUMU.MaKieuMu\n"
                + "				INNER JOIN KINHMU ON CHITIETSANPHAM.MaKinh = KINHMU.MaKinh";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaSanPham");
                String TenM = rs.getString("TenMU");
                String TenH = rs.getString("TenHang");
                String TenCL = rs.getString("TenChatLieu");
                String TenMS = rs.getString("TenMauSac");
                String Size = rs.getString("Size");
                String TenKM = rs.getString("TenKieuMu");
                String TenK = rs.getString("TenKinh");
                int GiaBan = rs.getInt("GiaBan");
                int soLuong = rs.getInt("SoLuong");
                String Anh = rs.getString("Anh");
                SanPhamCT_ViewModel spct = new SanPhamCT_ViewModel(ma, TenM, TenH, TenCL, TenMS, Size, TenKM, TenK, GiaBan, soLuong, Anh);
                listsp.add(spct);

            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamCT_ViewModel> getAllSP() {
       List<SanPhamCT_ViewModel> listsp = new ArrayList<>();
        String sql = "SELECT [MaSanPham]\n"
                + "      ,[TenMU]\n"
                + "      ,[Size]\n"
                + "      ,[GiaBan]\n"
                + "      ,[SoLuong]\n"
                + "  FROM [dbo].[CHITIETSANPHAM]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaSanPham");
                String TenM = rs.getString("TenMU");
                String Size = rs.getString("Size");
                int GiaBan = rs.getInt("GiaBan");
                int soLuong = rs.getInt("SoLuong");
                SanPhamCT_ViewModel spct = new SanPhamCT_ViewModel(ma, TenM, Size, GiaBan, soLuong);
                listsp.add(spct);

            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public int insert(SanPhamCT sp) {
        String sql = "INSERT INTO [dbo].[CHITIETSANPHAM]\n"
                + "           ([MaSanPham]\n"
                + ",           [TenMU]\n"
                + "           ,[MaHang]\n"
                + "           ,[MaChatLieu]\n"
                + "           ,[MaMauSac]\n"
                + "           ,[Size]\n"
                + "           ,[MaKieuMu]\n"
                + "           ,[MaKinh]\n"
                + "           ,[GiaBan]\n"
                + "           ,[SoLuong]\n"
                + "           ,[Anh])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, sp.getMaSP(), sp.getTenMu(), sp.getMaHang(),
                sp.getMaChatLieu(), sp.getMaMauSac(), sp.getSize(),
                sp.getMaKieuMu(), sp.getMaKinh(), sp.getGiaBan(), sp.getSoLuong(), sp.getAnh());

    }

    public int update(SanPhamCT sp, String ma) {
        String sql = "UPDATE [dbo].[CHITIETSANPHAM]\n"
                + "   SET [TenMU] = ?"
                + "      ,[MaHang] = ?"
                + "      ,[MaChatLieu] = ?"
                + "      ,[MaMauSac] = ?"
                + "      ,[Size] = ?"
                + "      ,[MaKieuMu] = ?"
                + "      ,[MaKinh] = ?"
                + "      ,[GiaBan] = ?"
                + "      ,[SoLuong] = ?"
                + "      ,[Anh] = ?"
                + " WHERE [MaSanPham] = ?";
        return JDBC_Helper.updateTongQuat(sql, sp.getTenMu(), sp.getMaHang(),
                sp.getMaChatLieu(), sp.getMaMauSac(), sp.getSize(), sp.getMaKieuMu(), sp.getMaKinh(),
                sp.getGiaBan(), sp.getSoLuong(), sp.getAnh(), sp.getMaSP());
    }

    public int delete(String ma) {
        String sql = "delete from CHITIETSANPHAM where [MaSanPham] = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }

    public static void main(String[] args) {
        new SanPhamCT_Repository().getAllSP().forEach(s -> System.out.println(s.toString()));
    }
}
