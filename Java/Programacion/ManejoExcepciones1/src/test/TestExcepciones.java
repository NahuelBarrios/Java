package test;

import aritmetica.Aritmetica;

public class TestExcepciones {

    public static void main(String[] args) {
        
        int resultado = 0;
        
        try{
            resultado = Aritmetica.division(10, 0);
        }catch(Exception e){
            //e.printStackTrace(System.out); // Imprime la pila de excepciones. Todo 
            System.out.println(e.getMessage()); // Imprime solo la excepion con la informacion que le quiero mostrar al usurio.
        }
        finally{//Cierra recursos
            System.out.println("Se reviso la divion entre 0");
        }
        System.out.println("resultado = " + resultado);
        
    }
    
}
