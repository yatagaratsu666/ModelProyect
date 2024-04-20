/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import modelo.Cliente;
import modelo.Equipaje;
import modelo.RutaEntity;
import org.json.JSONArray;
import org.json.JSONObject;


public class ControlCliente {
    
    private Cliente cliente;

    public ControlCliente() {
        super();
        cargarClienteDesdeJSON();
    }

    public void agregarClienteSiVacioModificarSiNo(Cliente nuevoCliente) {
        if (cliente == null) {
            this.cliente = nuevoCliente;
        } else {
            this.cliente = nuevoCliente;
        }
        guardarClienteEnJSON();
    }

    public Cliente cargarClienteDesdeJSON() {
        try {
            File archivo = new File("clientes.json");
            if (archivo.exists() && archivo.length() > 0) {
                StringBuilder jsonString = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonString.append(line);
                    }
                }
                JSONObject jsonCliente = new JSONObject(jsonString.toString());
                String nombre = jsonCliente.getString("Nombre");
                String apellido = jsonCliente.getString("Apellido");
                String identificacion = jsonCliente.getString("Identificacion");
                String telefono1 = jsonCliente.getString("Telefono1");
                String telefono2 = jsonCliente.getString("Telefono2");
                Array<String> tel = new Array(2);
                tel.add(telefono1);
                tel.add(telefono2);
                this.cliente = new Cliente(nombre, apellido, tel, identificacion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    private void guardarClienteEnJSON() {
        JSONObject jsonCliente = new JSONObject();
        jsonCliente.put("Nombre", cliente.getName());
        jsonCliente.put("Apellido", cliente.getLastName());
        jsonCliente.put("Identificacion", cliente.getIdentification());
        jsonCliente.put("Telefono1", cliente.getPhoneNumbers().get(0));
        jsonCliente.put("Telefono2", cliente.getPhoneNumbers().get(1));

        try (FileWriter file = new FileWriter("clientes.json")) {
            file.write(jsonCliente.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

//    public Cliente buscarPasajeroPorIdentificacion(String identification) {
//        Cliente clienteAux = new Cliente();
//        for (int i = 0; i < size; i++) {
//            if (pasajeros.get(i).getIdentification().equals(identification)) {
//                try {
//                    JSONArray jsonArray;
//                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("clienteAux.json"), StandardCharsets.UTF_8))) {
//                        StringBuilder jsonString = new StringBuilder();
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            jsonString.append(line);
//                        }
//                        jsonArray = new JSONArray(jsonString.toString());
//                    }
//
//                    if (jsonArray.length() == 0) {
//                        return null;
//                    }
//                    JSONObject jsonRuta = jsonArray.getJSONObject(i);
//                    String nombre = jsonRuta.getString("Nombre");
//                    String apellido = jsonRuta.getString("Apellido");
//                    String id = jsonRuta.getString("Identificacion");
//                    Array<String> phoneNumbers = new Array(2);
//                    String tele1 = jsonRuta.getString("Telefono1");
//                    String tele2 = jsonRuta.getString("Telefono2");
//                    phoneNumbers.add(tele1);
//                    phoneNumbers.add(tele2);
//                    clienteAux = new Cliente(nombre, apellido, phoneNumbers, id);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return clienteAux;
//    }

//    public LinkedList<Cliente> buscarPasajerosPorNombre(String nombre) {
//        LinkedList<Cliente> clienteAux = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            if (pasajeros.get(i).getName().equals(nombre)) {
//                try {
//                    JSONArray jsonArray;
//                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("clienteAux.json"), StandardCharsets.UTF_8))) {
//                        StringBuilder jsonString = new StringBuilder();
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            jsonString.append(line);
//                        }
//                        jsonArray = new JSONArray(jsonString.toString());
//                    }
//
//                    if (jsonArray.length() == 0) {
//                        return clienteAux;
//                    }
//                    JSONObject jsonRuta = jsonArray.getJSONObject(i);
//                    String nombres = jsonRuta.getString("Nombre");
//                    String apellido = jsonRuta.getString("Apellido");
//                    String id = jsonRuta.getString("Identificacion");
//                    Array<String> phoneNumbers = new Array(2);
//                    String tele1 = jsonRuta.getString("Telefono1");
//                    String tele2 = jsonRuta.getString("Telefono2");
//                    phoneNumbers.add(tele1);
//                    phoneNumbers.add(tele2);
//                    clienteAux.add(new Cliente(nombres, apellido, phoneNumbers, id));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return clienteAux;
//    }
