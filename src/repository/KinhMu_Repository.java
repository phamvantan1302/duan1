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
public class KinhMu_Repository {

    public static List<ThuocTinh_ViewModel> getAllthuocTinh() {
        List<ThuocTinh_ViewModel> listTT = new ArrayList<>();
        String sql = "SELECT [MaKinh]\n"
                + "      ,[TenKinh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KINHMU]";
        ResultSet rs = unility.JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaKinh");
                String ten = rs.getString("TenKinh");
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
        public static ThuocTinhSP getAllKinhMuByMa(String ma){
            ThuocTinhSP tt = null;
             String sql = "SELECT [MaKinh]\n"
                + "      ,[TenKinh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KINHMU] where MaKinh = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                String ma1 = rs.getString("MaKinh");
                String ten1 = rs.getString("TenKinh");
                int trangThai1 = rs.getInt("TrangThai");
                 tt = new ThuocTinhSP(ma1, ten1, trangThai1);
                

            }
            return tt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
        public static String getMaKinhMu(String ten) {
        String sql = "select MaKinh from ChatLieu where TenKinh = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while (rs.next()) {
                ma = rs.getString("MaKinh");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public static  String getAllMaKinhMubyTen(String ten){
        String sql = "select MaKinh from KINHMU where TenKinh =?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while(rs.next()){
               ma = rs.getString("MaKinh");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int themKinhMu(ThuocTinhSP tt) {
        String sql = "INSERT INTO [dbo].[KINHMU]\n"
                + "           ([MaKinh]\n"
                + "           ,[TenKinh]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, tt.getMaThuocTinh(), tt.getTenThuocTinh());
    }

    public static int suaKinhMu(ThuocTinhSP tt, String ma) {
        String sql = "UPDATE [dbo].[KINHMU]\n"
                + "   SET [TenKinh] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE [MaKinh] = ?";
        return JDBC_Helper.updateTongQuat(sql, tt.getTenThuocTinh(),tt.getTrangThai(), tt.getMaThuocTinh());
    }

    public static int xoaKinhMu(String ma) {
        String sql = "delete from KINHMU where [MaKinh] = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }
}
