package Datos_DAO;

import Datos_DAO.Interfaces.DAOTablas;
import Logica.Formato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class DAOTablaImpl extends Connection_DB implements DAOTablas {

    Connection cnx;
    String user,pass;

    public DAOTablaImpl(String user, String pass) {
        //Constructor para implementar las tablas (necesito saber usuario y contraseña para establecer la conexion)
        this.user = user;
        this.pass = pass;
    }
    

    @Override
    public void registrar(Object o) throws Exception {
       //com contiene las dos partes que se recibiran(nombre de la tabla y valores) para poder ingresar valores a una tabla 
        Formato com = (Formato) o;
        try {
            cnx=conectar(user,pass);
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO " + com.getComando(0) + " VALUES(" + com.getComando(1) + ")");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al registrar");
        } 

    }

    @Override
    public void modificar(Object o) throws Exception {
        //com contiene las tres partes que se recibiran(nombre de la tabla, valores modificados y el/los id) para poder
        //actualizar los valores de una tabla 
        Formato com = (Formato) o;
        try {
            cnx=conectar(user,pass);
            //nom, campE, campC
            PreparedStatement pst = cnx.prepareStatement("UPDATE " + com.getComando(0) + " SET " + com.getComando(1) + " WHERE " + com.getComando(2));

            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar");
        } 
    }

    @Override
    public void eliminar(Object o) throws Exception {
        //com contiene el nombre de la tabla y el campo clave del registro a eliminar
        Formato com = (Formato) o;
        try {
            cnx=conectar(user,pass);
            //nom,campC
            PreparedStatement pst = cnx.prepareStatement("DELETE " + com.getComando(0) + " WHERE " + com.getComando(1));

            pst.executeUpdate();
            
            System.out.println("Dato Actualizado");
        } catch (Exception e) {
            System.out.println("Error al eliminar");
        } 
    }

    @Override
    public ResultSet consulta(Object o) throws Exception {
        //com contiene (campos, nombre de la tabla y condiciones) para realizar la consulta
        Formato com = (Formato) o;
        String condicion = "";
        
        //se controla el error en caso de que no se envie una condicion
        try {
            condicion += " "+com.getComando(2);
        } catch (Exception e) {
            System.out.println("Error en consulta");
            System.out.println(e.getMessage());
            condicion = "";
        }

        try {
            cnx=conectar(user,pass);
            //["FIRST_NAME","EMPLOYEES","EMPLOYEE_ID='5'"]
            Statement st = cnx.createStatement();
            System.out.println("SELECT " + com.getComando(0) + " FROM " + com.getComando(1) + condicion);
            ResultSet rs = st.executeQuery("SELECT " + com.getComando(0) + " FROM " + com.getComando(1) + condicion); //Realizar consulta
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        } 
        
        return null;
        
    }

    @Override
    public void ejecutar(Object o) throws Exception {
        //El objeto o es para recibir una consulta personalizada desde la interfaz de usuario
        try {
            cnx=conectar(user,pass);
            //nom,campC
            
            System.out.println("Ejecutar: "+(String)o);
            PreparedStatement pst = cnx.prepareStatement((String)o);

            pst.executeUpdate();
            
            System.out.println("Permisos actualizados");
        } catch (Exception e) {
            System.out.println("Error al ejecutar");
        }
    }
    

}
