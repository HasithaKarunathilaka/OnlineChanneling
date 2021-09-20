/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.AppointmentBean;
import bean.DoctorBean;
import bean.ScheduleBean;
import bean.UserBean;
import repository.AppointmentRepository;
import repository.DoctorRepository;
import repository.ScheduleRepository;
import repository.UserRepository;

/**
 *
 * @author Hasitha
 */
public class DoctorService {
    public static String doctorRegister(DoctorBean doctorBean){
        String result = null;
        UserBean userBean = new UserBean(doctorBean.getUserID(), doctorBean.getPassword());
        userBean.setType("Doctor");
        
        DoctorRepository doctorRepository = new DoctorRepository();
        boolean resultDoctor = doctorRepository.doctorRegister(doctorBean);
        
        if(resultDoctor){
            UserRepository userRepository = new UserRepository();
            boolean resultUser = userRepository.addUser(userBean);
            
            if(resultUser){
                result = "done";
            
            }else {
                result = "User Registration Error";
            
            }
            
        }else {
            
            result = "Doctor Registration Error";
        }
        return result;
    }
    
    public static boolean makeSchedule(ScheduleBean scheduleBean){
        
//        Both doctor user name and Channeling date are primary keys of SHEDULE table.
//        Therefore no need to creat logic to check whether there is a schedule on that day.
        
        ScheduleRepository scheduleRepository = new ScheduleRepository();
        boolean result = scheduleRepository.makeSchedule(scheduleBean);
        return result;
    }
    
    public static boolean deleteSchedule(ScheduleBean scheduleBean){
        ScheduleRepository scheduleRepository = new ScheduleRepository();
        boolean result = scheduleRepository.deleteSchedule(scheduleBean);
        
        if(result){
            AppointmentBean appointmentBean = new AppointmentBean(scheduleBean.getUserName(), scheduleBean.getDate(), "");
            boolean resulr2 = AppointmentRepository.deleteAppointment(appointmentBean);
            result = true;
            
        }else{
            
            result = false;
        }
        return result;
    }
    
}
