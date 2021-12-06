package test;

import java.sql.*;

public class TestMySqlJDBC {
    
    public static void main(String[] args) {
    
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; 
        
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); Es necesario a veces para web
            Connection conexion = DriverManager.getConnection(url,"root","admin");//Me conecto a la base de datos
            Statement instruccion = conexion.createStatement();// Ejecuta sentencias sobre mi tabla de base de datos
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona"; // Sentencia sql
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next())//next nos indica si hay un ilemento a iterar. si hay sigue iterando, sino sale
            {
                System.out.println("Id Persona: " + resultado.getInt("id_persona") + " Nombre: " + resultado.getString("nombre") + " Apellido: " + resultado.getString("apellido") + " Email: " + resultado.getString("email" ) + " Telefono: " + resultado.getString("telefono"));   
            }
            
            //Cerramos cada uno de los objetos que abrimos de manera de adentro hacia afuera
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    
}
