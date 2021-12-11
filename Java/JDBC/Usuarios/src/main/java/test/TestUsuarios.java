package test;

import datos.*;
import java.util.*;
import domain.Usuario;
import datos.*;
import java.sql.Connection;
import java.sql.SQLException;


public class TestUsuarios { // Transacciones : ejecutar varias sentencias SQL. las q mas nos interesa son las q modifica la base de datos
    
    public static void main(String[] args) {
        
        Connection conexionAux = null; // La definimos fuera del bloque trycacht para utilizarla dentro de otro bloque
        
        try {
            conexionAux = Conexion.getConnection();
            if(conexionAux.getAutoCommit())
            {
                conexionAux.setAutoCommit(false); // Lo ponemos en false para que el commit no se haga de forma automatica.
            }
            UsuarioDAO usuarioDao = new UsuarioDAO(conexionAux);
            Usuario usuario = new Usuario(4,"MariaC","1111");
            usuarioDao.actualizar(usuario);
            System.out.println("usuario = " + usuario);
            
            Usuario nuevoUsuario = new Usuario("Walter","3333");
            usuarioDao.insertar(nuevoUsuario);
            
            conexionAux.commit(); // Hacemos el commit. por eso lo ponemos en false al principio, para q no se haga de forma automatica. nosotros decidimos cuando realizar los cambios
            
            System.out.println("Se ha hecho commit de la transicion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexionAux.rollback(); // Todas las sentencias que modifican las bases de datos no se van a realizar.
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
}
