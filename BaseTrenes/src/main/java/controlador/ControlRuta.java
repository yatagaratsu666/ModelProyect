
package controlador;

import brenda.grafo.Edge;
import brenda.grafo.Graph;
import brenda.grafo.GraphNode;
import brenda.listsingly.LinkedList;
import java.rmi.RemoteException;
import modelo.Ruta;

public class ControlRuta implements RemoteInterface {

    LinkedList<String> cosas;
    Graph<String> graph;
    
    public ControlRuta(){
        this.cosas = new LinkedList<>();
        this.graph = new Graph<>();
    }

    public LinkedList<String> rutaRecomendada(Ruta ruta){
        return graph.shortestPath(graph, ruta.getEstacion1().getNombre(), ruta.getEstacion2().getNombre());
    }
    
    @Override
    public LinkedList<Ruta> consultarDisponibles(){
        LinkedList<Ruta> rt = null;
        for(int i = 0; i < rt.size(); i++){
            graph.newEdge(rt.get(i).getEstacion1().getNombre(), rt.get(i).getEstacion2().getNombre(), (float) rt.get(i).getPrecio());
        }
        return rt;
    }
    
    public float valorRutaRecomendada(Ruta ruta){
        return graph.shortestPathKm(graph, ruta.getEstacion1().getNombre(), ruta.getEstacion2().getNombre());
    }
    
    public String seleccionEstaciones(Ruta ruta, String edge) {
        String start = "";
        start = edge;
        if (!start.startsWith(ruta.getEstacion1().getNombre()) || !start.endsWith(ruta.getEstacion2().getNombre())) {
            //no se puede
        }
        for (int i = 0; i < edge.length(); i++) {
            char base = edge.charAt(i);
            cosas.add(String.valueOf(base));
        }
        float totalWeight = calculateTotalWeight(graph, cosas);
        if (totalWeight == -1) {
            
        }
        return edge;
    }
    
    public float totalWeight(){
        return calculateTotalWeight(graph, cosas);
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

    @Override
    public LinkedList<Ruta> consultar(String direccion) throws RemoteException {
        //metodo que requiere de poder ver las rutas del json de rutas de la app baseAdmin
        return null;
    }

}
