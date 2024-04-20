package modelo;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class Tren implements Serializable {

    private String nombre;
    private String identificador;
    private int capacidadCarga;
    private int kilometraje;

    public Tren() {

    }

    public Tren(String nombre, String identificador) {
        this.identificador = identificador;
        switch (nombre) {
            case "Mercedes-Benz" -> {
                this.nombre = "Mercedes-Benz";
                this.capacidadCarga = 28;
            }
            case "Arnold" -> {
                this.nombre = "Arnold";
                this.capacidadCarga = 32;
            }
            case "" -> {
                this.nombre = "";
                this.capacidadCarga = -1;
            }
            default ->
                throw new NoSuchElementException("El nombre del tren debe ser 'MercedesBenz' o 'Arnold'");
        }
        this.kilometraje = 0;
    }

    public Tren(String nombre, String identificador, int capacidadCarga, int kilometraje) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.capacidadCarga = capacidadCarga;
        this.kilometraje = kilometraje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
}
