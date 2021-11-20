
package test;

import domain.Persona;

public class TestMatrices {
    
    public static void main(String[] args) {
        int edades[][] = new int [3][2]; //[Renglones][Columnas]
    
        edades[0][0] = 10;
        edades[0][1] = 20;
        edades[1][0] = 30;
        edades[1][1] = 40;
        
        for (int i = 0; i < edades.length; i++) {
            for (int j = 0; j < edades[i].length; j++) {
                System.out.println("edades["+i+"]["+j+"]=" + edades[i][j] );
            }
            
        }
    
        
        Persona personas[][] = new Persona[2][3];
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Nahuel");
        
        
    }
    
}
