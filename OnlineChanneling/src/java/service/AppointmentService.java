/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.AppointmentBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import repository.AppointmentRepository;
import repository.ScheduleRepository;

/**
 *
 * @author Hasitha
 */
public class AppointmentService {
    public static boolean makeAppointment(AppointmentBean appointmentBean) throws SQLException{
        boolean result = false;
        
        ScheduleRepository scheduleRepository = new ScheduleRepository();
        int sheduledPatientsCount = scheduleRepository.getSheduledPatientsCount(appointmentBean.getDoctorID(), appointmentBean.getChannelingDate());
        System.out.println(sheduledPatientsCount);
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        ResultSet rs = appointmentRepository.getAppointmentCount(appointmentBean.getDoctorID(), appointmentBean.getChannelingDate());
        
        int activePatients = 0;
        while(rs.next()){
            activePatients = rs.getInt("activePatients");
        }
        System.out.println(activePatients);
        if(sheduledPatientsCount > activePatients){
            result = appointmentRepository.setAppointment(appointmentBean);  
        }
        
       return result;
    }
    
}
