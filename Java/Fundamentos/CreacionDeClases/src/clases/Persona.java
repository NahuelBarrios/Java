/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Nahu_
 */
public class Persona {
  
    //Atributos
    String nombre;
    String apellido;
    
    //metodos
    public void desplegarInformacion()
    {
        System.out.println("nombre: "+ nombre);
        System.out.println("apellido = " + apellido);
    }
}
