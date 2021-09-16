
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nahu_
 */
public class main {
    public static void main(String[] args)
    {
        Scanner consola = new Scanner (System.in);
        boolean envio;
        System.out.println("Ingrese su nombre:");
        var nombre = consola.nextLine();
        System.out.println("Ingrese su id:");
        var id = Integer.parseInt(consola.nextLine());
        System.out.println("Ingrese su precio:");
        var precio = Double.parseDouble(consola.nextLine());
        
        if(precio >= 100)
            envio = true;
        else
            envio=false;
        
        System.out.println("nombre libro: " + nombre);
        System.out.println("Id libro: " + id);
        System.out.println("precio libro: " + precio);
        if(envio)
            System.out.println("Envio: gratis ");
            else
            System.out.println("Envio: a cobro ");
    }
    
}
