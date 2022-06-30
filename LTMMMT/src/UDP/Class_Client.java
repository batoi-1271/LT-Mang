/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author woala
 */
public class Class_Client {
    private int port;
    private byte[] receiveData, sendData;
    private  DatagramSocket clientSocket;
    
    public Class_Client(int port) {
        this.port = port;
    }
    
    public void Send_DL(String s) throws SocketException, UnknownHostException, IOException {
        this.sendData = new byte[256];
        this.sendData = s.getBytes();
        
        //Tao socket
        this.clientSocket = new DatagramSocket();
        //Tao goi tin gui di thong qua IP address va port bat ki ? 12024
        InetAddress IPAddress = InetAddress.getLocalHost();
        DatagramPacket sendPacket = new DatagramPacket(this.sendData, this.sendData.length, IPAddress, this.port);
        this.clientSocket.send(sendPacket);
    }
    
    public String Get_DL() throws IOException {
        //nhan goi tin tu server
        this.receiveData = new byte[256];
        DatagramPacket receivePacket = new DatagramPacket(this.receiveData, this.receiveData.length);
        this.clientSocket.receive(receivePacket);
        String tl = new String(receivePacket.getData()).trim();
        return tl;
    }
    
    
    
}
