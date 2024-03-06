<%-- 
    Document   : principal
    Created on : 5 mar. 2024, 18:50:38
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String password = (String) request.getAttribute("password");%>
        <h1>Hello World! <%=password %></h1>
    </body>
</html>
