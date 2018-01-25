package Datos_DAO;

//import Datos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Connection_DB {
//Creacion de la clase para establecer la conexion con la BD    

    public static Connection conectar(String user, String pass) {
        try {
            parametro_conexion pc=new parametro_conexion();
            Class.forName(pc.Driver);
            String BD = pc.URL;
            //Establece la conexion con (BD, "HR", "1234");
            Connection cnx = DriverManager.getConnection(BD, user, pass);

            return cnx;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al conectar con la BD");
        } catch (SQLException ex) {
            System.out.println("Erro al conectar con la BD");
        }
        return null;
    }

    public void cerrar(Connection cnx) throws SQLException {
        //Método para cerrar la conexion
        if (cnx != null) {
            if (!cnx.isClosed()) {
                cnx.close();
            }
        }
    }

}
