
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
            <div class="li"><a href="">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        <div class="formBox">
            <form action="scheduleCntrl.jsp" name="makeScheduleForm" method="POST">
                <h1>Make Schedule</h1>
                <table>
                    <tr>
                        <td width="150px">Date</td>
                        <td><input type="date" name="date" required></td>
                    </tr>
                    <tr>
                        <td>Time</td>
                        <td><input type="time" name="time" required></td>
                    </tr>
                    <tr>
                        <td>Total Patients</td>
                        <td><input type="number" name="totalPatients"required></td>
                    </tr>
                </table>
                <center><input type="submit" name="button" value="Make Schedule"></center>
            </form>
        </div>
    </body>
</html>
