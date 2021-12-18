package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        //Simulando los valores correctos
        String nombreOk = "Nahuel";
        String passwordOk = "123";
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if(usuario.equals(nombreOk) && password.equals(passwordOk))
        {
            out.print("<html>");
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br><br>");
            out.print("Usuario: " + usuario);
            out.print("<br><br>");
            out.print("Password" + password);
            out.print("</h1>");
            out.print("</html>");
        }
        else{
            response.sendError(response.SC_UNAUTHORIZED,"No estas autorizado");
        }
        out.close();
    }
    
}
