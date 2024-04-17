
package modelo;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String nombre;
    private int valor;
    private int cantidad;

    public Categoria(String nombre) {
        this.nombre = nombre;
        switch (nombre) {
            case "Estandar" -> {
                this.valor = 1000;
                this.cantidad = 22;
            }
            case "Ejecutivo" -> {
                this.valor = 1200;
                this.cantidad = 18;
            }
            case "Premium" -> {
                this.valor = 1800;
                this.cantidad = 4;
            }
            default -> throw new IllegalArgumentException("Nombre de categoría no válido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }
      
}
