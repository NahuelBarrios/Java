package test;

import domain.Gerente;

public class TestSobreescritura {
    
    public static void main(String[] args) {
        
        Gerente gerente1 = new Gerente("Nahuel",1000,"RHH");
        
        System.out.println("gerente1 = " + gerente1.obtenerDetalles());
        
        
    }
    
}