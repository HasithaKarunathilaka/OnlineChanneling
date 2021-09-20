
<%@page import="repository.UserRepository"%>
<%@page import="bean.UserBean"%>
<%@page import="repository.PatientRepository"%>
<%@page import="service.PatientService"%>
<%@page import="bean.PatientBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <%
            String requestType = request.getParameter("button");
            if(requestType.equals("Sign Up")){
                String userName = request.getParameter("userName");
                String name = request.getParameter("name");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String password = request.getParameter("password");
                
                PatientBean patientBean = new PatientBean(userName, name, phone, password);
                boolean result = PatientService.registerPatient(patientBean);
                
                if(result){
                    %>
                    <script>
                        alert("Patient Registration Successfully");
                    </script>
                    <jsp:include page="index.jsp"/>
                    <%
                } else {
                    %>
                    <script>
                        alert("ERROR !   Patient Registration Fail");
                    </script>
                    <jsp:include page="patientRegister.jsp"/>
                    <%
                }
            
            }else if(requestType.equals("Update")){
                String userName = request.getParameter("userName");
                String name = request.getParameter("name");
                int phone = Integer.parseInt(request.getParameter("phone"));

                PatientBean patientBean = new PatientBean(userName, name, phone, "");
                boolean result = PatientRepository.updatePatientDetails(patientBean);
                if(result){ %>
                    <script>
                        alert("Details Update Successful");
                    </script>
                    <jsp:include page = "patientProfile.jsp"/>
           
                <% }else{ %>
                    <script>
//                      var msg = "<%=result%>";
                        alert("ERROR !  Update Fail");
                    </script>
                    <jsp:include page="patientProfile.jsp"/>
                <%}

            }else if(requestType.equals("Change Password")){
                String userName = String.valueOf(session.getAttribute("userName"));
                String password = request.getParameter("newPassword");

                UserBean userBean = new UserBean(userName, password);
                boolean result = UserRepository.updatePassword(userBean);
                if(result){ %>
                    <script>
                        alert("Password Update Successful");
                    </script>
                    <jsp:include page = "patientProfile.jsp"/>
                <%}else{ %>
                    <script>
//                      var msg = "<%=result%>";
                        alert("ERROR !  Update Fail");
                    </script>
                    <jsp:include page="patientProfile.jsp"/>
                <% }
            }
        %>
    </body>
</html>
