<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (Jsp  Standard Tag Library)</h1>
        <!-- Manipulacion de variables -->
        <!-- Definimos la variable -->
        <c:set var="nombre" value="Ernesto"/>
        <!-- Desplegamos el valor de la variable -->
        Variable nombre: <c:out value="${nombre}"/>
        <br/>
        <br/>
        <!-- Si ponemos el escapeXml en false, se imprime el h4, si esta en true, se muestra como texto normal -->
        Variable con codigo HTML: <c:out value="<h4>Hola<h4>" escapeXml="false"/>
        <br/>
        <br/>
        <!-- Codigo condicionado, uso de if -->
        <c:set var="bandera" value="true"/>

        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br/>
        <!-- Codigo condicionado, uso de switch -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opcion seleccionada: 1
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <br/>
                    Opcion seleccionada: 2
                </c:when>
                <c:otherwise>
                    <br/>
                    Seleccione una opcion correcta.
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Itetacion de un arreglo -->
        <%
            String nombres[] = {"Nahuel","Maria","Candelaria"};
            request.setAttribute("nombresArreglo",nombres);
        %>
        <br/>
        Lista de nombres: 
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombresArreglo}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
       <br/>
       <br/>
       <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
