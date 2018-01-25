
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Formato {
    //Formato es una clase diseñada para poder separar los atributos que se necessitan en las consultas
    //Cada item del array es una parte del comando
    ArrayList<String> comandos=new ArrayList();
    public void setComando(String c){
        comandos.add(c);
    }
    public String getComando(int i){
        return comandos.get(i);
    }
}
