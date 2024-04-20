
package controlador;

import brenda.listsingly.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import modelo.Equipaje;
import modelo.Estacion;
import modelo.Ruta;
import modelo.RutaEntity;
import modelo.Tren;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ControlEquipaje {

    private Equipaje equipaje;
    private RutaEntity trayectoria;

    public ControlEquipaje() {
        super();
        equipaje = new Equipaje();
        trayectoria = cargarClienteDesdeJSON();
    }

    public Boolean agregarClienteSiVacioModificarSiNo(int cant, int peso, String inicio, String fin, String trayecto, Float precio) {
        Equipaje equiAux = new Equipaje(cant, peso);
        if (equiAux.isValid()) {
            this.equipaje = equiAux;
            RutaEntity trayeAux = new RutaEntity(equipaje, inicio, fin, trayecto, precio);
            this.trayectoria = trayeAux;
            guardarClienteEnJSON();
            return true;
        } else {
            return false;
        }
    }
    

    public RutaEntity cargarClienteDesdeJSON() {
        try {
            File archivo = new File("traye.json");
            if (archivo.exists() && archivo.length() > 0) {
                StringBuilder jsonString = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonString.append(line);
                    }
                }
                JSONObject jsonCliente = new JSONObject(jsonString.toString());
                int cantidad = jsonCliente.getInt("cantidad");
                int pesoTotal = jsonCliente.getInt("peso");
                String inicio = jsonCliente.getString("inicio");
                String fin = jsonCliente.getString("fin");
                String traye = jsonCliente.getString("trayecto");
                float precio = jsonCliente.getFloat("precio");
                this.equipaje = new Equipaje(cantidad, pesoTotal);
                this.trayectoria = new RutaEntity(equipaje, inicio, fin, traye, precio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trayectoria;
    }

    private void guardarClienteEnJSON() {
        JSONObject jsonCliente = new JSONObject();
        jsonCliente.put("cantidad", equipaje.getCantidadEquipajes());
        jsonCliente.put("peso", equipaje.getPeso1());
        jsonCliente.put("inicio", trayectoria.getInicio());
        jsonCliente.put("fin", trayectoria.getFin());
        jsonCliente.put("trayecto", trayectoria.getTrayecto());
        jsonCliente.put("precio", trayectoria.getPrecio());
        try (FileWriter file = new FileWriter("traye.json")) {
            file.write(jsonCliente.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
