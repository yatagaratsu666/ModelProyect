
package domain;

import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import controlador.ControlBoleto;
import controlador.ControlEstacion;
import controlador.ControlRutas;
import controlador.ControlTren;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import modelo.Boleto;
import view.LoginFrame;

public class Main { 

    public static void main(String[] args) throws RemoteException {
        ControlBoleto cb = new ControlBoleto();
        LinkedList<Boleto> boletos = cb.consultarBoletos();
        Iterator<Boleto> ite = boletos.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next().getCliente().getName());
        }
    }
}
