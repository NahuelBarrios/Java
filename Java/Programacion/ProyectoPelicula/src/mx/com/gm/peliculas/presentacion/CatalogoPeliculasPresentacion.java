package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocioC.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        
        int opcion = -1;
        var scanner = new Scanner(System.in);// Le pasamos la consola de entrada. Le solicitamos lo que tipea el usuario
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();// Utilizamos bajo acoplamiento.
        
        while(opcion != 0)
        {
            System.out.println("*******Bienvenidos********\n1.Iniciar Catalogo\n2.Agregar Pelicula\n3Listar Peliculas\n4.Buscar Pelicula\n0.Salir.\n**************************\nIngrese una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion)
            {
                case 1: 
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce la pelicula a buscar4");
                    var buscarNombrePelicula = scanner.nextLine();
                    catalogo.buscarPelicula(buscarNombrePelicula);
                case 0:
                    break;
                default:
                    System.out.println("Ingrese el numero bien");
            }
        
        }
        
    }
    
}
