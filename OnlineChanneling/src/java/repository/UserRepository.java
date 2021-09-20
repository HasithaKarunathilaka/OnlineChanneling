/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import bean.UserBean;
import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hasitha
 */
public class UserRepository {
    
    public boolean loginUser(UserBean userBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM USER_VAL WHERE userName = ? AND password = ?");
            ps.setString(1, userBean.getUserName());
            ps.setString(2, userBean.getPassword());
            
            rs = ps.executeQuery();
            result = rs.next();
            userBean.setType(rs.getString("type"));
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        return result;
    }
    
    
    public boolean addUser(UserBean userBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("INSERT INTO USER_VAL VALUES(?,?,?)");
            ps.setString(1, userBean.getUserName());
            ps.setString(2, userBean.getPassword());
            ps.setString(3, userBean.getType());

            int result2 = ps.executeUpdate();
            if(result2 > 0){
                result = true;
            }
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        return result;
    
    }
    
    public static ResultSet getUserDetails(String userName){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM USER_VAL WHERE userName = ?");
            ps.setString(1, userName);
            
            rs = ps.executeQuery();
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        return rs;
    
    }
    public static boolean updatePassword(UserBean userBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("UPDATE USER_VAL SET password=? WHERE username=?");
            ps.setString(1, userBean.getPassword());
            ps.setString(2, userBean.getUserName());

            int result2 = ps.executeUpdate();
            if(result2 > 0){
                result = true;
            }
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        return result;
        
    }
    
}
