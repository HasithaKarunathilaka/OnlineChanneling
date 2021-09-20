
<%@page import="repository.AppointmentRepository"%>
<%@page import="service.AppointmentService"%>
<%@page import="bean.AppointmentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
    </head>
    <body>
        <%
            String requestType = request.getParameter("button");
            
            if(requestType.equals("Make Appointment")){
//                System.out.println(requestType);
                String patientID = String.valueOf(session.getAttribute("userName"));
//                String patientID = "p1";
                String doctorID = request.getParameter("userName");
                String date = request.getParameter("date");
                
                AppointmentBean appointmentBean = new AppointmentBean(patientID, doctorID, date);
                boolean result = AppointmentService.makeAppointment(appointmentBean);
                if(result){ 
            %>
            <script>
                alert("Appointment Create Successfully");
            </script>
            <jsp:include page="patientHome.jsp"/>
        
            <%
                } else{
            %>
            <script>
                alert("You can not make the Appointment");
            </script>
            <jsp:include page="searchResult.jsp"/>
            <%
                }
            }else if(requestType.equals("Delete")){
                String patientID = String.valueOf(session.getAttribute("userName"));
//                String patientID = "p1";
                String doctorID = request.getParameter("userName");
                String date = request.getParameter("date");
                
                AppointmentBean appointmentBean = new AppointmentBean(patientID, doctorID, date);
                AppointmentRepository appointmentRepository = new AppointmentRepository();
                boolean result = appointmentRepository.deleteAppointment(appointmentBean);
                
                if(result){ 
            %>
            <script>
                alert("Appointment Delete Successfully");
            </script>
            <jsp:include page="patientAppointment.jsp"/>
        
            <%
                } else{
            %>
            <script>
                alert("ERROR !");
            </script>
            <jsp:include page="patientAppointment.jsp"/>
            <%
                } 
            }else {
        %>
            <jsp:include page="makeSchedule.jsp"/>
        <%  }
        
        %>
    </body>
</html>
