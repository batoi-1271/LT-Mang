/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import RMI.TrienKhai;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woala
 */
public class xulyServer {
        private DatagramSocket socket;
    private byte[] receiveData, sendData;
    private int port;
    private  DatagramPacket receivePacket;
    private  DatagramPacket sendPacket;
    
    public xulyServer(int port) {
        this.port = port;
    }

    public String Get_DL() throws SocketException, IOException {
        //b1
        this.socket = new DatagramSocket(this.port);
        //b2" nhan dl
        this.receiveData = new byte[256];
        this.receivePacket = new DatagramPacket(this.receiveData, this.receiveData.length);
        this.socket.receive(this.receivePacket);
        //b3: xu ly
        String s = new String(this.receivePacket.getData()).trim();
        return s;
    }
     public String readFile(String path) throws RemoteException {
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public void Send_DL(String path) throws IOException {
        
             String tl = "";
            String result = "";
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
            for(int i=0; i<a.length; i++)
                result += a[i] + ",";
            
        tl = "Ket qua la: " + result;

             
        //b4
        this.sendData = new byte[256];
        this.sendData = tl.getBytes();
        this.sendPacket = new DatagramPacket(this.sendData, this.sendData.length, this.receivePacket.getAddress(), this.receivePacket.getPort());
        this.socket.send(this.sendPacket);
    }
    
    
}
