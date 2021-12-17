package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ServletHeader")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException // usar gets Para links
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String metodoHttp = request.getMethod();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<tittle>Headers HTTP</tittle>");
        out.print("</head>");
        out.print("<body>");
        out.print("<br>");
        out.print("<h1>Headers HTTP!</h1>");
        out.print("<br>");
        out.print("Metodos http: " + metodoHttp);
        out.print("<br>");
        String uri = request.getRequestURI();
        out.print("Uri: " + uri);
        out.print("<br>");
        //Imprimir todos los cabeceros
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements())//Si hay mas elementos
        {
            String nombreCabeceros =(String) cabeceros.nextElement();
            out.print("<b>" + nombreCabeceros +"</b>: "); // Nombre del cabecero
            out.print(request.getHeader(nombreCabeceros)); // Valor de cada cabecero
            out.print("<br>");
        }
        out.print("</body>");
        out.print("</html>");
        out.close();
    } 
    
}
