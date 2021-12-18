package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletContadorCookies")
public class CookieContador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Contador. No se puede usar var. F
        int contador = 0;

        //Revisamos si existe la cookie contadorVisitas
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if(c.getName().equals("contadorVisitas"))
                {
                    contador = Integer.parseInt(c.getValue()); // Obtengo el valor de la cookie, la parseo y la almaceno en contador
                } 
            }
        }
        
        //Incrementamos el contador en 1
        contador++;
        //Respuesta al navegador
        Cookie c = new Cookie("contadorVisitas",Integer.toString(contador)); // parseo el valor de contador y lo cargo en la cookie
        //Almaceno la cookie por 1 hs. 3600s
        c.setMaxAge(3600);
        response.addCookie(c);
        
        //Mandamos msj al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("La pagina fue visitada un total de: " + contador);
        
    }

}
