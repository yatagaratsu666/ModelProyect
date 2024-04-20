
package modelo;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import java.io.Serializable;

public class Categoria implements Serializable {

    private LinkedList<Integer> vagonesPremium;
    private LinkedList<Integer> vagonesEstandar;
    private LinkedList<Integer> vagonesEjecutivo;
    float valor = 0;

    public Categoria() {
        vagonesPremium = new LinkedList<>();
        vagonesEstandar = new LinkedList<>();
        vagonesEjecutivo = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            vagonesPremium.add(i);
        }
        for (int i = 4; i < 13; i++) {
            vagonesEjecutivo.add(i);
        }
        for (int i = 13; i <= 32; i++) {
            vagonesEstandar.add(i);
        }
    }

    public int seleccionarVagon(String tipo, int numeroDeseado) {
        int base = -1;
        switch (tipo.toLowerCase()) {
            case "premium":
                base = eliminarVagon(vagonesPremium, numeroDeseado);
                valor = 1800;
                break;
            case "estandar":
                base = eliminarVagon(vagonesEstandar, numeroDeseado);
                valor = 1000;
                break;
            case "ejecutivo":
                base = eliminarVagon(vagonesEjecutivo, numeroDeseado);
                valor = 1200;
                break;
            default:
                base = -1;
                break;
        }
        return base;
    }

    private int eliminarVagon(LinkedList<Integer> listaVagones, int numeroDeseado) {
        if (listaVagones.contains(numeroDeseado)) {
            listaVagones.remove(numeroDeseado);
            return numeroDeseado;
        } else {
            System.out.println("El vagon deseado no está disponible en esta categoría.");
            return -1;
        }
    }

    public StringBuilder mostrarVagonesDisponibles() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Vagones disponibles:\n\n");
        mensaje.append("Premium: ");
        for (int i = 0; i < vagonesPremium.size(); i++) {
            mensaje.append(vagonesPremium.get(i));
            if (i < vagonesPremium.size() - 1) {
                mensaje.append(", ");
            }
        }
        mensaje.append("\nEstandar: ");
        for (int i = 0; i < vagonesEstandar.size(); i++) {
            mensaje.append(vagonesEstandar.get(i));
            if (i < vagonesEstandar.size() - 1) {
                mensaje.append(", ");
            }
        }
        mensaje.append("\nEjecutivo: ");
        for (int i = 0; i < vagonesEjecutivo.size(); i++) {
            mensaje.append(vagonesEjecutivo.get(i));
            if (i < vagonesEjecutivo.size() - 1) {
                mensaje.append(", ");
            }
        }

        return mensaje;
    }

    public LinkedList<Integer> getVagonesPremium() {
        return vagonesPremium;
    }

    public void setVagonesPremium(LinkedList<Integer> vagonesPremium) {
        this.vagonesPremium = vagonesPremium;
    }

    public LinkedList<Integer> getVagonesEstandar() {
        return vagonesEstandar;
    }

    public void setVagonesEstandar(LinkedList<Integer> vagonesEstandar) {
        this.vagonesEstandar = vagonesEstandar;
    }

    public LinkedList<Integer> getVagonesEjecutivo() {
        return vagonesEjecutivo;
    }

    public void setVagonesEjecutivo(LinkedList<Integer> vagonesEjecutivo) {
        this.vagonesEjecutivo = vagonesEjecutivo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
//
//    private String nombre;
//    private int valor;
//    private int cantidad;
//    private Array<Integer> secciones;
//    private Array<Boolean> reservadas;
//
//    public Categoria(String nombre, Tren tren) {
//        secciones = new Array<>(4);
//        this.nombre = nombre;
//        switch (nombre) {
//            case "Estandar":
//                this.valor = 1000;
//                this.cantidad = 22;
//                break;
//            case "Ejecutivo":
//                this.valor = 1200;
//                this.cantidad = 18;
//                break;
//            case "Premium":
//                this.valor = 1800;
//                this.cantidad = 4;
//                break;
//            default:
//                throw new IllegalArgumentException("Nombre de categoría no válido");
//        }
//        for (int i = 0; i < this.cantidad; i++) {
//            for (int j = 0; j < 4; j++) {
//                secciones.add(4);
//                reservadas.add(false);
//            }
//        }
//    }

//
//        Array<Integer> secciones = base.get(vagon);
//        Array<Boolean> reservadas = seccionesReservadas.get(vagon);
//        int asientosDisponibles = secciones.get(seccion);
//        if (asientosDisponibles > 0 && !reservadas.get(seccion) && cantidad > 0) {
//            secciones.set(seccion, asientosDisponibles - 1);
//            reservadas.set(seccion, true);
//            if (seccionReservada(vagon)) {
//                base.remove(vagon);
//                seccionesReservadas.remove(vagon);
//                cantidad--;
//            }
//            return seccion;
//        } else {
//            return -1;
//        }
//    }
//
//    private boolean seccionReservada(int vagon) {
//        Array<Boolean> reservadas = seccionesReservadas.get(vagon);
//        for (int i = 0; i < reservadas.size(); i++) {
//            if (!reservadas.get(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public String getNombre() {
//        return nombre;
//    }
//
//    public int getValor() {
//        return valor;
//    }
//
//    public int getCantidad() {
//        return cantidad;
//    }
//      
