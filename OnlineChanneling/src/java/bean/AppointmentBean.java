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
public class AppointmentBean {
    private String patientID;
    private String doctorID;
    private String channelingDate;

    public AppointmentBean(String patientID, String doctorID, String channelingDate) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.channelingDate = channelingDate;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setChannelingDate(String channelingDate) {
        this.channelingDate = channelingDate;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getChannelingDate() {
        return channelingDate;
    }
}
