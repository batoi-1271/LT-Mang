/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author woala
 */
public interface Service extends Remote{
    String readFile(String path) throws RemoteException;
    String proccess(String path) throws RemoteException;
}
