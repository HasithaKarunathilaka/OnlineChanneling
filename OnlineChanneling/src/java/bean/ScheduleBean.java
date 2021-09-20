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
public class ScheduleBean {
    private String userName;
    private String date;
    private String time;
    private int onOfPatient;

    public ScheduleBean(String userName, String date, String time, int onOfPatient) {
        this.userName = userName;
        this.date = date;
        this.time = time;
        this.onOfPatient = onOfPatient;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOnOfPatient(int onOfPatient) {
        this.onOfPatient = onOfPatient;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getOnOfPatient() {
        return onOfPatient;
    }
}
