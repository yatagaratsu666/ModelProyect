package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Estacion;

public interface RemoteEstacion extends Remote {

    public LinkedList<Estacion> consultarEstacion() throws RemoteException;
    
}
