
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <%
            if (session != null){
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
        
        %>
    </body>
</html>
