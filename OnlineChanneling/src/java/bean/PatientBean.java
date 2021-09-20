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
public class PatientBean {
    private String userName;
    private String name;
    private int phone;
    private String password;

    public PatientBean(String userName, String name, int phone, String password) {
        this.userName = userName;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
    
}
