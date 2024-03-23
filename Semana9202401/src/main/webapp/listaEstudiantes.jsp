<%-- 
    Document   : listaEstudiantes
    Created on : 12 mar. 2024, 18:17:18
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estudiantecss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css"> 
    </head>
    <body>
        <div class="cerrar-sesion">
            <a href="InicioSesionServlet?action=salir">Cerrar Sesión</a>
        </div>
        <div class="banner">
            <h1>Bienvenido a Mi Aplicación</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="listaEstudiantes.jsp">Lista de Estudiantes</a></li>
                <li><a href="#">Opción 2</a></li>
                <li><a href="#">Opción 3</a></li>
            </ul>
        </div>

        <div class="contenido-principal">
            <a href="EstudianteServlet?action=agregar" title="Agregar estudiantes"><i class="bi bi-plus-circle"></i></a>
            <h1>Lista de Estudiantes!</h1>
            
        </div>
    </body>
</html>