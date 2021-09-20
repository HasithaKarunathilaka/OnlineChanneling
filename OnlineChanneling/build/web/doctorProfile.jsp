
<%@page import="java.sql.ResultSet"%>
<%@page import="repository.DoctorRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String userName = null;
    if(session != null){
        userName = String.valueOf(session.getAttribute("userName"));
    }else{
        response.sendRedirect("index.jsp");
    }
       
    ResultSet result = DoctorRepository.getDoctorDetails(userName);
    String name = null;
    String specialization = null;
    int phone = 0;
        if(result.next()){
            name = result.getString("name");
            specialization = result.getString("specialization");
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
            <div class="li"><a href="doctorHome.jsp">Home</a></div>
            <div class="li" style="background-color: #18514a"><a href="doctorProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="formBox">
            <form action="doctorCntrl.jsp" name="" method="POST">
                <h1>My Details</h1>
                <table>
                    <tr>
                        <td>User ID</td>
                        <td><input type="text" name="userID" placeholder="User ID" readonly="true" value="<%= userName%>" required></td>
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
                        <td  width="150px">Specialization</td>
                        <td><select style="background: rgba(255, 255, 255, 0.7)" name="specialization" value="<%= specialization%>" required>
				<option>General</option>
                                <option>Family Medicine</option>
				<option>Emergency Medicine</option>
				<option>Psychiatry</option>
				<option>Surgery</option>
				<option>Cardiology</option>
			</select></td>
                    </tr>
                    <tr>
                        <td><input style="margin-top: 15px" type="submit" name="button" value="Update"></td>
                        <td>
                            <!--<form action="changePassword.jsp">-->
                                <!--<input type="hidden" name="password" required>-->
                                <input  style="float:right; width: 180px; margin-top: 10px" type="button" name="changePassword" value="Change Password" onclick="window.location.href = 'changePassword.jsp'">
                            <!--</form>-->  
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
