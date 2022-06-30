/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woala
 */
public class TrienKhai extends UnicastRemoteObject   implements Service{

    public TrienKhai() throws RemoteException {
        super();
    }
    
    @Override
    public String readFile(String path) throws RemoteException {
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public String proccess(String path) throws RemoteException {
        
            String []s1 = this.readFile(path).split(",");
            int []a = new int[s1.length];
            for(int i=0; i<s1.length; i++) {
                a[i] = Integer.parseInt(s1[i]);
            }
            
            for(int i=0; i<a.length-1; i++) {
                for(int j=i+1; j<a.length; j++) {
                    if(a[i] > a[j]) {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                }
            }
            String kq = "";
            for(int i=0; i<a.length; i++)
                kq += a[i] + ",";
            
            return kq;
    }
    
}
