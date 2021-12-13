package personas.jdbc;

import java.sql.*;
import java.util.*;
import personas.dto.PersonaDTO;

public class PersonaDaoJDBC implements PersonaDao{

    //Atributos
    private Connection userConn;
    private static final String SQL_INSERT = "INSERT INTO test2.personas(nombre, apellido) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE test2.personas SET nombre = ?, apellido = ? WHERE id_personas = ?";
    private static final String SQL_DELETE = "DELETE FROM test2.personas WHERE id_personas = ?";
    private static final String SQL_SELECT = "SELECT id_personas, nombre, apellido FROM test2.personas";

    //Constructores
    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection userConn) {
        this.userConn = userConn;
    }
    
    //Metodos a implementar la interface
    
    @Override
    public int insert(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();//Si el objeto de conexionTrancicional  es distinto de null entonces utilizamos el obejto. de lo contrario. Nos conectamos a la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());// el nro 1 se debe a que el primer parametro q paso es el nombre a el SQL
            stmt.setString(2, persona.getApellido());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }finally{
            try {
                Conexion.close(stmt);
                if(userConn != null)
                {
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();//Si el objeto de conexionTrancicional  es distinto de null entonces utilizamos el obejto. de lo contrario. Nos conectamos a la base de datos
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());// el nro 1 se debe a que el primer parametro q paso es el nombre a el SQL
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getIdPersona());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }finally{
            try {
                Conexion.close(stmt);
                if(userConn != null)
                {
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
    

    @Override
    public int delete(PersonaDTO persona) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.userConn != null ? this.userConn : Conexion.getConnection();//Si el objeto de conexionTrancicional  es distinto de null entonces utilizamos el obejto. de lo contrario. Nos conectamos a la base de datos
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();// Actualiza el estado de la base de datos
        }finally{
            try {
                Conexion.close(stmt);
                if(userConn != null)
                {
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;

    }

    @Override
    public List<PersonaDTO> select() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null; //Este objeto se puede utilizar para ejecutar de manera eficiente esta declaración varias veces.
        ResultSet rs = null;// ResultSet contiene todas las filas que satisfacen las condiciones de una sentencia SQL y proporciona el acceso a los datos de estas filas mediante un conjunto de métodos get que permiten el acceso a las diferentes columnas de la filas
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = this.userConn != null ? this.userConn : Conexion.getConnection(); //Si el objeto de conexionTrancicional  es distinto de null entonces utilizamos el obejto. de lo contrario. Nos conectamos a la base de datos
            stmt = conn.prepareStatement(SQL_SELECT); // 
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_personas");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                persona = new PersonaDTO(idPersona, nombre, apellido);
                personas.add(persona); //Agrego la persona a la List para retorna
            }
        }  finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.userConn == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    
    
}

