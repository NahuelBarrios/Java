package test;

import dominio.Persona;

public class PersonaPrueba 
{
    public static void main(String[] args) {
        
        Persona persona1 = new Persona("Nahuel",2000,true);
        Persona persona2= new Persona("Juan",3000,false);
        
        System.out.println("persona1: " +persona1.toString());
        System.out.println("persona2: " +persona2.toString());
        
        
    }
    
    
}
