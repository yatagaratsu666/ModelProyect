
package controlador;

import brenda.listsingly.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import modelo.Employee;
import modelo.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ControlLogin {
    
    ControlLogger cl;
    ControlEmpleado ce;
    LinkedList<Employee> base;
    
    public ControlLogin() throws RemoteException {
        cl = new ControlLogger();
        ce = new ControlEmpleado();
        base = ce.consultarDisponibles();
    }

    public boolean logIn(String username, String password) throws RemoteException {//ayuda porfavor
        boolean gotIt = false;
        LinkedList<User> users = obtenerUsuarios();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                gotIt = true;
            }
        }
        if (!gotIt) {
            cl.agregarEnLista("Intento fallido de ingreso a la cuenta");
        } else {
            cl.agregarEnLista("Empleado " + username + " ingreso con exito");
        }
        return gotIt;
    }

    public boolean logInA(String username, String password) throws RemoteException {//ayuda porfavor
        boolean gotIt = false;
        for (int i = 0; i < base.size(); i++) {
            if (base.get(i).getUser().equals(username) && base.get(i).getPassword().equals(password)) {
                gotIt = true;
            }
        }
        if (!gotIt) {
            cl.agregarEnLista("Intento fallido de ingreso a la cuenta");
        } else {
            cl.agregarEnLista("Empleado " + username + " ingreso con exito");
        }
        return gotIt;
    }

    public LinkedList<User> obtenerUsuarios() {
        LinkedList<User> listaUsers = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("user.json"));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonString.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRuta = jsonArray.getJSONObject(i);
                String nombre = jsonRuta.getString("person");
                String user = jsonRuta.getString("username");
                String pass = jsonRuta.getString("password");
                listaUsers.add(new User(user, pass, nombre));
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
