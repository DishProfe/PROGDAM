
package ejemplos2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author profe
 */
public class EjemploConsulta {
    
    public static void main(String[] args) {
        
        Connection conexion= null;
        boolean conOk= false;
        
        try {
            // Cargar el driver de mysql
            System.out.println ("Cargando el driver de mysql");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Cadena de conexión para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada ‘world’
            // con usuario y contraseña del servidor de MySQL: root y root
            String connectionUrl = "jdbc:mysql://localhost/world?serverTimezone=UTC";


            // Obtener la conexión
            System.out.println("Intentando conectar con la base de datos.");
            conexion = DriverManager.getConnection(connectionUrl, "root", "root");
            System.out.println("Conexión realizada con éxito.");
            conOk= true;

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Excepción: " + cE.toString());
        }
        
       
        if (conOk) {
            
            try {

                // Preparamos la consulta
                Statement sentencia = conexion.createStatement();                
                
                // Ejecutamos la consulta
                System.out.println ("Ejecutando la consulta.");
                ResultSet rs = sentencia.executeQuery ("SELECT name, region FROM country WHERE GovernmentForm LIKE '%Monarchy%' AND continent='Europe';");
                
                // Iteramos sobre los registros del resultado
                System.out.println ("Resultado de la consulta:");
                while (rs.next()) {
                    System.out.println (rs.getString("name") + " -- " + rs.getString (2) + " ");   
                }
                System.out.println ();
                    
                    
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
            }
        }        
    }
}
        
