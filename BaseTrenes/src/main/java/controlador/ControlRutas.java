package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Ruta;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import modelo.Estacion;
import modelo.Tren;
import org.json.JSONException;

public class ControlRutas extends UnicastRemoteObject implements RemoteInterface, Serializable {

    private final Array<Ruta> rutas;
    int size = 0;
    private final String filePath = "rutas.json";

    public JSONArray jsonArray;

    public ControlRutas() throws RemoteException {
        super();
        this.rutas = new Array<>(1000);
        this.jsonArray = new JSONArray();
        LinkedList<Ruta> rutasExistentes = consultar(filePath);
        Iterator<Ruta> ite = rutasExistentes.iterator();
        while (ite.hasNext()) {
            agregarEnLista(ite.next());
        }
    }

    public void agregarEnLista(Ruta ruta) {
        rutas.add(ruta);
        size++;
        guardarEnJSON(filePath);
    }

    public void guardarEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("id", rutas.get(i).getId());
                jsonRuta.put("inicial", rutas.get(i).getEstacion1().getNombre());
                jsonRuta.put("destino", rutas.get(i).getEstacion2().getNombre());
                jsonRuta.put("horarios", rutas.get(i).getHorarios());
                jsonRuta.put("precio", rutas.get(i).getPrecio());
                jsonRuta.put("tren", rutas.get(i).getTren().getNombre());
                jsonRuta.put("idTren", rutas.get(i).getTren().getIdentificador());
                jsonRuta.put("capacidadTren", rutas.get(i).getTren().getCapacidadCarga());
                jsonRuta.put("Kilometraje", rutas.get(i).getTren().getKilometraje());
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean eliminar (int index) {
        boolean status=false;
        for (int i = 0; i < size; i++) {
            if (rutas.get(i).getId() == index) {
                rutas.remove(i);
                status = true;
                rutas.defragment();
                size--;
                rutas.dimension(size);
                guardarEnJSON(filePath);
            }
        }
        return status;
    }
    
    public boolean modificarRecorrido(int index, Ruta newRuta) {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (rutas.get(i).getId() == index) {
                status = true;
                rutas.get(i).setEstacion1(newRuta.getEstacion1());
                rutas.get(i).setEstacion2(newRuta.getEstacion2());
                rutas.get(i).setHorarios(newRuta.getHorarios());
                rutas.get(i).setPrecio(newRuta.getPrecio());
                rutas.get(i).setTren(newRuta.getTren());
                guardarEnJSON(filePath);
                break;
            }
        }
        return status;
    }

    public void modificarEstaciones(String nombre, String nuevo) {
        for (int j = 0; j < size; j++) {
            Ruta ruta = rutas.get(j);
            if (ruta.getEstacion1().getNombre().equals(nombre)) {
                ruta.getEstacion1().setNombre(nuevo);
            }
            if (ruta.getEstacion2().getNombre().equals(nombre)) {
                ruta.getEstacion2().setNombre(nuevo);
            }
        }
        guardarEnJSON(filePath);
    }

    @Override
    public LinkedList<Ruta> consultarDisponibles() throws RemoteException {
        LinkedList<Ruta> lista = consultar(filePath);
        return lista;
    }
    

    public LinkedList<Ruta> consultar(String direccion) throws RemoteException {
        LinkedList<Ruta> listaRutas = new LinkedList<>();
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
                int id = jsonRuta.getInt("id");
                String inicial = jsonRuta.getString("inicial");
                String destino = jsonRuta.getString("destino");
                String horarios = jsonRuta.getString("horarios");
                float precio = jsonRuta.getFloat("precio");
                Estacion estacion1 = new Estacion(inicial);
                Estacion estacion2 = new Estacion(destino);
                String tren = jsonRuta.getString("tren");
                int idt = jsonRuta.getInt("capacidadTren");
                String cap = jsonRuta.getString("idTren");
                int cap1 = jsonRuta.getInt("Kilometraje");
                Tren tren1 = new Tren(tren, cap, idt, cap1);
                listaRutas.add(new Ruta(id, estacion1, estacion2, horarios, precio, tren1));
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
}
