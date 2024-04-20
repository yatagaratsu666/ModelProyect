
package controlador;


import brenda.listsingly.LinkedList;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import modelo.Tren;

public class ControlTren implements java.rmi.Remote{
    
    final LinkedList<Tren> trenes;
    private Tren trenSeleccionado;
    
    public ControlTren(){
        this.trenes = consultar();
    }

    public LinkedList<Tren> consultar() {
        LinkedList<Tren> disponibles = new LinkedList<>();
        try {
            Properties pw = new Properties();
            Registry registry2 = LocateRegistry.getRegistry(pw.getProperty("IP"), 1084);
            RemoteTren controlTren = (RemoteTren) registry2.lookup("ControlTren");
            disponibles = controlTren.consultarTrenDisponibles();
        } catch (NotBoundException | RemoteException e) {

        }
        return disponibles;
    }
    
    public Tren seleccionarTren(String index){
        for(int i = 0; i < trenes.size(); i++){
            Tren trenActual = trenes.get(i);
            if(trenActual.getIdentificador().equals(index)){
                trenSeleccionado = trenActual;
                return trenSeleccionado;
            }
        }
        return null;
    }

}
