package controlador;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import view.LoginFrameAdmin;
import view.LoginFrame;

public class Server {

    public static void main(String[] args) {
//        LoginFrame lf = new LoginFrame();
//        lf.setVisible(true);
        try {
            //rutas
            ControlRutas controlRutas = new ControlRutas();
            Registry registry = LocateRegistry.createRegistry(1088);
            registry.rebind("ControlRutas", controlRutas);
            System.out.println("Server ready");
            
            //estaciones
            ControlEstacion controlEstacion = new ControlEstacion();
            Registry registry1 = LocateRegistry.createRegistry(1086);
            registry1.rebind("ControlEstacion", controlEstacion);
            System.out.println("Server ready 1");
            
            //trenes
            ControlTren controlTren = new ControlTren();
            Registry registry2 = LocateRegistry.createRegistry(1084);
            registry2.rebind("ControlTren", controlTren);
            System.out.println("Server ready 2");
            
            //boletos
            ControlBoleto controlBoleto = new ControlBoleto();
            Registry registry3 = LocateRegistry.createRegistry(1082);
            registry3.rebind("ControlBoleto", controlBoleto);
            System.out.println("Server ready 3");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
