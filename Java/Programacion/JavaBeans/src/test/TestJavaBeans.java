package test;

import domain.Persona;

public class TestJavaBeans {
    
    public static void main(String[] args) {
        
        Persona persona = new Persona();
        
        persona.setNombre("Nahuel");
        persona.setApellido("Barrios");
        System.out.println("persona = " + persona);
    }
}
