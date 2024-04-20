
package controlador;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import modelo.Employee;
import modelo.Estacion;
import modelo.Ruta;
import modelo.Tren;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ControlEmpleado {

    private final Array<Employee> empleado;
    int size = 0;
    private final String filePath = "empleado.json";

    public ControlEmpleado() throws RemoteException {
        this.empleado = new Array<>(1000);
        Iterator<Employee> ite = consultarDisponibles().iterator();
        while (ite.hasNext()) {
            agregarEnLista(ite.next());
        }
    }

    public void agregarEnLista(Employee employee) {
        empleado.add(employee);
        size++;
        guardarEnJSON(filePath);
    }
    
    public void guardarEnJSON(String direccion) {
        try (FileWriter file = new FileWriter(direccion)) {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("id", empleado.get(i).getId());
                jsonRuta.put("nombre", empleado.get(i).getName());
                jsonRuta.put("apellido", empleado.get(i).getLastName());
                jsonRuta.put("telefono1", empleado.get(i).getPhoneNumbers().get(0));
                jsonRuta.put("telefono2", empleado.get(i).getPhoneNumbers().get(1));
                jsonRuta.put("user", empleado.get(i).getUser());
                jsonRuta.put("password", empleado.get(i).getPassword());
                jsonArray.put(jsonRuta);
            }
            file.write(jsonArray.toString(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean eliminar(String index) {
        boolean status=false;
        for (int i = 0; i < size; i++) {
            if (empleado.get(i).getId().equals(index)) {
                empleado.remove(i);
                status = true;
                empleado.defragment();
                size--;
                empleado.dimension(size);
                guardarEnJSON(filePath);
            }
        }
        return status;
    }
    
    public boolean modificarRecorrido(String index, Employee employee) {
        boolean status = false;
        for (int i = 0; i < size; i++) {
            if (empleado.get(i).getId().equals(index)) {
                status = true;
                empleado.get(i).setName(employee.getName());
                empleado.get(i).setLastName(employee.getLastName());
                empleado.get(i).setPhoneNumbers(employee.getPhoneNumbers());
                empleado.get(i).setUser(employee.getUser());
                empleado.get(i).setPassword(employee.getPassword());
                guardarEnJSON(filePath);
                break;
            }
        }
        return status;
    }
    
    public LinkedList<Employee> consultarDisponibles() throws RemoteException {
        LinkedList<Employee> lista = consultar(filePath);
        return lista;
    }
    

    public LinkedList<Employee> consultar(String direccion) throws RemoteException {
        LinkedList<Employee> listaRutas = new LinkedList<>();
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
                String id = jsonRuta.getString("id");
                String nombre = jsonRuta.getString("nombre");
                String apellido = jsonRuta.getString("apellido");
                String telefono1 = jsonRuta.getString("telefono1");
                String telefono2 = jsonRuta.getString("telefono2");
                String user = jsonRuta.getString("user");
                String pass = jsonRuta.getString("password");
                Array<String> array = new Array<>(2);
                array.add(telefono1);
                array.add(telefono2);
                listaRutas.add(new Employee(nombre, apellido, array, id, user, pass));
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
