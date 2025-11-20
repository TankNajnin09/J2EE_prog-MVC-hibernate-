<%-- 
    Document   : welcome
    Created on : Oct 8, 2025, 7:52:56 PM
    Author     : TANK1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "demo_pack.my_class" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello JSP!!</h1>
        <%
            my_class obj=(my_class)request.getAttribute("req_obj");
            out.print("<h2>Welcome " + obj.getName()+"<h2>");
        %>
        
    </body>
</html>
