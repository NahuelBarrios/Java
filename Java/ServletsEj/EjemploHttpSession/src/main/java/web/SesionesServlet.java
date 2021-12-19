package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")

public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        String titulo = null;

        //pedir el atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas"); // No puedo poner el atributo en modo primitivo ya q estoy recogiendo un objeto

        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }
        else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas",contadorVisitas); // al agregarlo es como un mapeo. no se imprime en las cookies. solo se va a mostrar el id de la sesion
        
        //Mandamos la respuesta al navegador
        PrintWriter out = response.getWriter();
        out.println("Cantidad de accesos " + contadorVisitas);
        out.print("ID de la sesion: " + sesion.getId());
       
        
    }

}
