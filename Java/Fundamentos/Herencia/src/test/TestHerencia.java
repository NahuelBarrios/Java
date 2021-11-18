
package test;

import domain.Empleado;
import domain.Cliente;
import java.util.Date;

public class TestHerencia {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Nahuel",500.0);
        System.out.println("empleado1 = " + empleado1);
        
        Cliente cliente1 = new Cliente(new Date(),true,"Nahuel",'M',21,"Dr Kellertas 2837");
        System.out.println("cliente1 = " + cliente1);
        
    }
}
