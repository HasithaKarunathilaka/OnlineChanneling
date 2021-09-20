
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
            <div class="li" style="background-color: #18514a"><a href="index.jsp">Login</a></div>
            <div class="li" style="float:right"><a href="doctorRegister.jsp">Doctor Registration</a></div>
            <div class="li" style="float:right"><a href="patientRegister.jsp">Patient Registration</a></div>
        </div>
        
        <div class="loginBox">
            <h1>Login</h1>
            <form name="user_login_form" action="loginCntrl.jsp" method="POST">
                <p>Username</p>
                <input type="text" name="userName" placeholder="" required>
                <p>Password</p>
                <input type="password" name="password" placeholder="" required>
                <input type="submit" name="login" value="Login">
            </form>
        </div>
    </body>
</html>
