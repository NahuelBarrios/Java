package test;

import datos.*;
import java.util.*;
import domain.Usuario;


public class TestUsuarios {
    
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.seleccionar();
        
//        Usuario usuarioInsert = new Usuario("Cande","4321");
//        usuarioDao.insertar(usuarioInsert);
//        
//          Usuario usuarioModificar = new Usuario(2,"KND","2345");
//          usuarioDao.actualizar(usuarioModificar);
    
//            Usuario usuarioDelete = new Usuario(2);
//            usuarioDao.eliminar(usuarioDelete);

        for(Usuario usuario: usuarios)
        {
            System.out.println("usuario = " + usuario);
        }
    }
}
