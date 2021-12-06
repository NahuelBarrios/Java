package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

public class TestManejoPersonas {
    
    public static void main(String[] args) {
        
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();
//        personas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
//        
//         INSERTANDO UN NUEVO OBJETO DE TIPO PERSONA
//        Persona personaNueva = new Persona("MariaC","Scana","Scabiavino@gmail.com","33333333"); 
//        personaDao.insertar(personaNueva);
        
//        Insertando una actualizacion
//        Persona personaModificar = new Persona(3,"CandyPerreo","Scanavino","Candy@hotmail.com","33333333");
//        personaDao.actualizar(personaModificar);
        
        Persona personaEliminar = new Persona(4);
        personaDao.eliminar(personaEliminar);

        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
    
}
