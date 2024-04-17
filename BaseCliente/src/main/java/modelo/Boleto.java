
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
    private double precioTotal;

    public Boleto(String fechaCompra, String fechaSalida, String fechaLlegada, String identificacionPasajero, Tren tren, Ruta ruta, Cliente cliente, Equipaje equipaje, Categoria categoria) {
        this.fechaCompra = fechaCompra;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.identificacionPasajero = identificacionPasajero;
        this.tren = tren;
        this.ruta = ruta;
        this.cliente = cliente;
        this.equipaje = equipaje;
        this.categoria = categoria;
        this.precioTotal = ruta.getPrecio()*categoria.getValor();
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getIdentificacionPasajero() {
        return identificacionPasajero;
    }

    public void setIdentificacionPasajero(String identificacionPasajero) {
        this.identificacionPasajero = identificacionPasajero;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
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
