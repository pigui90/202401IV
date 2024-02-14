<%-- 
    Document   : bienvenida
    Created on : 13 feb. 2024, 18:17:03
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
        <% String nombre = (String) request.getAttribute("user");%>
        <h1>Bienvenida!</h1>
        
        <h1>Bienvenido: <%=nombre %></h1>
        <a href="inicio.jsp">Salir</a>
    </body>
</html>
