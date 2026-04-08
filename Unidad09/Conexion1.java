package ejemplos2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author profe
 */
public class Conexion1 {

    public static void main(String[] args) {

        Connection conexion = null;
        boolean conOk = false;
        final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";

        // Cadena de conexión para conectar con MySQL en localhost,
        //seleccionar la base de datos llamada ‘world’
        // con usuario y contraseña del servidor de MySQL: root y root
        String cadenaConexion = "jdbc:mysql://localhost/world?serverTimezone=UTC";
        //String cadenaConexion= "jdbc:mysql://localhost/world?serverTimezone=GMT%2B2";   //"serverTimezone", "GMT+2"
        //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        String usuario = "root";
        String passwd = "root";

        try {
            // Cargar el driver de mysql
            System.out.println("Cargando el driver de mysql");
            Class.forName(DRIVER_MYSQL);

            // Obtener la conexión
            System.out.println("Intentando conectar con la base de datos.");
            conexion = DriverManager.getConnection(cadenaConexion, usuario, passwd);
            System.out.println("Conexión realizada con éxito.");
            conOk = true;
            System.out.println("¿Y ahora qué?");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println("Excepción: " + e.toString());
        }

    }

}
