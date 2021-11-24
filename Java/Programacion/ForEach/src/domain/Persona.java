package domain;

public class Persona {

    //Atributo
    private String nombre;
   
    //Constructor
    public Persona(String nombre)
    {
        this.nombre = nombre;
    }
    
    //Get, set y tostring

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + '}';
    }
     
    
    
    
    
    
}
