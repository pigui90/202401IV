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
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .login-container {
                background-color: #fff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h2 {
                text-align: center;
                margin-bottom: 20px;
            }
            label {
                display: block;
                margin-bottom: 10px;
            }
            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #0056b3;
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
        <% String error = (String)session.getAttribute("error"); %>
        <h1></h1>
        
    </body>
</html>
