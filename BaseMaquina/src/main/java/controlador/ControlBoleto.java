
package controlador;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import modelo.Boleto;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Equipaje;
import modelo.RutaEntity;
import modelo.Tren;
import modelo.TrenEntity;

public class ControlBoleto implements RemoteBoleto{
    
    Boleto boleto;
    
    public ControlBoleto() throws RemoteException{
        
    }
    
    public Boleto armarBoleto(String fechaCompra, Cliente cliente, RutaEntity trayectoria, TrenEntity trenEntity) throws RemoteException{
        Equipaje equipaje = new Equipaje(trayectoria.getEquipaje().getCantidadEquipajes(), trayectoria.getEquipaje().getPeso1());
        Tren tren = trenEntity.getTren();
        double precio = trayectoria.getPrecio()*trenEntity.getValor();
        boleto = new Boleto(fechaCompra, tren, cliente, equipaje, trenEntity.getCategoria(), trayectoria, precio);
        agregarEnLista(boleto);
        return boleto;
    }

    @Override
    public void agregarEnLista(Boleto boleto) throws RemoteException {
        try {
            Properties pw = new Properties();
            Registry registry3 = LocateRegistry.getRegistry(pw.getProperty("IP"), 1082);
            RemoteBoleto controlBoleto = (RemoteBoleto) registry3.lookup("ControlBoleto");
            controlBoleto.agregarEnLista(boleto);
        } catch (NotBoundException | RemoteException e) {

        }
    }
    
    
}
