package modelo;

import brenda.array.Array;
import java.io.Serializable;

public class Employee extends AbstractPerson implements Serializable {

    private String id;
    private String user;
    private String password;

    public Employee() {
        super();
        this.id = "";
    }

    public Employee(String names, String lastNames, Array<String> phoneNumbers, String id, String user, String password) {
        super(names, lastNames, phoneNumbers);
        this.id = id;
        this.user = user;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public static Employee getNullEmployee() {
        return new Employee();
    }
}
