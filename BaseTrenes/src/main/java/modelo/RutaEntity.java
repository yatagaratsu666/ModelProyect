
package modelo;

import java.io.Serializable;

public class RutaEntity implements Serializable {
    String inicio;
    String fin;
    String trayecto;
    float precio;
    Equipaje equipaje;

    public RutaEntity(Equipaje equipaje, String inicio, String fin, String trayecto, float precio) {
        this.equipaje = equipaje;
        this.inicio = inicio;
        this.fin = fin;
        this.trayecto = trayecto;
        this.precio = precio;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(String trayecto) {
        this.trayecto = trayecto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Equipaje getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(Equipaje equipaje) {
        this.equipaje = equipaje;
    }
    
  
}
