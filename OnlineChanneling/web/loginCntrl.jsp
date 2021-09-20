
<%@page contentType="text/html" pageEncoding="UTF-8" import="bean.UserBean, service.UserService"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <%
            String userName = request.getParameter("userName"); 
            String password = request.getParameter("password");
            
            UserBean userBean = new UserBean(userName, password);
            String result = UserService.userLogin(userBean);
//            System.out.println(result);
            if(result.equals("Doctor")){ 
                session.setAttribute("userName", userName);
            %>
                <script>
                    alert ("Login Succesful");
                </script>
                <jsp:forward page = "doctorHome.jsp"/>
                   
            <%}else if(result.equals("Patient")){
                session.setAttribute("userName", userName);
                
            %>
                <script>
                    alert ("Login Succesful");
                </script>
                <jsp:include page = "patientHome.jsp"/>
                   
            <% 
            }else {
            %>
                <script>
                    alert ("Username or Password Incorrect");
                </script>
                <jsp:include page="index.jsp"/>
            <%
                
            }
        %>
    </body>
</html>
