/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Hasitha
 */
public class UserBean {
    private String userName;
    private String password;
    private String type;

    public UserBean(String userName , String password ) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    
}
