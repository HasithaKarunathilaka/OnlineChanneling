
<%@page import="repository.UserRepository"%>
<%@page import="bean.UserBean"%>
<%@page import="repository.DoctorRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="bean.DoctorBean, service.DoctorService"%>
<!DOCTYPE html>
<html>
    <head>
       
    </head>
    <body>
       <%
           
            String requestType = request.getParameter("button");
           
            if(requestType.equals("Update")){
                String userID = request.getParameter("userID");
                String name = request.getParameter("name");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String specialization = request.getParameter("specialization");
                
                DoctorBean doctorBean = new DoctorBean(userID, name, phone, specialization, "");
                boolean result = DoctorRepository.updateDoctorDetails(doctorBean);
           
                if(result){ %>
                        <script>
                            alert("Details Update Successful");
                        </script>
                        <jsp:include page = "doctorProfile.jsp"/>
           
                <% }else{ %>
                        <script>
//                            var msg = "<%=result%>";
                            alert("ERROR !  Update Fail");
                        </script>
                        <jsp:include page="doctorProfile.jsp"/>
           <%}
           
           }else if(requestType.equals("Sign Up")){
            String test = "Test SignUp if";
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String specialization = request.getParameter("specialization");
            String password = request.getParameter("password");
           
            DoctorBean doctorBean = new DoctorBean(userID, name, phone, specialization, password);
            String result = DoctorService.doctorRegister(doctorBean);
           
            if(result == "done"){ %>
                <script>
                    alert("Doctor Registration Successful");
                </script>
                <jsp:forward page = "login.jsp"/>
           
            <% }else{ %>
                <script>
                    var msg = "<%=result%>";
                    alert(msg);
                </script>
                <jsp:include page="doctorRegister.jsp"/>
            <%}
           
            }else if (requestType.equals("Change Password")){
                String userName = String.valueOf(session.getAttribute("userName"));
                String password = request.getParameter("newPassword");

                UserBean userBean = new UserBean(userName, password);
                boolean result = UserRepository.updatePassword(userBean);
                if(result){ %>
                        <script>
                            alert("Password Update Successful");
                        </script>
                        <jsp:include page = "doctorProfile.jsp"/>
           
                <% }else{ %>
                        <script>
//                            var msg = "<%=result%>";
                            alert("ERROR !  Update Fail");
                        </script>
                        <jsp:include page="doctorProfile.jsp"/>
           <%}

            }
           
           
           
       %>
    </body>
</html>
