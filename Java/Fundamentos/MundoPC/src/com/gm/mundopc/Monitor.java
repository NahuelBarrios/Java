package com.gm.mundopc;

public class Monitor {
    
    //Atributos
    private int idMonitor;
    private String marca;
    private double tamanio;
    private static int contadorMonitores;
    
    //Constructores
    private Monitor()
    {
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    
    public Monitor(String marca,double tamaño)
    {
        this();
        this.marca = marca;
        this.tamanio = tamaño;
    }
    
    //Get, set and toString

    public int getIdMonitor() {
        return this.idMonitor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Monitor{" + "idMonitor=" + idMonitor + ", marca=" + marca + ", tama\u00f1o=" + tamanio + '}';
    }
    
    
    
    
    
}
