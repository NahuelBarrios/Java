package test;

import domain.Empleado;

public class TestClaseObject {
    
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Nahuel",400);
        Empleado empleado2 = new Empleado("Nahuel",400);
        
        if(empleado1.equals(empleado2))
        {
            System.out.println("Tienen el mismo contenido");
        }
        else{
            System.out.println("No tienen el mismo contenido");
        }
        
        if(empleado1.hashCode() == empleado2.hashCode())
        {
            System.out.println("El valor hashCoded es el mismo");
        }
        else
        {
            System.out.println("El valor hashCoded NO es el mismo");
        }
        
    }
}
