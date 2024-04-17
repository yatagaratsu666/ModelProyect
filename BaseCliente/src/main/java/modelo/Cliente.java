
package modelo;

import brenda.array.Array;
import java.io.Serializable;

public class Cliente extends AbstractPerson implements Serializable {
    
    private String identification;
    
    public Cliente() {
        super();
        this.identification = "";
    }

    public Cliente(String name, String lastName, Array<String> phoneNumbers, String identification) {
        super(name, lastName, phoneNumbers);
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
