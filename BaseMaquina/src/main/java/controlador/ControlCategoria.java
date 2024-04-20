
package controlador;

import brenda.array.Array;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Categoria;
import modelo.Tren;
import modelo.TrenEntity;
import org.json.JSONObject;


public class ControlCategoria {
    Array<Categoria> array;
    TrenEntity te;
    ControlTren ct;
    int size = 0;
    float precio =0;
    
    public ControlCategoria(){
        this.ct = new ControlTren();
    }
    
    public ControlCategoria(Tren tren){
        this.ct = new ControlTren();
        this.array = new Array<>(tren.getCapacidadCarga());
        for (int i = 0; i < array.size(); i++) {
            array.add(new Categoria());
            size++;
        }
    }
    
   public void seleccionarPuesto(int vagon, String categoria, int seccion){
        if (vagon < 0 || vagon >= size) {
            return;
        }
        
        Categoria categoriaVagon = array.get(vagon);
        if (categoriaVagon == null) {
            return;
        }
        categoriaVagon.seleccionarVagon(categoria, seccion);
        precio = categoriaVagon.getValor();
    }
   
    public float valor(){
        return precio;
    }
    
    public TrenEntity cargarJSON() {
        try {
            File archivo = new File("vagones.json");
            if (archivo.exists() && archivo.length() > 0) {
                StringBuilder jsonString = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonString.append(line);
                    }
                }
                JSONObject jsonCliente = new JSONObject(jsonString.toString());
                String nombre = jsonCliente.getString("tren");
                Tren tren = ct.seleccionarTren(nombre);
                int vagon = jsonCliente.getInt("vagon");
                String categoria = jsonCliente.getString("categoria");
                int seccion = jsonCliente.getInt("seccion");
                float valor = jsonCliente.getFloat("valor");
                this.te = new TrenEntity(tren, vagon, categoria, seccion, valor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return te;
    }

    public void guardarClienteEnJSON(Tren tren, int vagon, String categoria, int seccion, float valor) {
        JSONObject jsonCliente = new JSONObject();
        jsonCliente.put("tren", tren.getIdentificador());
        jsonCliente.put("vagon", vagon);
        jsonCliente.put("categoria", categoria);
        jsonCliente.put("seccion", seccion);
        jsonCliente.put("valor", valor);

        try (FileWriter file = new FileWriter("vagones.json")) {
            file.write(jsonCliente.toString(4));
            System.out.println("Cliente guardado en vagones.json correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
