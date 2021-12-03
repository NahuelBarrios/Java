package mx.com.gm.peliculas.negocioC;

import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    //Atributos
    private final IAccesoDatos datos;

    //Constructor
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl(); // Inicializo un objeto de tipo AccesoDatosImpl en el atributo datos. Para poder utilizar los metodos de AccesoDatos.
    }

    //Implements
    @Override
    public void agregarPelicula(String nombrePelicula) {

        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;

        try {
            anexar = this.datos.existe(NOMBRE_RECURSO); // Pregunto si existe el archivo. existe devuelve un tipo boolean
            this.datos.escribir(pelicula, NOMBRE_RECURSO, anexar); // Agrego la pelicula llamando al metodo escribir
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar pelicula");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {

        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO); // llamo al metodo listar y lo asigno a peliculas
            for (var peliculaAux : peliculas) // Recorro peliculas
            {
                System.out.println("Pelicula: " + peliculaAux);  // muestro el contenido de peliculas
            }

        } catch (LecturaDatosEx ex) {
            System.out.println("Error al listar pelicula");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar); // asigno los atributos a buscar
           
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al buscar pelicula");
            ex.printStackTrace(System.out);
        }
        
        System.out.println("peliculas = " + resultado); // Imprimo el resultado de la busqueda
    }

    @Override
    public void iniciarArchivo() {
        
        try {
            if(this.datos.existe(NOMBRE_RECURSO)) // Si el archivo existe. (Osea devuelve true)
            {
                this.datos.borrar(NOMBRE_RECURSO); // Borro el archivo y lo creo de nuevo
                this.datos.crear(NOMBRE_RECURSO);
            }
            else{
                this.datos.crear(NOMBRE_RECURSO); // Lo creo directamente
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al crear archivo");
            ex.printStackTrace(System.out);
        }
        
    }

}
