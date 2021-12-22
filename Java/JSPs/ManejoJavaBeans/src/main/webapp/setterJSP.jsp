<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP QUE MODIFICA UN JAVABEAN</title>
    </head>
    <body>
        <h1>JSP QUE MODIFICA UN JAVABEAN</h1>
        <br/>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        Modificamos los atributos:
        <br/>
        <br/>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%= baseValor %>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%= alturaValor %>"/>
        <br/>
        Nuevo Valor de la Base: <%= baseValor %>
        <br/>
        Nuevo Valor de la Altura: <%= alturaValor %>
        <br/>
        <br/>
        <a href="index.jsp">Link al inicio</a>
    </body>
</html>
