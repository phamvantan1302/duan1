/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domainModel.ThuocTinhSP;
import unility.JDBC_Helper;
import viewmodel.ThuocTinh_ViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author asus
 */
public class KieuMu_Repository {

    public static List<ThuocTinh_ViewModel> getAllthuocTinh() {
        List<ThuocTinh_ViewModel> listTT = new ArrayList<>();
        String sql = "SELECT [MaKieuMu]\n"
                + "      ,[TenKieuMu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KIEUMU]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaKieuMu");
                String ten = rs.getString("TenKieuMu");
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
        public static ThuocTinhSP getAllKieuMuByMa(String ma){
            ThuocTinhSP tt = null;
            String sql = "SELECT [MaKieuMu]\n"
                + "      ,[TenKieuMu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KIEUMU] where MaKieuMu = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql,ma);
        try {
            while (rs.next()) {
                String ma1 = rs.getString("MaKieuMu");
                String ten1 = rs.getString("TenKieuMu");
                int trangThai1 = rs.getInt("TrangThai");
                tt = new ThuocTinhSP(ma1, ten1, trangThai1);
                
            }
            return tt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
        public static String getMaKieuMu(String ten) {
        String sql = "select MaKieuMu from ChatLieu where TenKieuMu = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while (rs.next()) {
                ma = rs.getString("MaKieuMu");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static  String getAllMaKieuMubyTen(String ten){
        String sql = "select MaKieuMu from KIEUMU  where TenKieuMu =?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while(rs.next()){
               ma = rs.getString("MaKieuMu");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int themKieuMu(ThuocTinhSP tt) {
        String sql = "INSERT INTO [dbo].[KIEUMU]\n"
                + "           ([MaKieuMu]\n"
                + "           ,[TenKieuMu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, tt.getMaThuocTinh(), tt.getTenThuocTinh(),tt.getTrangThai());
    }

    public static int suaKieuMu(ThuocTinhSP tt, String ma) {
        String sql = "UPDATE [dbo].[KIEUMU]\n"
                + "   SET [TenKieuMu] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE [MaKieuMu] = ?";
        return JDBC_Helper.updateTongQuat(sql, tt.getTenThuocTinh(), tt.getTrangThai(), tt.getMaThuocTinh());
    }

    public static int xoaKieuMu(String ma) {
        String sql = "delete from KIEUMU where [MaKieuMu] = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }

}
