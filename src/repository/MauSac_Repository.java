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
public class MauSac_Repository {

    public static List<ThuocTinh_ViewModel> getAllThuocTinh() {
        List<ThuocTinh_ViewModel> listMS = new ArrayList<>();
        String sql = "SELECT [MaMauSac]\n"
                + "      ,[TenMauSac]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[MAUSAC]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("MaMauSac");
                String ten = rs.getString("TenMauSac");
                int trangThai = rs.getInt("TrangThai");
                ThuocTinh_ViewModel tt = new ThuocTinh_ViewModel(ma, ten, trangThai);
                listMS.add(tt);
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
        
        public static ThuocTinhSP getAllMauSacByMa(String ma){
            ThuocTinhSP tt = null;
            String sql = "SELECT [MaMauSac]\n"
                + "      ,[TenMauSac]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[MAUSAC] where MaMauSac = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ma);
        try {
            while (rs.next()) {
                String ma1 = rs.getString("MaMauSac");
                String ten1 = rs.getString("TenMauSac");
                int trangThai1 = rs.getInt("TrangThai");
                 tt = new ThuocTinhSP(ma1, ten1, trangThai1);
                
            }
            return tt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
        public static String getMaMauSac(String ten) {
        String sql = "select MaMauSac from ChatLieu where TenMauSac = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while (rs.next()) {
                ma = rs.getString("MaMauSac");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public static  String getAllMaMauSacbyTen(String ten){
        String sql = "select MaMauSac from MAUSAC  where TenMauSac =?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while(rs.next()){
               ma = rs.getString("MaMauSac");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int themMauSac(ThuocTinhSP tt) {
        String sql = "INSERT INTO [dbo].[MAUSAC]\n"
                + "           ([MaMauSac]\n"
                + "           ,[TenMauSac])\n"
                + "     VALUES(?,?)";
        return JDBC_Helper.updateTongQuat(sql, tt.getMaThuocTinh(), tt.getTenThuocTinh());
    }

    public static int suaMauSac(ThuocTinhSP tt, String ma) {
        String sql = "UPDATE [dbo].[MAUSAC]\n"
                + "   SET [TenMauSac] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE [MaMauSac] = ?";
        return JDBC_Helper.updateTongQuat(sql, tt.getTenThuocTinh(), tt.getMaThuocTinh());
    }

    public static int xoaMauSac(String ma) {
        String sql = "delete from MAUSAC where [MaMauSac] = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }

}
