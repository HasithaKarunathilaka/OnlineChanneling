

<%@page import="repository.PatientRepository"%>
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
    
    ResultSet result = PatientRepository.getPatientDetails(userName);
    String name = null;
    int phone = 0;
        if(result.next()){
            name = result.getString("name");
            phone = result.getInt("phone");
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
            <div class="li"><a href="patientAppointment.jsp">My Appointments</a></div>
            <div class="li" style="background-color: #18514a"><a href="patientProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="formBox">
            <form action="patientCntrl.jsp" name="" method="POST">
                <h1>My Details</h1>
                <table>
                    <tr>
                        <td>NIC</td>
                        <td><input type="text" name="userName" placeholder="User ID" readonly="true" value="<%= userName%>" required></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" placeholder="Full Name" value="<%= name%>" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" name="phone" placeholder="07XXXXXXXX" value="<%= phone%>" required></td>
                    </tr>
                    <tr>
                        <td><input style="margin-top: 15px; width: 100px" type="submit" name="button" value="Update"></td>
                        <td>
                            <!--<form action="changePassword.jsp">-->
                                <!--<input type="hidden" name="password" required>-->
                                <input  style="float:right; width: 180px; margin-top: 10px" type="button" name="changePassword" value="Change Password" onclick="window.location.href = 'patientChangePassword.jsp'">
                            <!--</form>-->  
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        
    </body>
</html>
