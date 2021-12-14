package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import personas.dto.PersonaDTO;
import personas.jdbc.*;

public class TestPersona {

    public static void main(String[] args) {

        
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaDao personaDao = new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO> personas = personaDao.select();
            
            for(PersonaDTO persona: personas){
                System.out.println("Persona DTO:" + persona);
            }
            
            PersonaDTO personaNew = new PersonaDTO();
            personaNew.setNombre("Candy");
            personaNew.setApellido("Perreo");
            personaDao.insert(personaNew);  
            
            conexion.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollBack");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

}
