
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import modelo.Ruta;


public class Server {
 public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 1222);
            RemoteInterface c = (RemoteInterface) Naming.lookup("//localhost/ControlRutas");
            LinkedList<Ruta> boop = c.consultarDisponibles();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
