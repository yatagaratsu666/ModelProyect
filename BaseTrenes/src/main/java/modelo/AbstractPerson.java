
package modelo;

import brenda.array.Array;
import java.io.Serializable;

public abstract class AbstractPerson implements Serializable{
    protected String name;
    protected String lastName;
    protected Array<String> phoneNumbers;
    
    public AbstractPerson(){
        this.name = "";
        this.lastName = "";
        this.phoneNumbers = new Array<>(100);
        
    }

    protected AbstractPerson(String name, String lastName, Array<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    
}
