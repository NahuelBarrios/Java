
package test;


public class TestArgumentosVariables {
    
    public static void main(String[] args) { // 
        
        imprimirNumeros(1,2,3);
        imprimirNumeros(4,5);
        
        variosParametros("Nahuel",1,2,3,4);
        
    }
    
    private static void variosParametros(String nombre,int... numeros)//El argumento indefinido, siempre tiene que ir al final
    {
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
        
    }
    
    private static void imprimirNumeros(int... numeros) // Definimos que vamos a recibir una cantidad de elementos indefinidos
    {
        for (int i = 0; i < numeros.length; i++) 
        {
            System.out.println("Numero: = " + numeros[i]);
        }
        
    }
            
    
}
