<%-- 
    Document   : inicioSesion
    Created on : 20 feb. 2024, 18:08:28
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
        <style>
            h2 {
                color: #333; /* Color del texto de los encabezados */
            }

            label {
                display: block; /* Mostrar cada etiqueta en una línea separada */
                margin-bottom: 5px; /* Espacio entre etiquetas */
            }

            input[type="text"],
            input[type="password"],
            input[type="submit"] {
                margin-bottom: 10px; /* Espacio entre campos de entrada y botones */
            }

            .exito {
                color: blue; /* Color del mensaje de éxito */
            }

            .error {
                color: red; /* Color del mensaje de error */
            }
        </style>
    </head>
    <body>
        <h2>Iniciar sesión</h2>
        <form action="InicioSesionServlet" method="post">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username"><br><br>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password"><br><br>
            <input type="submit" name="inicioSesion" value="Iniciar sesión">
            <input type="submit" name="registrarse" value="Registrarse">
        </form>
        <% Boolean exito = (Boolean)session.getAttribute("exito"); %>
        <%if(exito != null && exito){%>
        <h2  class="exito">Registro con exito! </h2>
        <%}%>
        <% Boolean error = (Boolean)session.getAttribute("error"); %>
        <%if(error != null && error){%>
        <h2  class="error">Usuario/Contraseña incorrecta! </h2>
        <%}%>

    </body>
</html>
