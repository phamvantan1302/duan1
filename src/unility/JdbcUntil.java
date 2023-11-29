/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author asus
 */
public class JdbcUntil {
    static String url = "jdbc:sqlserver://localhost\\DESTOP\\SQLEXPRESS:1433;databaseName=QLBANMUBAOHIEM";
    static String user = "sa";
    static String pass = "tan13022003";
    
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getContext(){
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        Connection con = getContext();
        if(con.equals("")){
            System.out.println("loi");
        }else{
            System.out.println("thanhcong");
        }
    }
}
