<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores de JavaBeans</title>
    </head>
    <body>
        <h1>JSP que lee los valores de JavaBeans</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/>
        Valor Base: <jsp:getProperty name="rectangulo" property="base"/>
        <br/>
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura"/>
        <br/>
        <%-- Va a detectar el get area sin tener el atributo. ya que lo que hace incapie es en el nombre del metodo --%>
        Valor total del Area: <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <br/>
        <a href="index.jsp">Link al inicio</a>
    </body>
</html>
