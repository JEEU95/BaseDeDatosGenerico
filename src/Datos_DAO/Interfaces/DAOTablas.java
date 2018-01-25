
package Datos_DAO.Interfaces;

import java.sql.ResultSet;


/**
 *
 * @author Jorge
 */
public interface DAOTablas {
    public void ejecutar(Object o) throws Exception;
    public void registrar(Object o) throws Exception;
    public void modificar(Object o) throws Exception;
    public void eliminar(Object o) throws Exception;
    public ResultSet consulta(Object o) throws Exception;
}
