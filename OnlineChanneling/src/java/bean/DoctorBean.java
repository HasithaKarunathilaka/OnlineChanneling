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
public class DoctorBean {
    private String userID;
    private String name;
    private int phone;
    private String specialization;
    private String password;

    public DoctorBean(String userID, String name, int phone, String specialization, String password) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.specialization = specialization;
        this.password = password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPassword() {
        return password;
    }
    
    
}
