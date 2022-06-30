/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phantan.bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author truon
 */
public interface findById extends Remote{
    String check(String s) throws RemoteException;
}
