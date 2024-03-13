<%-- 
    Document   : inicioSesion
    Created on : 12 mar. 2024, 18:15:39
    Author     : Sergio
--%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar sesión</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div class="login-container">
            <form action="InicioSesionServlet" class="login-form">
                <h2>Iniciar sesión</h2>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit">Ingresar</button>
            </form>
        </div>
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
