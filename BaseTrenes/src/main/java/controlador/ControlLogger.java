
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Ruta;
import modelo.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ControlLogger {
    
    Array<String> msg;
    int size = 0;
    String filePath = "logger.json";
    
    public ControlLogger() {
        msg = new Array(1000);
        Iterator<String> ite = obtenerUsuarios().iterator();
        while (ite.hasNext()) {
            agregarEnLista(ite.next());
        }
    }

    public void agregarEnLista(String dato) {
        msg.add(dato);
        size++;
        guardarEnJSON(filePath);
    }
    
        public void guardarEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("accion", msg.get(i));
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> obtenerUsuarios() {
        LinkedList<String> listaUsers = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            if (jsonString.length() == 0) {
                return listaUsers;
            } else {

                JSONArray jsonArray = new JSONArray(jsonString.toString());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonRuta = jsonArray.getJSONObject(i);
                    String accion = jsonRuta.getString("accion");
                    listaUsers.add(accion);
                }
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
        return listaUsers;
    }
}
