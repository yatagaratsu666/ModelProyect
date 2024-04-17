
package controlador;

import brenda.listsingly.LinkedList;
import modelo.Boleto;
import modelo.Ruta;
import modelo.Sistema;

public class ControladorMaquina {
    private Sistema sistema;

    public ControladorMaquina (Sistema sistema) {
        this.sistema = sistema;
    }

    public void venderBoleto(Boleto boleto) {
        // Lógica para vender un boleto utilizando la máquina de venta
    }

    public LinkedList<Ruta> consultarRutasDisponibles() {
        //return sistema.consultarRutasDisponibles();
        return null;
    }

    public Ruta recomendarRutaMasCorta() {
        //return sistema.recomendarRutaMasCorta();
        return null;
    }

    // Otros métodos del controlador
}
