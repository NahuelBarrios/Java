/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Nahu_
 */
public class Caja {
    
    //atributos
    int ancho;
    int alto;
    int profundo;
    
    //constructores
    public Caja()
    {
        System.out.println("\n\t2Compilo. Constructor vacio.\n");
    }
    
    public Caja(int ancho,int alto,int profundo)
    {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        System.out.println("\n\t2 Compilo. constructor con argumentos\n");
        
    }
    
    //Metodo
    
    public void calcularVolumenDeCaja()
    {
        int resultado = this.ancho *this.alto*this.profundo;
        System.out.println("Resultado volumen: " + resultado);
    }
    
    
}
