/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import bean.ScheduleBean;
import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hasitha
 */
public class ScheduleRepository {
    public boolean makeSchedule(ScheduleBean scheduleBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("INSERT INTO SHEDULE VALUES(?,?,?,?)");
            ps.setString(1, scheduleBean.getUserName());
            ps.setString(2, scheduleBean.getDate());
            ps.setString(3, scheduleBean.getTime());
            ps.setInt(4, scheduleBean.getOnOfPatient());

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
    
    public static ResultSet getScheduleDetails(String userName){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM SHEDULE WHERE doctorID = ?");
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
    
    public static boolean updateSchedule(ScheduleBean scheduleBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("UPDATE SHEDULE SET channelingTime=?, noOfPatients=? WHERE doctorID=? AND channelingDate=?");
            ps.setString(1, scheduleBean.getTime());
            ps.setInt(2, scheduleBean.getOnOfPatient());
            ps.setString(3, scheduleBean.getUserName());
            ps.setString(4, scheduleBean.getDate());

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
    
    public boolean deleteSchedule(ScheduleBean scheduleBean){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("DELETE FROM SHEDULE WHERE doctorID=? AND channelingDate=?");
            ps.setString(1, scheduleBean.getUserName());
            ps.setString(2, scheduleBean.getDate());

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
    
    public int getSheduledPatientsCount(String userName, String date){
        int sheduledPatientsCount = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
            
            ps = conn.prepareStatement ("SELECT * FROM SHEDULE WHERE doctorID = ? AND channelingDate = ?");
            ps.setString(1, userName);
            ps.setString(2, date);
            
            rs = ps.executeQuery();
            while(rs.next()){
                sheduledPatientsCount = rs.getInt("noOfPatients");
            }
            
        } catch (Exception e){
            e.printStackTrace();
            
        }finally {
//            DBConnection.getInstance().close(rs);
//            DBConnection.getInstance().close(ps);
//            DBConnection.getInstance().close(conn);
        }
        
        return sheduledPatientsCount;
        
    }
}
