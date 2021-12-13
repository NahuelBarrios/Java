package personas.dto;

public class PersonaDTO {

    //Atributos
    private int idPersona;
    private String nombre;
    private String apellido;

    
    //Constructores

    public PersonaDTO() {
    }

    public PersonaDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
    
    public PersonaDTO(int idPersona, String nombre, String apellido) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    
    //Get, Set and ToString

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "PersonasDTO{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
    
}
