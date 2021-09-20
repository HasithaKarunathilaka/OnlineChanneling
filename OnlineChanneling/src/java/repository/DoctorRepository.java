/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import bean.DoctorBean;
import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hasitha
 */
public class DoctorRepository {
    public boolean doctorRegister(DoctorBean doctorBean){
        System.out.println("doctorRegister");
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("INSERT INTO DOCTOR VALUES(?,?,?,?)");
            ps.setString(1, doctorBean.getUserID());
            ps.setString(2, doctorBean.getName());
            ps.setString(3, doctorBean.getSpecialization());
            ps.setInt(4, doctorBean.getPhone());
            
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
    
    public static ResultSet getDoctorDetails(String userName){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM DOCTOR WHERE userName = ?");
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
    
    public static boolean updateDoctorDetails(DoctorBean doctorBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("UPDATE DOCTOR SET name=?, specialization=?, phone=? WHERE userName=?");
            ps.setString(1, doctorBean.getName());
            ps.setString(2, doctorBean.getSpecialization());
            ps.setInt(3, doctorBean.getPhone());
            ps.setString(4, doctorBean.getUserID());

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
    
    public static ResultSet getSearchDetails(String name, String specialization){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String doctorName = "%" + name + "%"; 
        System.out.println(doctorName);
        if(specialization.equals("All")){
            
            try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT DOCTOR.userName, DOCTOR.name, Doctor.specialization, SHEDULE.channelingDate, SHEDULE.channelingTime FROM DOCTOR INNER JOIN SHEDULE ON DOCTOR.userName = SHEDULE.doctorID WHERE DOCTOR.name LIKE ?");
            ps.setString(1, doctorName);
            
            rs = ps.executeQuery();
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        }else{
            
            try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT DOCTOR.userName, DOCTOR.name, Doctor.specialization, SHEDULE.channelingDate, SHEDULE.channelingTime FROM DOCTOR INNER JOIN SHEDULE ON DOCTOR.userName = SHEDULE.doctorID WHERE DOCTOR.name LIKE ? AND Doctor.specialization = ?");
            ps.setString(1, doctorName);
            ps.setString(2, specialization);
            
            rs = ps.executeQuery();
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        }
                
        return rs;
        
    }
    
}
