
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import modelo.Estacion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ControlEstacion implements RemoteInterface<Estacion> {

    private final Array<Estacion> estaciones;
    int size = 0;
    private final String filePath = "estacion.json";

    public JSONArray jsonArray;

    public ControlEstacion() {
        super();
        this.estaciones = new Array<>(1000);
        this.jsonArray = new JSONArray();
        LinkedList<Estacion> rutasExistentes = consultarDisponibles();
        Iterator<Estacion> ite = rutasExistentes.iterator();
        while (ite.hasNext()) {
            agregarEst(ite.next());
        }
    }
    
    public void agregarEst(Estacion est) {
        estaciones.add(est);
        size++;
        guardarEnJSON(filePath);
    }
    
    public Estacion volverObjeto(String nombre){
        return new Estacion(nombre);
    }
    
    public void guardarEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("nombre", estaciones.get(i).getNombre());
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean modificarRecorrido(String est, String newEst) {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (estaciones.get(i).getNombre().equals(est)) {
                status = true;
                estaciones.get(i).setNombre(newEst);
                guardarEnJSON(filePath);
                break;
            }
        }
        return status;
    }
    
    @Override
    public LinkedList<Estacion> consultarDisponibles(){
        return consultar(filePath);
    }

    @Override
    public LinkedList<Estacion> consultar(String direccion) {
        LinkedList<Estacion> listaEst = new LinkedList<>();
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
                String nombre = jsonRuta.getString("nombre");
                listaEst.add(new Estacion(nombre));
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
        return listaEst;
    }

    public Estacion buscarPasajeroPorIdentificacion(String id) throws FileNotFoundException, IOException {
        Estacion clienteAux = new Estacion();
        for (int i = 0; i < size; i++) {
            if (estaciones.get(i).getNombre().equals(id))
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("estacion.json"), StandardCharsets.UTF_8))) {
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
            String nombre = jsonRuta.getString("nombre");
        }
        return null;
    }
}
