
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
            <div class="li" style="background-color: #18514a"><a href="patientHome.jsp">Home</a></div>
            <div class="li"><a href="patientAppointment.jsp">My Appointments</a></div>
            <div class="li"><a href="patientProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="formBox">
            <form action="searchResult.jsp" name="" method="POST">
                <h1>Search Doctor</h1>
                <table>
                    <tr>
                        <td  width="130px">Specialization</td>
                        <td><select style="background: rgba(255, 255, 255, 0.7)" name="specialization">
                                <option selected>All</option>
				<option>General</option>
                                <option>Family Medicine</option>
				<option>Emergency Medicine</option>
				<option>Psychiatry</option>
				<option>Surgery</option>
				<option>Cardiology</option>
			</select></td>
                    </tr>
                     <tr>
                        <td>Doctor Name</td>
                        <td><input type="text" name="name" placeholder="Ex - Saman Perera" required=""></td>
                    </tr>
                    <tr>
                        <td colspan="2"><center><input style="margin-top: 15px" type="submit" name="button" value="Search"></center></td>            
                    </tr>
                </table>
            </form>
        </div>
        
    </body>
</html>
