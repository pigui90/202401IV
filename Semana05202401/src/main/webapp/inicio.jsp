<%-- 
    Document   : inicio
    Created on : 13 feb. 2024, 18:09:28
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
        <a href="InicioServlet">Ir a inicio</a>
        <% Boolean bandera = (Boolean) request.getAttribute("login");%>
        <% if(bandera != null && !bandera) {%>
        <h1>Inicio incorrecto</h1>
        <%}%>
    </body>
</html>
