package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Suponemos que el usuario entra por primera vez al sitio por eso true
        boolean nuevoUsuario = true;

        //Obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();

        //Buscamos si ya existia la cookie con anterioridad
        //llamada visitanteRecurrente 
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {
                    //Si entra es porque ya es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        String mensaje = null;

        if (nuevoUsuario) {
            Cookie nuevoVisitante = new Cookie("visitanteRecurrente","si");
            response.addCookie(nuevoVisitante);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }
        else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.print(mensaje);
        out.close();
        
    }
}
