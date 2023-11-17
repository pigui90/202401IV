<%-- 
    Document   : bienvenida
    Created on : 8 nov. 2023, 17:24:59
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bienvenidacss.css">
    </head>
    <body>
        <div class="cerrar-sesion">
            <a href="LoginServlet?action=salir">Cerrar Sesión</a>
        </div>
        <div class="banner">
            <h1>Bienvenido a Mi Aplicación</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="EstudianteServlet">Lista de Estudiantes</a></li>
                <li><a href="#">Opción 2</a></li>
                <li><a href="#">Opción 3</a></li>
            </ul>
        </div>

        <div class="contenido-principal">
            <h1>Título del Contenido</h1>
            <p>Este es un párrafo de ejemplo dentro del contenido principal.</p>
            <p>Otro párrafo aquí.</p>
        </div>
    </body>
</html>
