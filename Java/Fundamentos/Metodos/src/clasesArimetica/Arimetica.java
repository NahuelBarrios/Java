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
