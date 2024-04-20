
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Tren;


public interface RemoteTren extends Remote {
    public LinkedList<Tren> consultarTrenDisponibles() throws RemoteException;
}
