/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phantan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author truon
 */
public class TrienKhai extends UnicastRemoteObject implements KTNT_HH{

    public TrienKhai() throws RemoteException {
        super();
    }
    @Override
    public boolean checkSNT(int n) throws RemoteException {
        if(n<2) return false;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    @Override
    public boolean checkHH(int n) throws RemoteException {
        int tong=0;
        for(int i=1;i<=n/2;i++)
            if(n%i==0) tong+=i;
        return tong==n ? true : false;
    }
    
}
