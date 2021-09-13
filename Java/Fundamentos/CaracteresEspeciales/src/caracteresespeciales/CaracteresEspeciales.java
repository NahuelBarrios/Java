/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caracteresespeciales;

import java.util.Scanner;

/**
 *
 * @author Nahu_
 */
public class CaracteresEspeciales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      /*  var nombre = "karla";
        
        System.out.println("Salto de linea: \n" + nombre);
        System.out.println("Tabulador: \t" + nombre);
        System.out.println("Retroceso: \b" + nombre);
        System.out.println("Comilla simple: '" + nombre +"'");
        System.out.println("Comilla doble: \"" + nombre + "\"");
        */
        
        System.out.println("Ingrese el titulo del libro: ");
        Scanner consola = new Scanner(System.in);
        var titulo = consola.nextLine();
        System.out.println("Ingrese el autor: ");
        var autor = consola.nextLine();
        System.out.println("El nombre del libro es: "+ titulo + " y del autor es: " + autor );
}
    
}
