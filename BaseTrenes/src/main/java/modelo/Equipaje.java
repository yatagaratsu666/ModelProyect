
package modelo;

import java.io.Serializable;


public class Equipaje implements Serializable{
   private int cantidadEquipajes;
    private int peso1;
    
    public Equipaje(){
        
    }

    public Equipaje(int cantidadEquipajes, int peso1) {
        this.cantidadEquipajes = cantidadEquipajes;
        this.peso1 = peso1;
    }

    public int getCantidadEquipajes() {
        return cantidadEquipajes;
    }

    public void setCantidadEquipajes(int cantidadEquipajes) {
        this.cantidadEquipajes = cantidadEquipajes;
    }

    public int getPeso1() {
        return peso1;
    }

    public void setPeso1(int peso1) {
        this.peso1 = peso1;
    }

    public boolean isValid() {
        return peso1 < 80;
    }
}
