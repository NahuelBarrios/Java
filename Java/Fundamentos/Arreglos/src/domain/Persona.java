
package domain;


public class Persona {
    
    //Atributos
    private String nombre;

    //Constructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    //metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
    
}
