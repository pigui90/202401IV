<%-- 
    Document   : principal
    Created on : 20 feb. 2024, 18:24:02
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.Date" %>
<% String usuario = (String)session.getAttribute("usuario");%>
<%if(usuario==null){
    response.sendRedirect("inicioSesion.jsp");
}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>       
        <% Date fecha = (Date)session.getAttribute("fechaSession");%>
        <h2>Bienvenido <%=usuario %></h2>
        <h3>Fecha sesion <%=fecha %></h3>
        <a href="InicioSesionServlet?cerrarSesion=true">Cerrar Sesion</a>
    </body>
</html>
