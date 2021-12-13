package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import personas.dto.PersonaDTO;
import personas.jdbc.*;

public class TestPersona {

    public static void main(String[] args) {

        Connection conexionAux = null;

        try {
            conexionAux = Conexion.getConnection();
            if(conexionAux.getAutoCommit())
            {
                conexionAux.setAutoCommit(false);
            }
            
            var personaDaoAux = new PersonaDaoJDBC(conexionAux);
            
//            PersonaDTO persona1 = new PersonaDTO("Nahuel","Barrios");
//            personaDaoAux.update(persona1);
//              PersonaDTO persona1 = new PersonaDTO();
              List<PersonaDTO> personas = personaDaoAux.select();
              for(PersonaDTO persona: personas)
              {
                  System.out.println("persona = " + persona);
              }
              
            
            conexionAux.commit();
            System.out.println("Se ha hecho commit de la transicion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollBack");
            try {
                conexionAux.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

}
