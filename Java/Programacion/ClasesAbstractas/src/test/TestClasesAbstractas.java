package test;

import domain.*;

public class TestClasesAbstractas {
    public static void main(String[] args) {
        
        //No podemos inicializar un objeto de clase Abstracta. Podemos trabajar con las clases hijas q no son de clase Abstracta
        
        FiguraGeometrica figura1 = new Rectangulo("Rectangulo"); // Se aplica UpCasting asignando una referencia de tipo hijo a tipo padre
        
        figura1.dibujar(); // Se aplica Polimorfismo de clase hija a clase padre
        
    }
    
}
