package personas.jdbc;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    private static BasicDataSource dataSource;
    
    //Usar pool de conexiones
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
    //Conectarse a la base de datos
    public static Connection getConnection() throws SQLException
    {
        return getDataSource().getConnection();
    }
//   
    
    
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
