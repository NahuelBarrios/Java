package domain;

public class Persona {
    
    //Atributos
    private final int idPersona;
    private static int contadorPersona;
    
    static{// El bloque estatico se tiene que inicializar antes del o los constructores. El bloque estatico solo se ejecuta 1 vez
        System.out.println("Ejecucion bloque estatico");
        ++Persona.contadorPersona; // Incremento en 1 el contador para q el valor sea 1. 
    }
  
    {//Se ejecuta cada vez q agregamos un objeto a nuestra clase
        System.out.println("Ejecucion bloque NO estatico");
        this.idPersona = Persona.contadorPersona++; // Se incrementa despues. Su valor ya es 1.
    }
    
    //Constructor
    public Persona()
    {
        System.out.println("Ejecucion del constructor");
    }
    
    //Get

    public int getIdPersona() {
        return this.idPersona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{idPersona=").append(idPersona);
        sb.append('}');
        return sb.toString();
    }
    
    
}
