package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/GeneracionExcelServlet")
public class SevletExcel extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        //Tipo de respuesta del navegador
        response.setContentType("application/vnd.ms-excel");//Indico que es un archivo excel
        response.setHeader("Content-Disposition","attachment;filename=excelEjemplo.xls");//Descarga el documento
        //Para un uso mas profesional del excel usar el import: poi.apache.org
        
        //Que el navegador no guarde cache. con el conjunto de estos 3 headers, el cache no se guarda.
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", -1);
        
        //Despliego la info al cliente
        PrintWriter out = response.getWriter();
        
        out.println("\tValores"); // Al usar el tab. se salta la columna.
        out.println("\t1");
        out.println("\t2");
        out.println("Resultado\t=SUMA(b2:b3)");
        out.close();
        
        
        
    }
    
}
