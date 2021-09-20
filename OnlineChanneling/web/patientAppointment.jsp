
<%@page import="repository.AppointmentRepository"%>
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
            <div class="li"><a href="patientHome.jsp">Home</a></div>
            <div class="li" style="background-color: #18514a"><a href="patientAppointment.jsp">My Appointments</a></div>
            <div class="li"><a href="patientProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="tableBox">
            <h1 style="text-align: center">My Appointments</h1>
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Doctor Name</th>
                    <th>Specialization</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    <%
                        ResultSet rs = AppointmentRepository.getAppointmentDetails(userName);
                        int rowNo = 1;
                        while(rs.next()){
//                            String checkDate = rs.getString("channelingDate");
//                            if(!rs.getString("channelingDate").equals(null)){ %>
                                <form action="appointmentCntrl.jsp">
                                    <input name="userName" type="hidden" value="<%= rs.getString("username")%>">
                                    <tr>
                                        <td>
                                            <%= rowNo%>
                                        </td>
                                        <td style="width: 120px">
                                            <input name="name" type="text" value="<%= rs.getString("name")%>" readonly="true" style="border: 0; background-color: transparent; width: 100%">
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
                                        <td style="width: auto">
                                            <div class="btnTable">
                                                <input type="submit" name="button" value="Delete">
                                            </div>  
                                        </td>
                                    </tr>
                                </form>
                            
                        <% //    }
                    %>  
                
                    <%
                        rowNo++;
                        }
                    %>
                </tbody>
            </table>
        </div>
        
    </body>
</html>
