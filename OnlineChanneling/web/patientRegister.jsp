
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/login.css">
       <link rel="stylesheet" type="text/css" href="CSS/header.css">
    </head>
    <body>
        <div class="h1">E-Channeling System</div>
        <div class="ul">
            <div class="li"><a href="index.jsp">Login</a></div>
            <div class="li" style="float:right"><a href="doctorRegister.jsp">Doctor Registration</a></div>
            <div class="li" style="float:right; background-color: #18514a"><a href="patientRegister.jsp">Patient Registration</a></div>
        </div>
        
        <div class="signBox">
            <form action="patientCntrl.jsp" name="user_signup_form"   onsubmit="return datavalid()"  method="POST">
                <h1>Patient Sign Up</h1>
                <table>
                    <tr>
                        <td width="50%">Name</td>
                        <td><input type="text" name="name" placeholder="Full Name" required></td>
                    </tr>
                    <tr>
                        <td>NIC</td>
                        <td><input type="text" name="userName" placeholder="123456789V" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" name="phone" placeholder="07XXXXXXXX" required></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Password" required></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="cpw" placeholder="Re-Enter Password" required></td>
                    </tr>
                </table>
                <center><input type="submit" name="button" value="Sign Up"></center>
            </form>
        </div>
        
    </body>
</html>
