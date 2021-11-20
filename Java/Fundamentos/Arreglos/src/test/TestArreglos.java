
package test;


public class TestArreglos {
        // TIPOS PRIMITIVOS
    public static void main(String[] args) {
        int edades[] = new int[3];
        System.out.println("edades = " + edades);
        
        edades[0] =10;
        edades[1] =20;
        edades[2] =30;
        
        for(int i=0;i<edades.length;i++)
        {
            System.out.println("edades["+i+"] ="+edades[i]);
        }
    }
    
}
