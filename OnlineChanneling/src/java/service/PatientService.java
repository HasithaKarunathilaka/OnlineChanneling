/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.PatientBean;
import bean.UserBean;
import repository.PatientRepository;
import repository.UserRepository;

/**
 *
 * @author Hasitha
 */
public class PatientService {
    public static boolean registerPatient(PatientBean patientBean){
        boolean result = false;
        
        PatientRepository patientRepository = new PatientRepository();
        result = patientRepository.setPatient(patientBean);
        
        if(result){
            UserBean userBean = new UserBean(patientBean.getUserName(), patientBean.getPassword());
            userBean.setType("Patient");
            
            UserRepository userRepository = new UserRepository();
            boolean result2 = userRepository.addUser(userBean);
        
        }else{
            result = false;
        
        }
        return result;
    
    }
    
}
