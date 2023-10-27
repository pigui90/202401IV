<%-- 
    Document   : UsuarioLista
    Created on : 13 oct. 2023, 10:55:08
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import= "model.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Lista de usuarios!</h1>
        <table>
            <tr>
                <th>ID</th><th>NOMBRE</th><th>PASS</th><th>Eliminar</th>
            </tr>

            <% 
                List<Usuario> listaEjemplo = (List<Usuario>) request.getAttribute("usuarios");
                for (Usuario elemento : listaEjemplo) {
            %>
            <tr>
                <td><%= elemento.getId() %></td>
                <td><%= elemento.getNombreUsuario() %></td>
                <td><%= elemento.getPassword() %></td>
                <td><a href="UsuarioServlet?action=eliminar&id=<%= elemento.getId() %>">Eliminar</a></td>
            </tr>
            <% } %>

        </table>
        <a href="UsuarioFormulario.jsp">Volver al formulario</a>
    </body>
</html>
