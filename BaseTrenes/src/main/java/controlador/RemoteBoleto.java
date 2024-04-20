
package controlador;

import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Boleto;


public interface RemoteBoleto extends Remote{
    public void agregarEnLista(Boleto boleto) throws RemoteException;
}
