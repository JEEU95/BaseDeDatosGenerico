
package Logica;

import java.util.ArrayList;

/**
 * @author Jorge
 */
public class Registro {
    //Registro en una clase diseñada para recolectar todos los datos de un registro(Sin cambiar las propiedades de los valores que este tiene) 
    
    ArrayList<Object> datos = new ArrayList();

    public ArrayList<Object> getDatos() {
        return datos;
    }

    public void setDatos(Object dato) {
        this.datos.add(dato);
    }
    
    
    
}
