
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import modelo.Boleto;
import modelo.Cliente;
import modelo.Equipaje;
import modelo.Ruta;
import modelo.RutaEntity;
import modelo.Tren;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ControlBoleto extends UnicastRemoteObject implements RemoteBoleto {
    
    private final Array<Boleto> boletos;
    int size = 0;
    private final String filePath = "boletos.json";
    ControlTren ct;

    public JSONArray jsonArray;

    public ControlBoleto() throws RemoteException {
        super();
        this.ct = new ControlTren();
        this.boletos = new Array<>(1000);
        this.jsonArray = new JSONArray();
        Iterator<Boleto> ite = consultar(filePath).iterator();
        while (ite.hasNext()) {
            agregarEnLista(ite.next());
        }
    }

    @Override
    public void agregarEnLista(Boleto boleto) throws RemoteException{
        boletos.add(boleto);
        size++;
        guardarEnJSON(filePath);
    }

    public void guardarEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("fecha", boletos.get(i).getFechaCompra());
                jsonRuta.put("nombre", boletos.get(i).getCliente().getName());
                jsonRuta.put("apellido", boletos.get(i).getCliente().getLastName());
                jsonRuta.put("tel1", boletos.get(i).getCliente().getPhoneNumbers().get(0));
                jsonRuta.put("tel2", boletos.get(i).getCliente().getPhoneNumbers().get(1));
                jsonRuta.put("inicio", boletos.get(i).getTrayectoria().getInicio());
                jsonRuta.put("fin", boletos.get(i).getTrayectoria().getFin());
                jsonRuta.put("trayecto", boletos.get(i).getTrayectoria().getTrayecto());
                jsonRuta.put("id", boletos.get(i).getCliente().getIdentification());
                jsonRuta.put("categoria", boletos.get(i).getCategoria());
                jsonRuta.put("equipajes", boletos.get(i).getEquipaje().getCantidadEquipajes());
                jsonRuta.put("peso", boletos.get(i).getEquipaje().getPeso1());
                jsonRuta.put("precio", boletos.get(i).getPrecioTotal());
                jsonRuta.put("tren", boletos.get(i).getTren().getIdentificador());
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public LinkedList<Boleto> consultarBoletos() throws RemoteException {
        LinkedList<Boleto> bole = consultar(filePath);
        return bole;
    }
    
    
    public void modificarEstaciones(String nombre, String nuevo) {
        for (int j = 0; j < size; j++) {
            Boleto boleto = boletos.get(j);
            if (boleto.getTrayectoria().getInicio().equals(nombre)) {
                boleto.getTrayectoria().setInicio(nuevo);
            }
            if (boleto.getTrayectoria().getFin().equals(nombre)) {
                boleto.getTrayectoria().setFin(nuevo);
            }
        }
        guardarEnJSON(filePath);
    }

    public LinkedList<Boleto> consultarPorInicial(String text) throws RemoteException {
        LinkedList<Boleto> bole = consultar(filePath);
        LinkedList<Boleto> bol = new LinkedList<>();
        for (int i = 0; i < bole.size(); i++) {
            if (bole.get(i).getCliente().getName().toUpperCase().startsWith(text.toUpperCase())) {
                bol.add(bole.get(i));
            }
        }
        return bol;
    }
    
    public Boolean consultarPorId(String text) throws RemoteException {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (boletos.get(i).getCliente().getIdentification().equals(text)) {
                status = true;
            }
        }
        return status;
    }

    public LinkedList<Boleto> consultar(String direccion) throws RemoteException {
        LinkedList<Boleto> listaBoletos = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(direccion));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            if (jsonString.length() == 0 || jsonString.charAt(0) != '[') {
                return listaBoletos;
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonBoleto = jsonArray.getJSONObject(i);
                String fecha = jsonBoleto.getString("fecha");
                String nombre = jsonBoleto.getString("nombre");
                String apellido = jsonBoleto.getString("apellido");
                String tel1 = jsonBoleto.getString("tel1");
                String tel2 = jsonBoleto.getString("tel2");
                String inicio = jsonBoleto.getString("inicio");
                String fin = jsonBoleto.getString("fin");
                String trayecto = jsonBoleto.getString("trayecto");
                String id = jsonBoleto.getString("id");
                String categoria = jsonBoleto.getString("categoria");
                int equipaje = jsonBoleto.getInt("equipajes");
                int peso = jsonBoleto.getInt("peso");
                int precio = jsonBoleto.getInt("precio");
                String idTren = jsonBoleto.getString("tren");
                Tren tren = ct.buscarPasajeroPorIdentificacion(idTren);
                Array<String> array = new Array<>(2);
                array.add(tel1);
                array.add(tel2);
                Cliente cliente = new Cliente(nombre, apellido, array, id);
                Equipaje equipaje1 = new Equipaje(equipaje, peso);
                RutaEntity trayectoria = new RutaEntity(equipaje1, inicio, fin, trayecto, precio);
                listaBoletos.add(new Boleto(fecha, tren, cliente, equipaje1, categoria, trayectoria, precio));
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
        return listaBoletos;
    }
