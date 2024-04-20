
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import modelo.Tren;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ControlTren extends UnicastRemoteObject implements RemoteTren, Serializable{

    private final Array<Tren> trenes;
    int size = 0;
    private final String filePath = "trenes.json";

    public JSONArray jsonArray;
    
    public ControlTren() throws RemoteException{
        this.trenes = new Array<>(1000);
        this.jsonArray = new JSONArray();
        LinkedList<Tren> rutasExistentes = consultarTrenDisponibles();
        Iterator<Tren> ite = rutasExistentes.iterator();
        while (ite.hasNext()) {
            agregarTrenEnLista(ite.next());
        }
    }
    
    public void agregarTrenEnLista(Tren tren) {
        trenes.add(tren);
        size++;
        guardarRutasEnJSON(filePath);
    }
    
    private void guardarRutasEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("Nombre", trenes.get(i).getNombre());
                jsonRuta.put("Carga", trenes.get(i).getCapacidadCarga());
                jsonRuta.put("Identificador", trenes.get(i).getIdentificador());
                jsonRuta.put("Kilometraje", trenes.get(i).getKilometraje());
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(4));
        } catch (IOException e) {
        }
    }

    public boolean bajarTren(String index) {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (trenes.get(i).getIdentificador().equals(index)) {
                status = true;
                trenes.remove(i);
                trenes.defragment();
                size--;
                trenes.dimension(size);
                guardarRutasEnJSON(filePath);
            }
        }
        return status;
    }

    public boolean modificarRecorrido(String index, Tren newTren) {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (trenes.get(i).getIdentificador().equals(index)) {
                status = true;
                trenes.get(i).setNombre(newTren.getNombre());
                trenes.get(i).setCapacidadCarga(newTren.getCapacidadCarga());
                trenes.get(i).setKilometraje(newTren.getKilometraje());
                guardarRutasEnJSON(filePath);
                break;
            }
        }
        return status;
    }

    @Override
    public LinkedList<Tren> consultarTrenDisponibles() throws RemoteException{
        LinkedList lista = consultarRutas(filePath);
        return lista;
    }
    
    public LinkedList<Tren> consultarRutas(String direccion) {
        LinkedList<Tren> listaRutas = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(direccion));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonString.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRuta = jsonArray.getJSONObject(i);
                String nombre = jsonRuta.getString("Nombre");
                int carga = jsonRuta.getInt("Carga");
                String id = jsonRuta.getString("Identificador");
                int kilometraje = jsonRuta.getInt("Kilometraje");
                listaRutas.add(new Tren(nombre, id, carga, kilometraje));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaRutas;
    }
    
    public Tren convertirObjecto(String id, String nombre){
        return new Tren(nombre, id);
    }

//    public Object[] noseXD(Tren rutas) {
//        Object[] fila = {
//            rutas.getIdentificador(),
//            rutas.getNombre(),
//            rutas.getCapacidadCarga(),
//            rutas.getKilometraje()
//        };
//        return fila;
//    }

    public Tren buscarPasajeroPorIdentificacion(String identification) {
        Tren clienteAux = new Tren();
        for (int i = 0; i < size; i++) {
            if (trenes.get(i).getIdentificador().equals(identification)) {
                try {
                    JSONArray jsonArray;
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("trenes.json"), StandardCharsets.UTF_8))) {
                        StringBuilder jsonString = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            jsonString.append(line);
                        }
                        jsonArray = new JSONArray(jsonString.toString());
                    }

                    if (jsonArray.length() == 0) {
                        return null;
                    }
                    JSONObject jsonRuta = jsonArray.getJSONObject(i);
                    String nombre = jsonRuta.getString("Nombre");
                    int carga = jsonRuta.getInt("Carga");
                    String id = jsonRuta.getString("Identificador");
                    int kilo = jsonRuta.getInt("Kilometraje");
                    clienteAux = new Tren(nombre, identification, carga, kilo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clienteAux;
    }
    
    
}
