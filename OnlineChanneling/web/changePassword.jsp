
<%@page import="repository.UserRepository"%>
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
    
    ResultSet result = UserRepository.getUserDetails(userName);
    String spassword = null;
  
        if(result.next()){
            spassword = result.getString("password");
        }
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
       <link rel="stylesheet" type="text/css" href="CSS/button.css">
       
       <script language="javascript">
            
            function datavalid(){
          
                if(document.changePasswordForm.password.value!==document.changePasswordForm.confirmPassword.value) {
                    alert("Password and Confirmation does not match");
                    return false;
                }else if(document.changePasswordForm.password.value!==spassword){
                    alert("Invalid Current Password");
                    return false;
                }
                else{
                    return confirm;
                }
            }
            
        </script>
       
    </head>
    <body>
        <div class="h1">E-Channeling System</div>
        <div class="ul">
            <div class="li"><a href="doctorHome.jsp">Home</a></div>
            <div class="li" style="background-color: #18514a"><a href="doctorProfile.jsp">Profile</a></div>
            <div class="li" style="float:right"><a href="logout.jsp">LOGOUT</a></div>
        </div>
        
        <div class="formBox">
            <form action="doctorCntrl.jsp" onsubmit="return datavalid()" name="changePasswordForm" method="POST">
                <h1>Change Password</h1>
                <table>
                    <tr>
                        <td>Current Password</td>
                        <td><input type="text" name="currentPassword" placeholder="Current Password" required></td>
                    </tr>
                    <tr>
                        <td>New Password</td>
                        <td><input type="text" name="newPassword" placeholder="New Password" required></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="text" name="confirmPassword" placeholder="Re-enter new password" required></td>
                    </tr>                    
                    <tr>
                        <td><input style="margin-top: 15px;width: 180px" type="submit" name="button" value="Change Password"></td>
                        <td>
                                <input  style="float:right; width: 100px; margin-top: 10px" type="button" name="changePassword" value="Back" onclick="window.location.href = 'doctorProfile.jsp'">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
