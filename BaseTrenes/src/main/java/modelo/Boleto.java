
package modelo;

import java.io.Serializable;

public class Boleto implements Serializable {

    private String fechaCompra;
    private String fechaLlegada;
    private Tren tren;
    private Cliente cliente;
    private Equipaje equipaje;
    private String categoria;
    public RutaEntity trayectoria;
    private double precioTotal;

    public Boleto(String fechaCompra, Tren tren, Cliente cliente, Equipaje equipaje, String categoria, RutaEntity trayectoria, double precioTotal) {
        this.fechaCompra = fechaCompra;
        this.tren = tren;
        this.cliente = cliente;
        this.equipaje = equipaje;
        this.categoria = categoria;
        this.trayectoria = trayectoria;
        this.precioTotal = precioTotal;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipaje getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(Equipaje equipaje) {
        this.equipaje = equipaje;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public RutaEntity getTrayectoria() {
        return trayectoria;
    }

    public void setTrayectoria(RutaEntity trayectoria) {
        this.trayectoria = trayectoria;
    }

}
