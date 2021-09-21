package clases;

public class NewPersona {
    
    public static void main(String[] args) {
         Persona persona = new Persona();
         persona.nombre = "Nahuel";
         persona.apellido = "Barrios";
         
         persona.desplegarInformacion();
         
         Persona persona2 = new Persona();
         persona2.nombre = "Lionel";
         persona2.apellido = "Messi";
         persona2.desplegarInformacion();
    }
}
