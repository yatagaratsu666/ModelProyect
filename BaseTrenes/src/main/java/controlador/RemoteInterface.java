
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Ruta;

public interface RemoteInterface extends Remote {

    public LinkedList<Ruta> consultarDisponibles() throws RemoteException;

}
