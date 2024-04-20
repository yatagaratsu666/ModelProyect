/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import brenda.listsingly.LinkedList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import modelo.Tren;

/**
 *
 * @author BRENDA
 */
public interface RemoteTren extends Remote {
    public LinkedList<Tren> consultarTrenDisponibles() throws RemoteException;
}
