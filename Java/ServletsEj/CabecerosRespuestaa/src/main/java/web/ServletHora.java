package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/VerHoraActual")
public class ServletHora extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh", "1"); // Digo q la pagina se refresque cada 1 segundo
        
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada:' HH:mm:ss");//Con simpleDateFormat podemos darle muchos formatos a la hora
        String horaConFormato = formateador.format(fecha);
        PrintWriter out = response.getWriter();
        out.print(horaConFormato);
        out.close();
    }
}
