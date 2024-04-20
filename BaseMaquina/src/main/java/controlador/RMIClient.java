
package controlador;

import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import modelo.Boleto;
import modelo.Cliente;
import modelo.RutaEntity;
import modelo.Tren;
import modelo.TrenEntity;

public class RMIClient {

    public static void main(String[] args) throws RemoteException {
//        ControlRuta cr = new ControlRuta();
//        String inicio = "A";
//        String fin = "E";
//        String trayecto = "";
//        String traza = "AFE";
//        LinkedList<String> trayectoria = cr.seleccionEstaciones(inicio, fin, traza);
//        for (int i = 0; i < trayectoria.size(); i++) {
//            trayecto = trayecto + trayectoria.get(i);
//        }
//        System.out.println(trayecto);
//        ControlRuta cr = new ControlRuta();
//        LinkedList<String> recorrido = cr.seleccionEstaciones("A", "E", "AFE");
//        Iterator ite = recorrido.iterator();
//        while(ite.hasNext()){
//            System.out.println(ite.next());
//        }
//        System.out.println(cr.totalWeight());
//        ControlTren ct = new ControlTren();
//        Tren tre = ct.seleccionarTren("1-2A");
//        System.out.println(tre.getCapacidadCarga());
//        ControlCategoria cg = new ControlCategoria(tre);
//        cg.seleccionarPuesto( 5, "Premium", 2);
//        System.out.println(cg.valor());
        ControlBoleto cb;
        ControlCliente cc;
        ControlEquipaje ce;
        ControlCategoria cca;
        DefaultTableModel mt = new DefaultTableModel();

        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActualString = horaActual.format(formatter);
        cb = new ControlBoleto();
        cc = new ControlCliente();
        ce = new ControlEquipaje();
        cca = new ControlCategoria();
        Cliente cliente = cc.cargarClienteDesdeJSON();
        RutaEntity rutaEntity = ce.cargarClienteDesdeJSON();
        TrenEntity categoria = cca.cargarJSON();
        Boleto boleto = cb.armarBoleto(horaActualString, cliente, rutaEntity, categoria);
        System.out.println(boleto.getTrayectoria().getInicio());
    }
}
