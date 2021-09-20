/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import bean.PatientBean;
import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hasitha
 */
public class PatientRepository {
    public boolean setPatient(PatientBean patientBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("INSERT INTO PATIENT VALUES(?,?,?)");
            ps.setString(1, patientBean.getUserName());
            ps.setString(2, patientBean.getName());
            ps.setInt(3, patientBean.getPhone());
            
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
    
    public static ResultSet getPatientDetails(String userName){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM PATIENT WHERE nic = ?");
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
    
    public static boolean updatePatientDetails(PatientBean patientBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("UPDATE PATIENT SET name=?, phone=? WHERE nic=?");
            ps.setString(1, patientBean.getName());
            ps.setInt(2, patientBean.getPhone());
            ps.setString(3, patientBean.getUserName());

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
