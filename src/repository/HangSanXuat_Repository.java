/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domainModel.ThuocTinhSP;
import unility.JDBC_Helper;
import viewmodel.ThuocTinh_ViewModel;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class HangSanXuat_Repository {

    public static List<ThuocTinh_ViewModel> getAllThuocTinh() {
        List<ThuocTinh_ViewModel> listTT = new ArrayList<>();
        String sql = "SELECT [MaHang]\n"
                + "      ,[TenHang]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[HANGSX]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaHang");
                String ten = rs.getString("TenHang");
                int trangThai = rs.getInt("TrangThai");
                ThuocTinh_ViewModel tt = new ThuocTinh_ViewModel(ma, ten, trangThai);
                listTT.add(tt);
            }
            return listTT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        public static ThuocTinhSP getAllHangSanXuatByMa(String ma){
            ThuocTinhSP tt = null;
            String sql = "SELECT [MaHang]\n"
                + "      ,[TenHang]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[HANGSX] where MaHang = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                String ma1 = rs.getString("MaHang");
                String ten1 = rs.getString("TenHang");
                int trangThai1 = rs.getInt("TrangThai");
                tt = new ThuocTinhSP(ma1, ten1, trangThai1);
                
            }
            return tt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
        public static String getMaHangSanXuat(String ten) {
        String sql = "select MaHang from ChatLieu where TenHang = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while (rs.next()) {
                ma = rs.getString("MaHang");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public static  String getAllMaHangSanXuatbyTen(String ten){
        String sql = "select MaHang from HANGSX  where TenHang = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while(rs.next()){
               ma = rs.getString("MaHang");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int themHangSanXuat(ThuocTinhSP tt) {
        String sql = "INSERT INTO [dbo].[HANGSX]\n"
                + "           ([MaHang]\n"
                + "           ,[TenHang]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, tt.getMaThuocTinh(), tt.getTenThuocTinh(), tt.getTrangThai());
    }

    public int suaHangSanXuat(ThuocTinhSP tt, String ma) {
        String sql = "UPDATE [dbo].[HANGSX]\n"
                + "   SET [TenHang] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE MaHang = ? ";
        return JDBC_Helper.updateTongQuat(sql, tt.getTenThuocTinh(),tt.getTrangThai(), tt.getMaThuocTinh());
    }

    public int xoaHangSanXuat(String ma) {
        String sql = "delete from HANGSX where MaHang = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }

}
