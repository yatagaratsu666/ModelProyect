
package controlador;

import brenda.grafo.Edge;
import brenda.grafo.Graph;
import brenda.grafo.GraphNode;
import brenda.listsingly.LinkedList;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import modelo.Estacion;
import modelo.Ruta;

public class ControlRuta implements RemoteInterface {

    LinkedList<Ruta> cosas;
    Graph<String> graph;
    ControlEstacion ce;
    LinkedList<Estacion> estaciones;
    float price = 0;

    public ControlRuta() throws RemoteException {
        this.cosas = consultarDisponibles();
        this.ce = new ControlEstacion();
        this.estaciones = ce.consultarEstacion();
        this.graph = new Graph<>();
        for(int i = 0; i < estaciones.size(); i++){
            graph.newNode(estaciones.get(i).getNombre());
        }
        for (int i = 0; i < cosas.size(); i++) {
            graph.newEdge(cosas.get(i).getEstacion1().getNombre(), cosas.get(i).getEstacion2().getNombre(), cosas.get(i).getPrecio());
        }
    }

    public LinkedList<String> rutaRecomendada(String inicio, String destino) {
        price = graph.shortestPathKm(graph, inicio, destino);
        return graph.shortestPath(graph, inicio, destino);
    }

    public LinkedList<Ruta> consultar(){
        return cosas;
    }
    
    @Override
    public LinkedList<Ruta> consultarDisponibles() throws RemoteException, AccessException {
        LinkedList<Ruta> rutasDisponibles = new LinkedList<>();
        try {
            Properties pw = new Properties();
            Registry registry = LocateRegistry.getRegistry(pw.getProperty("IP"), 1088);
            RemoteInterface controlRutas = (RemoteInterface) registry.lookup("ControlRutas");
            rutasDisponibles = controlRutas.consultarDisponibles();
        } catch (NotBoundException | RemoteException e) {

        }
        return rutasDisponibles;
    }

    public float valorRutaRecomendada(String inicio, String destino) {
        return graph.shortestPathKm(graph, inicio, destino);
    }

    public LinkedList<String> seleccionEstaciones(String inicio, String destino, String edge) {
        String start = edge;
        LinkedList<String> trayectoria = new LinkedList<>();
        if ((!start.startsWith(inicio) 
                || !start.endsWith(destino)) 
                && (!start.startsWith(inicio) 
                && !start.endsWith(destino))) {
            price = -1;
        }
        for (int i = 0; i < edge.length(); i++) {
            char base = edge.charAt(i);
            trayectoria.add(String.valueOf(base));
        }
        price = calculateTotalWeight(graph, trayectoria);
        if (price == -1) {
            trayectoria = new LinkedList<>();
        }
        return trayectoria;
    }

    public float totalWeight() {
        return price;
    }
    
    public float calculateTotalWeight(Graph<String> graph, LinkedList<String> edges) {
        float totalWeight = 0;
        for (int i = 0; i < edges.size() - 1; i++) {
            String from = edges.get(i);
            String to = edges.get(i + 1);
            float weight = getWeightBetweenNodes(graph, from, to);
            if (weight == -1) {
                return -1;
            }
            totalWeight += weight;
        }
        return totalWeight;
    }

    private float getWeightBetweenNodes(Graph<String> graph, String from, String to) {
        GraphNode<String> fromNode = graph.getNodeByData(from);
        if (fromNode == null) {
            return -1;
        }

        for (Edge<String> edge = fromNode.list.first; edge != null; edge = edge.next) {
            if (edge.destination.equals(to)) {
                return edge.weight;
            }
        }
        return -1;
    }

}
