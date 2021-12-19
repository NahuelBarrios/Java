package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")

public class CarritoServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        //Creamos u obtenemos el objeto HttpSession
        HttpSession sesion = request.getSession();
        
        //Obtenemos la lista de los articulos. 
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
     
        //Validamos la lista
        if(articulos == null)
        {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos" , articulos);
        }
        
        //Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulos"); // Obtengo el atributo del html
        
        //Agregamos el nuevo articulo
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")) // valido si es != null. con trim quito los espacios en blanco y lo comparo con espacio vacio. OSEA NO ES CADENA VACIA
        {
            articulos.add(articuloNuevo); // agrego el nuevo articulo a la lista.
            
        }
        
        
        //imprimo la lista de articulos
        PrintWriter out = response.getWriter();
        out.print("<h1>Lista de articulos</h1>");
        out.print("<br>");
        //itero los articulos
        for(String articulo: articulos)
        {
            out.print("<li>"+ articulo +"</li>");
        }
        //Link para volver al inicio
        out.print("<br>");
        out.print("<a href='/EjemploCarritoCompras'>Regreso inicio</a>");
        out.close();
    }
    
}
