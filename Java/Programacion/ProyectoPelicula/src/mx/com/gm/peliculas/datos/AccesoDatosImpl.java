package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();// Retorno si existe el archivo o no
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {

        File archivo = new File(nombreArchivo); // Inicializo un archivo con el contenido del file pasado por parametro

        List<Pelicula> listaPeliculas = new ArrayList<>(); // inicializo una lista de la clase Pelicula
        try {
            var entrada = new BufferedReader(new FileReader(archivo)); // Leo la linea completa del archivo
            String linea = null; // Inicializo una variable 
            linea = entrada.readLine(); // y la cargo con el valor que tiene entrada
            while (linea != null) // Itero un while hasta que el valor linea sea == a null
            {
                var peliculaAux = new Pelicula(linea); // Creo una variable auxiliar en la que inicializo un Objeto con el atributo de pelicula
                listaPeliculas.add(peliculaAux); // Agrego el objeto a la lista
                linea = entrada.readLine(); // Leo la proxima linea para seguir iterando
            }
            entrada.close(); // Cierro el archivo "entrada" 

        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Error de excepcion en listar" + ex.getMessage()); //Utilizo mi excepcion propia. arribo pongo el getStackTrace
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Error de excepcion en listar" + ex.getMessage());
        }

        return listaPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        
        File archivo = new File(nombreArchivo);
        
        try { 
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar)); // Aca lo que hago es imprimir. Si el anexar es true. se escribe correctamente en el archivo
            salida.println(pelicula.toString());// Imprime el tipo pelicula
            salida.close();//Cierro el flujo del archivo
            System.out.println("Se ha escrito la informacion correctamente. :" + pelicula);
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new EscrituraDatosEx("Error de excepcion de escritura"  + ex.getMessage());
        }
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo)); // Leo la linea completa del archivo
            String linea = null; // Inicializo una linea donde voy a depositas la primer linea leida
            linea = entrada.readLine(); // La asigno
            int indice = 1;
            while(linea != null)
            {
                if(buscar != null && buscar.equalsIgnoreCase(linea)) // Valido si buscar es != Null y si es igual a la linea de texto leida. 
                {
                    resultado = "Pelicula: "+ linea + ", en la poscion: " + indice; // Le asigno el nombre de la pelicula y la posicion donde se encuentra
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close(); // Cierro el flujo
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Error de excepcion en buscar"  + ex.getMessage());
        } catch (IOException ex) {
            ex.getStackTrace();
            throw new LecturaDatosEx("Error de excepcion en buscar"  + ex.getMessage());
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creo el archivo exitosamente");
        }catch (IOException ex) {
            ex.getStackTrace();
            throw new AccesoDatosEx("Error de excepcion en crear"  + ex.getMessage());
        }
    
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        
        File archivo = new File(nombreArchivo);
        
        if(archivo.exists())
        {
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
        
        
    }

}
