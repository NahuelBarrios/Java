package test;

import domain.Persona;

public class TestForEach {

    public static void main(String[] args) {
        
        int edades[] = {3, 4, 5, 6};
        
        for(int edad:edades)
        {
            System.out.println("edad = " + edad);
        }
        
        Persona personas[] = {new Persona("Nahuel"),new Persona("Cande"),new Persona("Candelita")};
        
        for(Persona persona:personas)
        {
            System.out.println("persona = " + persona);
        }
    }
}
