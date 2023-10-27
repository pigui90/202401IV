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
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <title>Usuarios</title>

    </head>
    <body>
        <h1>Formulario Usuarios</h1>
        <form action="UsuarioServlet" method="GET">
            <input type="hidden" name="action" value="addUser">
            <label for="idUsuario">Id:</label> <input type="text" name="idUsuario"><br>
            <label for="nombre">Nombre:</label> <input type="text" name="nombre"><br>
            <label for="password">Password:</label> <input type="text" name="password"><br>
            <input type="submit" value="Agregar Usuario">
        </form>
    </body>
</html>
