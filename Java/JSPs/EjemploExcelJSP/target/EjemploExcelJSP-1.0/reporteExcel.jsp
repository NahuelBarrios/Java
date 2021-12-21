<%@page import="utileria.Conversiones, java.util.Date" %> <%-- Importo las clases que voy a usar --%>
<%@page contentType="application/vnd.ms-excel" %> <%-- Aclaro que el tipo de documento JSP es excel  --%>


<%-- Indicamos que vamos a descargar un archivo de excel con el nombre reporte.xls --%>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo); 
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de excel</title>
    </head>
    <body>
        <h1>Reporte de excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos java</td>
                <td>Aprendemos la sintaxis basica de java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2. Programacion con java</td>
                <td>Ponemos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
