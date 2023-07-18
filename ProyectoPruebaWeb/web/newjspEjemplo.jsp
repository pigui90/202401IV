<%-- 
    Document   : newjspEjemplo
    Created on : 17 jul. 2023, 14:52:07
    Author     : Sergio
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mi primera pagina</h1>
        Hoy es: 
        <% 
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
            String hoy = simpleDateFormat.format(new Date());
        %>
        <%=hoy%>
        El parametro es:  
        <%=request.getParameter("id")%>
    </body>
</html>
