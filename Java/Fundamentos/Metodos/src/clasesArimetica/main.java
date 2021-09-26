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
public class main {
  
    public static void main(String[] args) {
          
        Arimetica arimetica1 = new Arimetica();
        arimetica1.a = 3;
        arimetica1.b = 4;
        arimetica1.sumar();
        
        int resultado = arimetica1.sumarConRetorno();
        System.out.println("resul: "+resultado);
        
        resultado = arimetica1.sumarConRetornoYArgumentos(3, 4);
        System.out.println("resultado es: "+resultado);
        
        Arimetica arimetica2 = new Arimetica(10,12);
        arimetica2.sumar();
    }
    
}
