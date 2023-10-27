<%-- 
    Document   : index
    Created on : 20 oct. 2023, 10:14:44
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
        <h1>Hello World!</h1>
        <%
            String nombreUsuario = (String) session.getAttribute("nombreUsuario");
        %> 
        <h2><%= nombreUsuario %></h2>
    </body>
</html>