//    
//    public boolean eliminar (int index) {
//        boolean status=false;
//        for (int i = 0; i < size; i++) {
//            if (rutas.get(i).getId() == index) {
//                rutas.remove(i);
//                status = true;
//                rutas.defragment();
//                size--;
//                rutas.dimension(size);
//                guardarEnJSON(filePath);
//            }
//        }
//        return status;
//    }
//    
//    public boolean modificarRecorrido(int index, Ruta newRuta) {
//        boolean status = false;
//        for (int i = 0; i < size; i++) {
//            if (rutas.get(i).getId() == index) {
//                status = true;
//                rutas.get(i).setEstacion1(newRuta.getEstacion1());
//                rutas.get(i).setEstacion2(newRuta.getEstacion2());
//                rutas.get(i).setHorarios(newRuta.getHorarios());
//                rutas.get(i).setPrecio(newRuta.getPrecio());
//                rutas.get(i).setTren(newRuta.getTren());
//                guardarEnJSON(filePath);
//                break;
//            }
//        }
//        return status;
//    }
//
//    public void modificarEstaciones(String nombre, String nuevo) {
//        for (int j = 0; j < size; j++) {
//            Ruta ruta = rutas.get(j);
//            if (ruta.getEstacion1().getNombre().equals(nombre)) {
//                ruta.getEstacion1().setNombre(nuevo);
//            }
//            if (ruta.getEstacion2().getNombre().equals(nombre)) {
//                ruta.getEstacion2().setNombre(nuevo);
//            }
//        }
//        guardarEnJSON(filePath);
//    }
//
//    public LinkedList<Ruta> consultarDisponibles() throws RemoteException {
//        LinkedList<Ruta> lista = consultar(filePath);
//        return lista;
//    }
//    
//
//    public LinkedList<Ruta> consultar(String direccion) throws RemoteException {
//        LinkedList<Ruta> listaRutas = new LinkedList<>();
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(direccion));
//            StringBuilder jsonString = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonString.append(line);
//            }
//            JSONArray jsonArray = new JSONArray(jsonString.toString());
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonRuta = jsonArray.getJSONObject(i);
//                int id = jsonRuta.getInt("id");
//                String inicial = jsonRuta.getString("inicial");
//                String destino = jsonRuta.getString("destino");
//                String horarios = jsonRuta.getString("horarios");
//                float precio = jsonRuta.getFloat("precio");
//                Estacion estacion1 = new Estacion(inicial);
//                Estacion estacion2 = new Estacion(destino);
//                String tren = jsonRuta.getString("tren");
//                int idt = jsonRuta.getInt("capacidadTren");
//                String cap = jsonRuta.getString("idTren");
//                int cap1 = jsonRuta.getInt("Kilometraje");
//                Tren tren1 = new Tren(tren, cap, idt, cap1);
//                listaRutas.add(new Ruta(id, estacion1, estacion2, horarios, precio, tren1));
//            }
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return listaRutas;
//    }

//    public void consultarBoleto(String nombreCliente) {
//        try {
//            String contenido = new String(Files.readAllBytes(Paths.get("C:\\Users\\BRENDA\\Documents\\AAA\\boletos.json")));
//            JSONArray boletos = new JSONArray(contenido);
//
//            for (int i = 0; i < boletos.length(); i++) {
//                JSONObject boletoJSON = boletos.getJSONObject(i);
//                JSONObject clienteJSON = boletoJSON.getJSONObject("cliente");
//
//                String nombre = clienteJSON.getString("nombre");
//                if (nombre.equals(nombreCliente)) {
//                    System.out.println("Boleto encontrado para el cliente " + nombreCliente + ":");
//                    System.out.println(boletoJSON.toString());
//                    return;
//                }
//            }
//
//            System.out.println("No se encontró ningún boleto para el cliente: " + nombreCliente);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void validarBoleto(Cliente pasajero) {
//        try {
//            String contenido = new String(Files.readAllBytes(Paths.get("C:\\Users\\BRENDA\\Documents\\AAA\\boletos.json")));
//            JSONArray boletos = new JSONArray(contenido);
//
//            Array<String> telefonosPasajero = pasajero.getPhoneNumbers();
//            String nombrePasajero = pasajero.getName();
//
//            boolean clienteEncontrado = false;
//
//            for (int i = 0; i < boletos.length(); i++) {
//                JSONObject boletoJSON = boletos.getJSONObject(i);
//                JSONObject clienteJSON = boletoJSON.getJSONObject("cliente");
//
//                JSONArray telefonosCliente = clienteJSON.getJSONArray("phoneNumbers");
//
//                for (int j = 0; j < telefonosCliente.length(); j++) {
//                    String telefono = telefonosCliente.getString(j);
//                    if (telefonosPasajero.contains(telefono)) {
//                        clienteEncontrado = true;
//                        break;
//                    }
//                }
//
//                String nombreCliente = clienteJSON.getString("nombre");
//                if (nombreCliente.equals(nombrePasajero)) {
//                    clienteEncontrado = true;
//                }
//
//                if (clienteEncontrado) {
//                    consultarBoleto(nombrePasajero);
//                    break;
//                }
//            }
//
//            if (!clienteEncontrado) {
//                System.out.println("No se encontró ningún boleto para el cliente con nombre: " + nombrePasajero + " y números de teléfono: " + telefonosPasajero);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
