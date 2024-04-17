
package controlador;


import brenda.listsingly.LinkedList;
import modelo.Tren;

public class ControlTren implements java.rmi.Remote{
    
    public ControlTren(){

    }

    public LinkedList<Tren> consultarTrenDisponibles() {
        //en esta parte, el cliente debe de recibir una lista de trenes traida la app baseAdmin (especificamente, en baseAdmin.ControlTren
        LinkedList lista = new LinkedList<>();
        return lista;
    }
    
    public boolean seleccionarTren(int index){
        //en base a la lista de trenes disponibles, se debe de escoger uno en base a su identificador
        return true;
    }

}
