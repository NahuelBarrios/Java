<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de variables</title>
    </head>
    <body>
        <h1>Despliegue de variables</h1>
        Variable en alcance Request: ${mensaje}
        <br/>
        <br/>
        Variable en alcance sesion: 
        <br/>
        Valor de la base: ${rectangulo.base}
        <br/>
        Valor de la altura: ${rectangulo.altura}
        <br/>
        Valor del area: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
    </body>
</html>
