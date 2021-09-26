/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesArimetica;

/**
 *
 * @author Nahu_
 */
public class Arimetica {
    
    // Siempre usar this para los atributos y metodos de la clase.
    
    // Atributos de la clase 
    int a;
    int b;
    
    //Constructores. Si tengo que hacer un constructor con pase de argumentos.. si o si tengo que inicializar el vacio perreke
    public Arimetica()
    {
        //Cuando se llama el constructor lo que hace es hacer un espacio en la memoria
        System.out.println("Se esta ejecutando");
    }
    
    public Arimetica(int a, int b)
    {
        this.a= a;
        this.b = b;
         System.out.println("Se esta ejecutando el constructor con argumentos");     
    }
    
    
    // Metodos
    
    public void sumar()
    {
        System.out.println("Resultado es:  = " +(this.a+this.b));
    }
    
      public int sumarConRetorno()
    {
        return this.a + this.b;
    }
    
    public int sumarConRetornoYArgumentos(int a,int b)
    {
        this.a = a;
        this.b = b;
        
        return this.sumarConRetorno();
    }
    
}
