/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import bean.AppointmentBean;
import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hasitha
 */
public class AppointmentRepository {
    public boolean setAppointment(AppointmentBean appointmentBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("INSERT INTO APPOINTMENT VALUES(?,?,?)");
            ps.setString(1, appointmentBean.getPatientID());
            ps.setString(2, appointmentBean.getDoctorID());
            ps.setString(3, appointmentBean.getChannelingDate());
            
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
    
    public static boolean deleteAppointment(AppointmentBean appointmentBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("DELETE FROM APPOINTMENT WHERE doctorID=? AND channelingDate=?");
//            ps = conn.prepareStatement ("DELETE FROM APPOINTMENT WHERE EXISTS (SELECT * FROM APPOINTMENT WHERE doctorID=? AND channelingDate=?");
            ps.setString(1, appointmentBean.getDoctorID());
            ps.setString(2, appointmentBean.getChannelingDate());

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
    
    public static ResultSet getAppointmentCount(String userName, String date){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT COUNT(doctorID) AS activePatients FROM APPOINTMENT WHERE doctorID = ? AND channelingDate = ?");
            ps.setString(1, userName);
            ps.setString(2, date);
            
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
    
    public static ResultSet getAppointmentDetails(String userName){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT DOCTOR.userName, DOCTOR.name, Doctor.specialization, SHEDULE.channelingDate, SHEDULE.channelingTime, APPOINTMENT.channelingDate AS date FROM APPOINTMENT INNER JOIN DOCTOR ON APPOINTMENT.doctorID = DOCTOR.userName INNER JOIN SHEDULE ON APPOINTMENT.doctorID = SHEDULE.doctorID AND APPOINTMENT.channelingDate = SHEDULE.channelingDate WHERE APPOINTMENT.patientID = ?");
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
}
