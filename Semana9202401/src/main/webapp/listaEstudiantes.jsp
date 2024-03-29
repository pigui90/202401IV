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
            <a href="EstudianteServlet?action=agregar" title="Agregar estudiantes"><i class="bi bi-plus-circle"></i></a>
            <h1>Lista de Estudiantes!</h1>
            <table>
                <tr>
                    <th>ID</th><th>NOMBRE</th><th>EDAD</th><th>FECHA INGRESO</th><th>Acciones</th>
                </tr>

                <% 
                    String rol = (String) session.getAttribute("rol");
                    List<Estudiante> listaEstudiantes = (List<Estudiante>) session.getAttribute("listaEstudiantes");
                    for (Estudiante estudiante : listaEstudiantes) {
                %>
                <tr>
                    <td><%= estudiante.getId() %></td>
                    <td><%= estudiante.getNombre() %></td>
                    <td><%= estudiante.getEdad() %></td>
                    <td><%= estudiante.getFechaIngreso() %></td>
                    <td>
                        <a href="EstudianteServlet?action=view&id=<%= estudiante.getId() %> " title="Vista"><i class="bi bi-binoculars"></i></i></i></a>
                        <% if(rol.equals("A")){%> <a href="EstudianteServlet?action=editar&id=<%= estudiante.getId() %> " title="Editar"><i class="bi bi-pencil"></i></i></a><% }%>
                        <% if(rol.equals("A")){%><a href="EstudianteServlet?action=eliminar&id=<%= estudiante.getId() %> " title="Eliminar"><i class="bi bi-trash3"></i></a><% }%>
                    </td>
                </tr>

                <% }
                Boolean borrado = (Boolean)request.getAttribute("borrado");
                if(borrado != null && borrado){%>
                <h3>Registro eliminado</h3>
                <%}%>

            </table>
        </div>
    </body>
</html>

<% }else{
%>
<h4>    DEBE INICIAR SESION </h4>
<% }%>