
package com.gm.mundopc;

public class Orden {
    
    //Atributos
    private int idOrden;
    private static int contadorOrdenes;
    private Computadora computadoras[];
    private int contadorComputadoras;
    private final static int MAX_COMPUTADORAS = 10;
    
    //Constructor
    public Orden()
    {
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS]; // Inicializar una new computadora
    }
    
    //metodos
    public void agregarComputadora(Computadora computadora)
    {
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS)
        {
            this.computadoras[this.contadorComputadoras++] = computadora; // Incremento en 1, por si hay otro producto en el object
        }
        else
        {
            System.out.println("Supero el limite de productos: " + Orden.MAX_COMPUTADORAS);
        }
    }
    
    public void mostrarOrden()
    {
        System.out.println("idOrden = " + this.idOrden);
        System.out.println("Computadoras de la Orden :  #" +this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) 
        {
            System.out.println(this.computadoras[i]);
        }
    }
    
}
