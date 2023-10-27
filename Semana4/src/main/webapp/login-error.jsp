<%-- 
    Document   : login-error
    Created on : 20 oct. 2023, 10:20:56
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error error login</h1>
        <%
            String userError = (String) request.getAttribute("userError");
            if(userError!=null && !userError.equals("")){
        %>
        <h1>El usuario <%= userError %> no existe o la contraseña es incorrecta</h1>
        <%
        }
        %>

        <% 
        String nombreAtributo = (String) session.getAttribute("userErrorSession");
        if(nombreAtributo!=null && !nombreAtributo.equals("")){
        %>
        <h1>El usuario con el sesion <%= nombreAtributo %> no existe o la contraseña es incorrecta</h1>
        <%
        }
        %>
    </body>
</html>
