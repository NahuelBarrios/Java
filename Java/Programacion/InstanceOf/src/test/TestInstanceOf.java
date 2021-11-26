package test;

import domain.*;

public class TestInstanceOf {
    
    public static void main(String[] args) {

        Empleado empleado = new Empleado("Nahuel",400);  
        determinarTipo(empleado);
        Gerente gerente = new Gerente("nahuel",2000,"Eco");
        //determinarTipo(gerente);
        
    }
    
    public static void determinarTipo(Empleado empleado)
    {
        //Al validar, preguntar primero si es clase hija. y despues clase padre
        if(empleado instanceof Gerente)
        {
            System.out.println("Es de tipo Gerente");
            Gerente gerenteAux = (Gerente)empleado; // Para obtener info de la clase hija. casteamos lo q pasamos por parametro
            System.out.println("gerenteAux = " + gerenteAux.getDepartamento());
        }
        else if(empleado instanceof Empleado)
        {
            System.out.println("Es de tipo Empleado");
            System.out.println("empleado = " + empleado.getNombre());
        }
        else if(empleado instanceof Object)
        {
            System.out.println("Es de tipo object");
        }
        
    }
            
    
    
}
