<%-- 
    Document   : login
    Created on : 20 oct. 2023, 10:17:39
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <div class="login-container">
            <form class="login-form" action="LoginServlet" method="post">
                <h2>Iniciar Sesión</h2>
                <div class="form-group">
                    <label for="email">Usuario:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div style="padding-bottom: 5px">
                    <button type="submit" id="inicio" name="inicio">Iniciar Sesión</button>
                </div>
                <div>
                    <button type="submit" id="register" name="register">Registrar</button>
                </div>
                <div>
                    <button type="submit" id="webService" name="webService">WebService</button>
                </div>
            </form>

            <div>
                <% 
                Boolean flagRegistro = (Boolean)session.getAttribute("registro");
                if(flagRegistro != null && flagRegistro){
                %><h2>Registro con éxito</h2>
                <%
                }
                %>
            </div>
            <div>
                <% 
                Boolean flagInicioSesion = (Boolean)request.getAttribute("inicioSesion");
                if(flagInicioSesion != null && !flagInicioSesion){
                %><h2>Usuario/Contraseña incorrecto</h2>
                <%
                }
                %>
            </div>
            <div>
                <% 
                String salida = (String)request.getAttribute("salida");
                if(salida != null && !salida.isEmpty()){
                %><h2><%=salida%></h2>
                <%
                }
                %>
            </div>
        </div>
    </body>
</html>
