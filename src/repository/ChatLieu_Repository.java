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
public class ChatLieu_Repository {

    public static List<ThuocTinh_ViewModel> getAllThuocTinh() {
        List<ThuocTinh_ViewModel> listCl = new ArrayList<>();
        String sql = "SELECT [MaChatLieu]\n"
                + "      ,[TenChatLieu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[CHATLIEU]";
        ResultSet rs = unility.JDBC_Helper.selectTongQuat(sql);

        try {
            while (rs.next()) {
                String ma = rs.getString("MaChatLieu");
                String ten = rs.getString("TenChatLieu");
                int trangThai = rs.getInt("TrangThai");
                ThuocTinh_ViewModel tt = new ThuocTinh_ViewModel(ma, ten, trangThai);
                listCl.add(tt);
            }
            return listCl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static  ThuocTinhSP getAllChatLieuByMa(String ma){
        ThuocTinhSP tt = null;
         String sql = "SELECT [MaChatLieu]\n"
                + "      ,[TenChatLieu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[CHATLIEU] where MaChatLieu =? ";
        ResultSet rs = unility.JDBC_Helper.selectTongQuat(sql,ma);

        try {
            while (rs.next()) {
                String ma1 = rs.getString("MaChatLieu");
                String ten1 = rs.getString("TenChatLieu");
                int trangThai1 = rs.getInt("TrangThai");
                tt = new ThuocTinhSP(ma1, ten1, trangThai1);
                
            }
            return tt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getMaChatLieu(String ten) {
        String sql = "select MaChatLieu from ChatLieu where TenChatLieu = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while (rs.next()) {
                ma = rs.getString("MaChatLieu");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static  String getAllMaChatLieubyTen(String ten){
        String sql = "select MaChatLieu from CHATLIEU  where TenChatLieu =?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        String ma = null;
        try {
            while(rs.next()){
               ma = rs.getString("MaChatLieu");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static int themChatLieu(ThuocTinhSP tt) {
        String sql = "INSERT INTO [dbo].[CHATLIEU]\n"
                + "           ([MaChatLieu]"
                + "           ,[TenChatLieu]"
                + "           ,[TrangThai])"
                + "     VALUES(?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, tt.getMaThuocTinh(), tt.getTenThuocTinh(), tt.getTrangThai());
    }

    public static int suaChatLieu(ThuocTinhSP tt, String ma) {
        String sql = "UPDATE [dbo].[CHATLIEU]\n"
                + "   SET [TenChatLieu] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE MaChatLieu = ?";
        return JDBC_Helper.updateTongQuat(sql, tt.getTenThuocTinh(),tt.getTrangThai(), tt.getMaThuocTinh());
    }

    public static int xoaChatLieu(String ma) {
        String sql = "delete from CHATLIEU where MaChatLieu = ?";
        return JDBC_Helper.updateTongQuat(sql, ma);
    }
}
