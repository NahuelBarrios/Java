package dominio;

public class Persona 
{
    //Atributos
    private String nombre;
    private double sueldo;
    private boolean eliminado;
    
    //Constructores
    
    public Persona(String nombre,double sueldo,boolean eliminado)
    {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
       
    }
    
    //metodos
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public double getSueldo()
    {
        return this.sueldo;
    }
    public void setSueldo(double sueldo)
    {
        this.sueldo = sueldo;
    }
    
    public boolean isEliminado() // Los booleans se le pone is y no get
    {
        return this.eliminado;
    }
    public void setNombre(boolean eliminado)
    {
        this.eliminado = eliminado;
    }
    
    public String toString()
    {
        return "Persona: [Nombre: " + this.nombre + ", Sueldo: " + this.sueldo + "Eliminado: " +this.eliminado + "]";
    }
    
}
