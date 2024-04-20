package modelo;

import brenda.array.Array;
import java.io.Serializable;

public class Employee extends AbstractPerson implements Serializable {

    private String id;

    public Employee() {
        super();
        this.id = "";
    }

    public Employee(String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Employee getNullEmployee() {
        return new Employee();
    }
}
