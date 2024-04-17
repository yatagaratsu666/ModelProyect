
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import modelo.Cliente;
import org.json.JSONArray;
import org.json.JSONObject;

public class ControlPasajero {
    private Array<Cliente> pasajeros;
    int size = 0;

    public ControlPasajero() {
        super();
        this.pasajeros = new Array(1000);
        LinkedList<Cliente> rutasExistentes = consultarPasajeros();
        Iterator<Cliente> ite = rutasExistentes.iterator();
        pasajeros.add(ite.next());
        agregarPasajero(ite.next());
    }

    public void agregarPasajero(Cliente pasajero) {
        pasajeros.add(pasajero);
        size++;
        guardarClienteEnJSON();
    }
    
    private void guardarClienteEnJSON() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            JSONObject jsonRuta = new JSONObject();
            jsonRuta.put("Nombre", pasajeros.get(i).getName());
            jsonRuta.put("Apellido", pasajeros.get(i).getLastName());
            jsonRuta.put("Identificacion", pasajeros.get(i).getIdentification());
            jsonRuta.put("Telefono1", pasajeros.get(i).getPhoneNumbers().get(0));
            jsonRuta.put("Telefono2", pasajeros.get(i).getPhoneNumbers().get(1));
            jsonArray.put(jsonRuta);
        }
        try (FileWriter file = new FileWriter("Clientes.json")) {
            file.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPasajero(String index) {
      for (int i = 0; i < size; i++) {
            if (pasajeros.get(i).getIdentification().equals(index)) {
                pasajeros.remove(i);
                pasajeros.defragment();
                size--;
                pasajeros.dimension(size);
                guardarClienteEnJSON();
                return;
            }
        }
    }

    public LinkedList<Cliente> consultarPasajeros() {
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        try {
            JSONArray jsonArray;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Clientes.json"), StandardCharsets.UTF_8))) {
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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRuta = jsonArray.getJSONObject(i);
                String nombre = jsonRuta.getString("Nombre");
                String apellido = jsonRuta.getString("Apellido");
                String id = jsonRuta.getString("Identificacion");
                Array<String> phoneNumbers = new Array(2);
                String tele1 = jsonRuta.getString("Telefono1");
                String tele2 = jsonRuta.getString("Telefono2");
                phoneNumbers.add(tele1);
                phoneNumbers.add(tele2);
                listaClientes.add(new Cliente(nombre, apellido, phoneNumbers, id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public Cliente buscarPasajeroPorIdentificacion(String identification) {
        Cliente clienteAux = new Cliente();
        for (int i = 0; i < size; i++) {
            if (pasajeros.get(i).getIdentification().equals(identification)) {
                try {
                    JSONArray jsonArray;
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Clientes.json"), StandardCharsets.UTF_8))) {
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
                    String apellido = jsonRuta.getString("Apellido");
                    String id = jsonRuta.getString("Identificacion");
                    Array<String> phoneNumbers = new Array(2);
                    String tele1 = jsonRuta.getString("Telefono1");
                    String tele2 = jsonRuta.getString("Telefono2");
                    phoneNumbers.add(tele1);
                    phoneNumbers.add(tele2);
                    clienteAux = new Cliente(nombre, apellido, phoneNumbers, id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clienteAux;
    }

    public LinkedList<Cliente> buscarPasajerosPorNombre(String nombre) {
        LinkedList<Cliente> clienteAux = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (pasajeros.get(i).getName().equals(nombre)) {
                try {
                    JSONArray jsonArray;
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Clientes.json"), StandardCharsets.UTF_8))) {
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
                    String nombres = jsonRuta.getString("Nombre");
                    String apellido = jsonRuta.getString("Apellido");
                    String id = jsonRuta.getString("Identificacion");
                    Array<String> phoneNumbers = new Array(2);
                    String tele1 = jsonRuta.getString("Telefono1");
                    String tele2 = jsonRuta.getString("Telefono2");
                    phoneNumbers.add(tele1);
                    phoneNumbers.add(tele2);
                    clienteAux.add(new Cliente(nombres, apellido, phoneNumbers, id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clienteAux;
    }
}
