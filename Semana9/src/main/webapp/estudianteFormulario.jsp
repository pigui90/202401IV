<%-- 
    Document   : bienvenida
    Created on : 8 nov. 2023, 17:24:59
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import= "cr.ac.ulatina.semana9.model.Estudiante" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estudiantecss.css">
    </head>
    <body>
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
        <div class="cerrar-sesion">
            <a href="LoginServlet?action=salir">Cerrar Sesión</a>
        </div>
        <div class="contenido-principal">
            <h1>Mantenimiento de Estudiantes</h1>

            <form action="EstudianteServlet" method="post">
                <input type="hidden" name="action" value="ingresar">

                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre">

                <label for="edad">Edad:</label>
                <input type="number" id="edad" name="edad">

                <label for="fechaIngreso">Fecha de Ingreso:</label>
                <input type="date" id="fechaIngreso" name="fechaIngreso" required>

                <button type="submit" >Guardar</button>     
            </form>
        </div>
    </body>
</html>
