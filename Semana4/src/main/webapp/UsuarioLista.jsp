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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de usuarios!</h1>
        <ul>
            <% 
                List<Usuario> listaEjemplo = (List<Usuario>) request.getAttribute("usuarios");
                for (Usuario elemento : listaEjemplo) {
            %>
            <li><%= elemento %></li>
                <% } %>
        </ul>
    </body>
</html>
