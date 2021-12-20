<!DOCTYPE html>
<%
    String fondo = request.getParameter("colorFondo");
    if(fondo != null && fondo.trim().equals(""))
    {
        fondo = "white";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cambio de color</title>
    </head>
    <body bgcolor="<%=fondo%>">
        <h1>JSP Cambio de color</h1>
        <br>
        color ingresado: <%=fondo%> 
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
