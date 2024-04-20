
package modelo;

import brenda.grafo.Graph;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de selección de vagones:");

        while (true) {
            System.out.print("¿Qué tipo de vagon quieres (premium/estandar/ejecutivo)? o 'salir' para salir: ");
            String tipo = scanner.nextLine().toLowerCase();
            if (tipo.equals("salir")) {
                break;
            }

            System.out.print("Ingresa el número de vagon que deseas: ");
            int numeroDeseado = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            
            int vagonSeleccionado = categoria.seleccionarVagon(tipo, numeroDeseado);
            if (vagonSeleccionado != -1) {
                System.out.println("Has seleccionado el vagon " + vagonSeleccionado + " de tipo " + tipo + ".");
            } else {
                System.out.println("Lo siento, no se pudo seleccionar el vagon deseado.");
            }
        }

        scanner.close();
    }
//        Categoria estandar = new Categoria("Premium");
//
//        // Reservar un asiento en el vagon 0, seccion 2
//        int seccionReservada = estandar.reservarAsiento(0, 1);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
//
//        seccionReservada = estandar.reservarAsiento(0, 2);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
//        seccionReservada = estandar.reservarAsiento(0, 3);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
//        seccionReservada = estandar.reservarAsiento(0, 0);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
//        seccionReservada = estandar.reservarAsiento(1, 0);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
//                seccionReservada = estandar.reservarAsiento(1, 0);
//        if (seccionReservada != -1) {
//            System.out.println("Asiento reservado exitosamente en el vagon 0, seccion " + seccionReservada);
//        } else {
//            System.out.println("No hay asientos disponibles en el vagon 0, seccion 2.");
//        }
    }
    // Crear una instancia de Graph
//        Graph<String> graph = new Graph<>();
//
//        // Agregar nodos al grafo
//        graph.newNode("A");
//        graph.newNode("B");
//        graph.newNode("C");
//        graph.newNode("D");
//
//        // Agregar aristas entre nodos
//        graph.newEdge("A", "B", 5);
//        graph.newEdge("B", "C", 3);
//        graph.newEdge("B", "D", 1);
//         graph.newEdge("D", "C", 1);
//
//        // Calcular la distancia del camino más corto entre dos nodos
//        float shortestDistance = graph.shortestPathKm(graph, "A", "C");
//        System.out.println("La distancia del camino más corto entre A y C es: " + shortestDistance + " km");
//
//        // Calcular el camino más corto entre dos nodos
//        LinkedList<String> shortestPath = graph.shortestPath(graph, "A", "C");
//        System.out.println("El camino más corto entre A y C es: ");
//        Iterator iterator = shortestPath.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        
