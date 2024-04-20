
package modelo;

import brenda.array.Array;
import java.io.Serializable;
import java.util.NoSuchElementException;


public class TrenEntity implements Serializable{
    
    Tren tren;
    int vagon;
    String categoria;
    int seccion;
    float valor;

    public TrenEntity(Tren tren, int vagon, String categoria, int seccion, float valor) {
        this.tren = tren;
        this.vagon = vagon;
        this.categoria = categoria;
        this.seccion = seccion;
        this.valor = valor;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public int getVagon() {
        return vagon;
    }

    public void setVagon(int vagon) {
        this.vagon = vagon;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
    
    
    
    
    
//
//    private String nombre;
//    private String identificador;
//    private int capacidadCarga;
//    private int kilometraje;
//    Array<Categoria> array;
//
//    public TrenEntity() {
//
//    }
//
//    public TrenEntity(String nombre, String identificador) {
//        this.identificador = identificador;
//        switch (nombre) {
//            case "Mercedes-Benz" -> {
//                this.nombre = "Mercedes-Benz";
//                this.capacidadCarga = 28;
//                array = new Array(capacidadCarga);
//            }
//            case "Arnold" -> {
//                this.nombre = "Arnold";
//                this.capacidadCarga = 32;
//                array = new Array(capacidadCarga);
//            }
//            case "" -> {
//                this.nombre = "";
//                this.capacidadCarga = -1;
//            }
//            default ->
//                throw new NoSuchElementException("El nombre del tren debe ser 'MercedesBenz' o 'Arnold'");
//        }
//        this.kilometraje = 0;
//    }
//
//    public TrenEntity(String nombre, String identificador, int capacidadCarga, int kilometraje) {
//        this.nombre = nombre;
//        this.identificador = identificador;
//        this.capacidadCarga = capacidadCarga;
//        this.kilometraje = kilometraje;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getIdentificador() {
//        return identificador;
//    }
//
//    public void setIdentificador(String identificador) {
//        this.identificador = identificador;
//    }
//
//    public int getCapacidadCarga() {
//        return capacidadCarga;
//    }
//
//    public void setCapacidadCarga(int capacidadCarga) {
//        this.capacidadCarga = capacidadCarga;
//    }
//
//    public int getKilometraje() {
//        return kilometraje;
//    }
//
//    public void setKilometraje(int kilometraje) {
//        this.kilometraje = kilometraje;
//    }

    public TrenEntity(Tren tren, int vagon, String categoria, int seccion) {
        this.tren = tren;
        this.vagon = vagon;
        this.categoria = categoria;
        this.seccion = seccion;
    }
}
