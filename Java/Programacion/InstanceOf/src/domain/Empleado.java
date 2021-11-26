package domain;

public class Empleado 
{
    //Atributos
    protected String nombre;
    protected double sueldo;
    
    //Constructor
    public Empleado(String nombre, double sueldo)
    {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
    //Metodo
    public String obtenerDetalles()
    {
        return "nombre: " + this.nombre + ", sueldo: " + this.sueldo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
