<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC 2</title>
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br/>
        <div style="color:red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet controlador sin parametros
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Link al Servlet controlador para agregar variables
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al Servlet controlador para listar variables
        </a>
    </body>
</html>
