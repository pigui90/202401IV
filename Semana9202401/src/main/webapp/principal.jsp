<%-- 
    Document   : listaEstudiantes
    Created on : 12 mar. 2024, 18:17:18
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import= "cr.ac.ulatina.semana9202401.model.Estudiante" %>
<%@ page import= "cr.ac.ulatina.semana9202401.model.Usuario" %>

<% Usuario user = (Usuario) session.getAttribute("user");
if(user!=null){
%>
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
            <a href="EstudianteServlet?list=list" title="Lista Estudiantes">Lista Estudiantes</a>
                <li><a href="#">Opción 2</a></li>
                <li><a href="#">Opción 3</a></li>
            </ul>
        </div>

        <div class="contenido-principal">
            
               
            <h1>Bienvenido a mi sistema</h1> 
               
          
        </div>
    </body>
</html>

<% }else{
%>
<h4>    DEBE INICIAR SESION </h4>
<% }%>