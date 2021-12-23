package controlador;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1- Procesamos parametros
        String accion = request.getParameter("accion");
        
        // 2- Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSesion = new Rectangulo(3,4);
        Rectangulo recAplicacion = new Rectangulo(5,6);
        // 3- Agregamos el JavaBean a algun alcance
        
        //Revisamos la informacion proporcionada
        if("agregaVariables".equals(accion))
        {
            //Alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance Sesion
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion",recSesion);
            
            //Alcance Aplicacion
            ServletContext aplicacion = this.getServletContext();
            aplicacion.setAttribute("rectanguloAplicacion",recAplicacion);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje","Las variables fueron agregadas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if("listarVariables".equals(accion))
        {
            // 4- redireccionamos al jsp que despliega variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }
        else
        {
            // 4- redireccionamos al inicio
            request.setAttribute("mensaje","Accion no proporcionada");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Esta linea no agregaria informacion al JSP
            // Ya que no propaga los objetos Request y response
            //response.sendRedirect("index.jsp");
        }
    }
}
