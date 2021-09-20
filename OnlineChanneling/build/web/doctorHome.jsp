
<%@page import="repository.AppointmentRepository"%>
<%@page import="repository.ScheduleRepository"%>
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
%>

<html>
    
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
        <link rel="stylesheet" type="text/css" href="CSS/button.css">
        
    </head>
    <body>
        <div class="h1">E-Channeling System</div>
        <div class="ul">
            <div class="li" style="background-color: #18514a"><a href="doctorHome.jsp">Home</a></div>
            <div class="li"><a href="doctorProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        
    <!--<center>-->
        <div class="tableBox">
            <div class="add">
                <input style="width: 170px" type="button" value="Add Shedule" onclick="window.location.href='makeSchedule.jsp';">
            </div>
            
            <h1 style="text-align: center">Schedule Details</h1>
            <table  id="scheduleDetailRow">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Schedule Date</th>
                    <th>Schedule Time</th>
                    <th>Schedule Patients</th>
                    <th>Active Patients</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    <%
                        ResultSet rs = ScheduleRepository.getScheduleDetails(userName);
                        int rowNo = 1;
                        while(rs.next()){
                    %>  
                <form action="updateSchedule.jsp">
                     <%
                        int activePatients = 0;
                        ResultSet rs2 = AppointmentRepository.getAppointmentCount(rs.getString("doctorID"), rs.getString("channelingDate"));
                        while(rs2.next()){
                            activePatients = rs2.getInt("activePatients");
                        }
                    %>
                    <tr>
                        <td>
                            <%= rowNo%>
                        </td>
                        <td style="width: 120px">
                            <input name="date" type="text" readonly="true" value="<%= rs.getString("channelingDate")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 120px">
                            <input name="time" type="text" readonly="true" value="<%= rs.getString("channelingTime")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 140px">
                            <input name="scheduledPatients" type="text" readonly="true" value="<%= rs.getString("noOfPatients")%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: 150px">
                            <input name="appointedPatients" type="text" readonly="true" value="<%= activePatients%>" style="border: 0; background-color: transparent; width: 100%">
                        </td>
                        <td style="width: auto">
                            <div class="btnTable">
                                <input type="submit" name="edit" value="Edit">
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
    <!--</center>-->
        
    </body>
</html>
