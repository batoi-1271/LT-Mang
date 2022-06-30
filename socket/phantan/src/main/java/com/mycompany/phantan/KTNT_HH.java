/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phantan;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author truon
 */
public interface KTNT_HH extends Remote{
    boolean checkSNT(int n) throws RemoteException;
    boolean checkHH(int n) throws RemoteException;
}
