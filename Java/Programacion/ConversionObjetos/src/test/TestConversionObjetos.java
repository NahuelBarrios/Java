package test;
import domain.*;

public class TestConversionObjetos {
 
    public static void main(String[] args) {
        
        Empleado empleado;
        
        empleado = new Escritor("Nahuel",4000,TipoEscritura.CLASICO); // Se puede asignar referencia de objetos de clases hijas a tipos de clase padre
       
    
        //down casting. Convertir de la clase padre, a la hija
        Escritor escritorAux = (Escritor) empleado;
        escritorAux.getEscritura();
        
        //Up casting- No hace falta hacer un casteo explicito. El compilador lo hace por si solo
        
        Empleado empleado2 = escritorAux;
       
         System.out.println("empleado = " + empleado2.obtenerDetalles());
    }
}
