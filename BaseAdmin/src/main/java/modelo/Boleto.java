
package modelo;

import java.io.Serializable;


public class Boleto implements Serializable {
    private int idRegistro;
    private String fechaCompra;
    private String fechaSalida;
    private String fechaLlegada;
    private String identificacionPasajero;
    private Tren tren;
    private Ruta ruta;
    private Cliente cliente;
    private Equipaje equipaje;
    private Categoria categoria;
    private float precioTotal;

    public Boleto(String fechaCompra, String fechaSalida, String fechaLlegada, String identificacionPasajero, Tren tren, Ruta ruta, Cliente cliente, Equipaje equipaje, Categoria categoria, float precioTotal) {
        this.fechaCompra = fechaCompra;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.identificacionPasajero = identificacionPasajero;
        this.tren = tren;
        this.ruta = ruta;
        this.cliente = cliente;
        this.equipaje = equipaje;
        this.categoria = categoria;
        this.precioTotal = precioTotal;
    }
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Boleto encontrado para el cliente ").append(cliente.getName()).append(":\n");
        sb.append("ID de registro: ").append(idRegistro).append("\n");
        sb.append("Fecha de compra: ").append(fechaCompra).append("\n");
        sb.append("Fecha de salida: ").append(fechaSalida).append("\n");
        sb.append("Fecha de llegada: ").append(fechaLlegada).append("\n");
        sb.append("Identificación del pasajero: ").append(identificacionPasajero).append("\n");
        sb.append("Tren: ").append(tren.getNombre()).append("\n");
        sb.append("Ruta: ").append(ruta.toString()).append("\n");
        sb.append("Cliente:\n").append(cliente.toString());
        return sb.toString();
    }
}
