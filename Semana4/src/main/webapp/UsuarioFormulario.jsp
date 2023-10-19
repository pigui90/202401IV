<%-- 
    Document   : UsuarioFormulario.jsp
    Created on : 6 oct. 2023, 21:29:44
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
        <h1>HashMap Ejemplo</h1>
        <form action="UsuarioServlet" method="GET">
            <input type="hidden" name="action" value="addUser">
            Id <input type="text" name="idUsuario"><br>
            Nombre <input type="text" name="nombre"><br>
            Password <input type="text" name="password"><br>
            <input type="submit" value="Agregar Usuario">
        </form>
    </body>
</html>
