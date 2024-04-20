
package modelo;

import brenda.listsingly.LinkedList;

public class Sistema {
    private LinkedList<Tren> trenes;
    private LinkedList<Ruta> rutas;
    private LinkedList<Employee> empleados;
    private Estacion estacion;

    public LinkedList<Tren> getTrenes() {
        return trenes;
    }

    public void setTrenes(LinkedList<Tren> trenes) {
        this.trenes = trenes;
    }

    public LinkedList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(LinkedList<Ruta> rutas) {
        this.rutas = rutas;
    }

    public LinkedList<Employee> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Employee> empleados) {
        this.empleados = empleados;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

}
