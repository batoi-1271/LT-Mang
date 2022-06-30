/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author truon
 */
public class TrienKhai extends  UnicastRemoteObject implements Service {
    public TrienKhai() throws RemoteException{
        super();
    }

    @Override
    public String process(String s) throws RemoteException {
        String x[] = s.split(",");
        String result="";
        for(String i : x){
            if (i.charAt(i.length()-1)=='2')result+=i+",";
        }
        return result;
    }

    @Override
    public boolean checkDX(String s) throws RemoteException {
        for(int i=0;i<s.length()/2;i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }

    @Override
    public String resultDX(String s) throws RemoteException {
        String x[] = s.split(" ");
        String result = "";
        for(String i : x){
            if(checkDX(i)) result+=i+",";
        }
        return result;
    }
    
}
