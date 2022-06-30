/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phantan.bai2;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author truon
 */
public class TrienKhai extends  UnicastRemoteObject implements findById{

    public TrienKhai() throws RemoteException{
        super();
    }
    @Override
    public String check(String s) throws RemoteException {
        try {
            FileInputStream filein = new FileInputStream("D://Sanphan.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(filein));
            String strLine;
            ArrayList<String> arrString = new ArrayList<>();
            while ((strLine = br.readLine()) != null)   {
                arrString.add(strLine);
            }
            for(String x : arrString){
                String id = x.substring(0, x.indexOf(";"));
                String name = x.substring(x.indexOf(";")+1);
                if(id.equals(s)) return "San pham "+id+" co ton tai, ten sp: "+name;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "San pham "+s+" khong ton tai";
    } 
}
