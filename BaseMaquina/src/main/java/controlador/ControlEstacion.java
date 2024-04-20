
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import modelo.Estacion;

public class ControlEstacion implements RemoteEstacion {

    @Override
    public LinkedList<Estacion> consultarEstacion() throws RemoteException{
        LinkedList<Estacion> estaciones = new LinkedList<>();
        try {
            Properties pw = new Properties();
            Registry registry1 = LocateRegistry.getRegistry(pw.getProperty("IP"), 1086);
            RemoteEstacion controlEstacion = (RemoteEstacion) registry1.lookup("ControlEstacion");
            estaciones = controlEstacion.consultarEstacion() ;
        } catch (NotBoundException | RemoteException e) {

        }
        return estaciones;
    }
}
