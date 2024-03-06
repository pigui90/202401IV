<%-- 
    Document   : principal
    Created on : 5 mar. 2024, 18:50:38
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.List" %>
<%@page import= "cr.ac.ulatina.model.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }

            h1 {
                color: #336699;
                text-align: center;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table, th, td {
                border: 1px solid #cccccc;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            td {
                background-color: #ffffff;
            }
        </style>
    </head>
    <body>
        <% String user = (String) session.getAttribute("usuario");%>
        <h1>Hello World! <%=user %></h1>

        <h1>Lista de usuarios!</h1>
        <table>
            <tr>
                <th>NOMBRE</th><th>PASS</th>
            </tr>

            <% 
                List<Usuario> usuarios = (List) session.getAttribute("list");
                for (Usuario usuario : usuarios) {
            %>
            <tr>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getPassword() %></td>
            </tr>
            <% } %>

        </table>
    </body>
</html>
