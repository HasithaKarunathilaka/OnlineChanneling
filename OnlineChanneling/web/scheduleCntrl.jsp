
<%@page import="repository.ScheduleRepository"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="service.DoctorService"%>
<%@page import="bean.ScheduleBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <%
           
            String requestType = request.getParameter("button");
//            System.out.println(requestType);
            
            if(requestType.equals("Make Schedule")){
//                System.out.println(requestType);
                String userName = String.valueOf(session.getAttribute("userName"));
//                String userName = "d1";
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                int noOfPatient = Integer.parseInt(request.getParameter("totalPatients"));
                
                ScheduleBean scheduleBean = new ScheduleBean(userName, date, time, noOfPatient);
                boolean result = DoctorService.makeSchedule(scheduleBean);
                if(result){ 
            %>
            <script>
                alert("Schedule Create Successfully");
            </script>
            <jsp:include page="doctorHome.jsp"/>
        
            <%
                } else{
            %>
            <script>
                alert("ERROR !  You only can make One Schedule per Day");
            </script>
            <jsp:include page="makeSchedule.jsp"/>
            <%
                }
            }else if(requestType.equals("Update")){
                String userName = String.valueOf(session.getAttribute("userName"));
//                String userName = "d1";
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                int noOfPatient = Integer.parseInt(request.getParameter("scheduledPatients"));

                ScheduleBean scheduleBean = new ScheduleBean(userName, date, time, noOfPatient);
                boolean result = ScheduleRepository.updateSchedule(scheduleBean);
                if(result){ 
            %>
            <script>
                alert("Schedule Update Successfully");
            </script>
            <jsp:include page="doctorHome.jsp"/>
        
            <%
                } else{
            %>
            <script>
                alert("ERROR !");
            </script>
            <jsp:include page="updateSchedule.jsp"/>
            <%
                }
            }else if(requestType.equals("Delete")){
//                System.out.println("D1");
                String userName = String.valueOf(session.getAttribute("userName"));
//                String userName = "d1";
                String date = request.getParameter("date");
                System.out.println(date);
                ScheduleBean scheduleBean = new ScheduleBean(userName, date, "", 0);
                boolean result = DoctorService.deleteSchedule(scheduleBean);
                
                if(result){ 
            %>
            <script>
                alert("Schedule Delete Successfully");
            </script>
            <jsp:include page="doctorHome.jsp"/>
        
            <%
                } else{
            %>
            <script>
                alert("ERROR !");
            </script>
            <jsp:include page="updateSchedule.jsp"/>
            <%
                } 
            }else {
        %>
            <jsp:include page="makeSchedule.jsp"/>
        <%  }
        
        %>
        
    </body>
</html>
