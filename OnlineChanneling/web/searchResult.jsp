
<%@page import="repository.AppointmentRepository"%>
<%@page import="repository.DoctorRepository"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String userName = null;
    if(session != null){
        userName = String.valueOf(session.getAttribute("userName"));
    }else{
        response.sendRedirect("index.jsp");
    }
    String specialization = request.getParameter("specialization");
    String name = request.getParameter("name");
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
        <link rel="stylesheet" type="text/css" href="CSS/button.css">
    </head>
    <body>
        <div class="h1">E-Channeling System</div>
        <div class="ul">
            <div class="li" style="background-color: #18514a"><a href="patientHome.jsp">Home</a></div>
            <div class="li"><a href="patientAppointment.jsp">My Appointments</a></div>
            <div class="li"><a href="patientProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="tableBox">
            
            <h1 style="text-align: center">Search Result</h1>
            <table  id="scheduleDetailRow">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Doctor Name</th>
                    <th>Specialization</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Active Patients</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    <%
                        ResultSet rs = DoctorRepository.getSearchDetails(name, specialization);
                        int rowNo = 1;
                        System.out.println(specialization);
                        while(rs.next()){
                            System.out.println(rs.getString("name"));
                    %>  
                <form action="appointmentCntrl.jsp">
                    <%
                        int activePatients = 0;
                        ResultSet rs2 = AppointmentRepository.getAppointmentCount(rs.getString("userName"), rs.getString("channelingDate"));
                        while(rs2.next()){
                            activePatients = rs2.getInt("activePatients");
                        }
                    %>
                    <input name="userName" type="hidden" value="<%= rs.getString("userName")%>">
                    <tr>
                        <td>
                            <%= rowNo%>
                        </td>
                        <td style="width: 120px">
                            <input name="name" type="text" readonly="true" value="<%= rs.getString("name")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 120px">
                            <input name="specialization" type="text" readonly="true" value="<%= rs.getString("specialization")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 140px">
                            <input name="date" type="text" readonly="true" value="<%= rs.getString("channelingDate")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 150px">
                            <input name="time" type="text" readonly="true" value="<%= rs.getString("channelingTime")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 150px">
                            <input name="activePatients" type="text" readonly="true" value="<%= activePatients%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: auto">
                            <div class="btnTable">
                                <input type="submit" name="button" value="Make Appointment">
                            </div>  
                        </td>
                    </tr>
                </form>
                    <%
                        rowNo++;
                        }
                    %>
                </tbody>
            </table>
        </div>
        
    </body>
</html>
