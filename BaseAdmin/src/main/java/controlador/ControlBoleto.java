
package controlador;

import brenda.array.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import modelo.Ruta;
import modelo.Boleto;
import modelo.Cliente;
import modelo.Tren;
import org.json.JSONArray;
import org.json.JSONObject;

public class ControlBoleto {

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
