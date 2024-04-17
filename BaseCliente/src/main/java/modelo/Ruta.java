
package modelo;

import controlador.ControlRuta;
import java.io.Serializable;
import java.time.LocalTime;


public class Ruta implements Serializable{
    
    public int id;
    public Estacion estacion1;
    public Estacion estacion2;
    public String horarios;
    public float precio;
    public Tren tren;

    
    public Ruta(){
        
    }

    public Ruta(int id, Estacion estacion1,Estacion estacion2, String horarios, float precio, Tren tren) {
        this.id = id;
        this.estacion1 = estacion1;
        this.estacion2 = estacion2;
        this.horarios = horarios;
        this.precio = precio;
        this.tren = tren;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estacion getEstacion1() {
        return estacion1;
    }

    public void setEstacion1(Estacion estacion1) {
        this.estacion1 = estacion1;
    }

    public Estacion getEstacion2() {
        return estacion2;
    }

    public void setEstacion2(Estacion estacion2) {
        this.estacion2 = estacion2;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }  

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }
    
    
    
}