
package domain;

public class Empleado extends Persona{ // heredamos Persona.
    
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    //Constructor
    public Empleado(String nombre, double sueldo) {
        super(nombre);//Para utilizar un constructor de la clase padre, se la invoca con la palabra "super"
        this.idEmpleado = ++Empleado.contadorEmpleado;// Es buena practica ponerle el nombre de la clase a mi variable estatica
        this.sueldo = sueldo;
    }
    
    // Get and Set

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //ToString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", ").append(super.toString());// Heredo el metodo ToString  de la clase Persona. para imprimir la info 
        sb.append('}');
        return sb.toString();
    }

   
    
    
    
}
