/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.UserBean;
import repository.UserRepository;
/**
 *
 * @author Hasitha
 */
public class UserService {
    
    public static String userLogin(UserBean userBean){
        UserRepository userRepository = new UserRepository();
        boolean result = userRepository.loginUser(userBean);
        
        if(result){
//            System.out.println(userBean.getType());
            return userBean.getType();
        }else{
            return "error";
        }
//        return userBean.getUserName();
    }
}
