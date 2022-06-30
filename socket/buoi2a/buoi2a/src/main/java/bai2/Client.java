/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author truon
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author truon
 */
public class Client {
    private int port;
    private byte[] receiveData,sendData;
    private DatagramSocket clientSocket;
    
    public Client(int port){
        this.port = port;
    }
    public void sendData(String str) throws SocketException, UnknownHostException, IOException{
        this.sendData = new byte[256];
        this.sendData = str.getBytes();
        // tao socket
        this.clientSocket = new DatagramSocket();
        // tao goi tin gui di thong qua IP address va port bat ki > 1023
        InetAddress IPAdress = InetAddress.getLocalHost();
        DatagramPacket sendPacket = new DatagramPacket(this.sendData,this.sendData.length,IPAdress,this.port);
        this.clientSocket.send(sendPacket);
    }
    public String getData() throws IOException{
        // nhan goi tin tu server
        this.receiveData = new byte[256];
        DatagramPacket receivePacket = new DatagramPacket(this.receiveData,this.receiveData.length);
        this.clientSocket.receive(receivePacket);
        String tl= new String(receivePacket.getData()).trim();
        return tl;
    }
}
