
package modelo;

import java.io.Serializable;


public class Estacion implements Serializable {
    public String nombre;
    
    public Estacion(){
        
    }

    public Estacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
