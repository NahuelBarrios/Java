package test;

import domain.*;

public class TestSobreescritura {
    
    public static void main(String[] args) {
        
        /*
        Gerente gerente1 = new Gerente("Nahuel",1000,"RHH");
        System.out.println("gerente1 = " + gerente1.obtenerDetalles());
        */
        //Polimorfismo: multiples comportamientos. Los metodos se tienen q llamar igual 
        
        Empleado empleado = new Empleado("Nahuel",400);
        //System.out.println("empleado = " + empleado.obtenerDetalles());
        imprimir(empleado);
        
        
        Gerente gerente = new Gerente("nahuel",2000,"Eco");
        //System.out.println("gerente = " + gerente.obtenerDetalles());
        imprimir(gerente);
        
    }
    
    public static void imprimir(Empleado empleado)
    {
        System.out.println("empleado = " + empleado.obtenerDetalles());
        
    }
            
    
    
}
