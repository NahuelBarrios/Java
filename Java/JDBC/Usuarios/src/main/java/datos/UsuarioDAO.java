package datos;

import java.util.*;
import domain.Usuario;
import java.sql.*;

public class UsuarioDAO {

    private Connection conexionTransacional;

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, pass FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO test.usuarios(usuario, pass) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, pass = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";

    public UsuarioDAO() {

    }

    public UsuarioDAO(Connection conexionTransacional) // No se va a cerrar al ejecutar los metodos
    {
        this.conexionTransacional = conexionTransacional;
    }

    public List<Usuario> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; //Este objeto se puede utilizar para ejecutar de manera eficiente esta declaración varias veces.
        ResultSet rs = null;// ResultSet contiene todas las filas que satisfacen las condiciones de una sentencia SQL y proporciona el acceso a los datos de estas filas mediante un conjunto de métodos get que permiten el acceso a las diferentes columnas de la filas
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection(); //Si el objeto de conexionTrancicional  es distinto de null entonces utilizamos el obejto. de lo contrario. Nos conectamos a la base de datos
            stmt = conn.prepareStatement(SQL_SELECT); // 
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuarioAux = rs.getString("usuario");
                String pass = rs.getString("pass");

                usuario = new Usuario(idUsuario, usuarioAux, pass);
                usuarios.add(usuario); //Agrego la persona a la List para retorna
            }
        }  finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTransacional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());// el nro 1 se debe a que el primer parametro q paso es el nombre a el SQL
            stmt.setString(2, usuario.getPasswordUsuario());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }  finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransacional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int actualizar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombreUsuario());// el nro 1 se debe a que el primer parametro q paso es el nombre a el SQL
            stmt.setString(2, usuario.getPasswordUsuario());
            stmt.setInt(3, usuario.getIdUsuario());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }  finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransacional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int eliminar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }  finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransacional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

}
