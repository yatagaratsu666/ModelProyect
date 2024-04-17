
package modelo;

import brenda.array.Array;

public class Employee extends AbstractPerson {
    
    private String id;
    
    public Employee(){
        super();
        this.id = "";
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String name, String lastName, Array<String> phoneNumbers) {
        super(name, lastName, phoneNumbers);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static Employee getNullEmployee(){
        return new Employee();
    }
}
