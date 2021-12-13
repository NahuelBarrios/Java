package personas.jdbc;

import java.sql.*;

public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test2?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    //Conectarse a la base de datos
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    //Metodos para cerrar los objetos
    
    public static void close(ResultSet rs) throws SQLException
    {
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException
    {
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException
    {
        smtm.close();
    }
    
     public static void close(Connection conn) throws SQLException
    {
        conn.close();
    }
    
}
