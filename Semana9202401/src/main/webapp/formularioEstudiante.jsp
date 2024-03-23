<%-- 
    Document   : formularioEstudiante
    Created on : 19 mar. 2024, 18:16:52
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estudiantecss.css">

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
            <h1>Formulario Estudiante</h1>
            <form action="EstudianteServlet" method="POST">
                <div class="campo">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required>
                </div>
                <div class="campo">
                    <label for="edad">Edad:</label>
                    <input type="number" id="edad" name="edad" required>
                </div>
                <div class="campo">
                    <label for="fechaIngreso">Fecha de Ingreso:</label>
                    <input type="date" id="fechaIngreso" name="fechaIngreso" required>
                </div>
                <div class="campo">
                    <button type="submit" name="agregar">Agregar</button>
                </div>
            </form>
        </div>
    </body>
</html>
