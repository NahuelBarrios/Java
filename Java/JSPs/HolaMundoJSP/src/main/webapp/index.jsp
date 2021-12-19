<%-- 
    Document   : index
    Created on : 19 dic. 2021, 19:37:29
    Author     : 54115
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Mundo JSP</title>
    </head>
    <body>
        <h1>Hola Mundo JSP</h1>
        <ul>
            <li> <% out.print("Hola Mundo con ScriptLets");%> </li>
            <li> ${"HolaMundo con Expression Language(EL)"} </li>
            <li><%= "HolaMundo con expresiones" %></li>
            <li><c:out value="HolaMundo con JSTL"/></li>
        </ul>
    </body>
</html>
