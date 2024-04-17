
package modelo;

import java.io.Serializable;


public class Equipaje implements Serializable{
    private int peso;
    private int cantidad;

    public Equipaje(int peso, int cantidad) {
        if (cumpleCondiciones()) {
            this.peso = peso;
            this.cantidad = cantidad;
        }
    }

    public boolean cumpleCondiciones() {
        return (cantidad <= 2 && peso <= 80);
    }

    public int getPeso() {
        return peso;
    }

    public int getCantidad() {
        return cantidad;
    }
}
