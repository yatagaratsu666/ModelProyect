
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Ruta;

public interface RemoteInterface<E> extends Remote {

    public LinkedList<E> consultarDisponibles() throws RemoteException;

    public LinkedList<E> consultar(String direccion) throws RemoteException;
    
}
