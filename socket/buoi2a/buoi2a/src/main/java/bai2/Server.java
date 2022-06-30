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

public class Server {
    private int port;
    private DatagramSocket socket;
    private byte[] receiveData,sendData;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;

    public Server(int port){
        this.port = port;
    }
    public boolean checkString(String str){
        for(int i=0;i<=str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)) return false;
        }
        return true;
    }
    public String getData() throws IOException {
        this.socket = new DatagramSocket(this.port);
        //nhan dl
        this.receiveData = new byte[256];
        this.receivePacket = new DatagramPacket(this.receiveData,this.receiveData.length);
        this.socket.receive(this.receivePacket);
        //xly
        String str = new String(receivePacket.getData()).trim();
        return str;
    }
    public void sendData(String str) throws IOException {
        String tl="";
        if(checkString(str)) tl="Chuoi doi xung";
        else tl="Chuoi khong doi xung";
        this.sendData = new byte[256];
        this.sendData = tl.getBytes();
        //this.sendPacket = new DatagramSocket(this.sendData,this.sendData.length,this.receivePacket,this.receivePacket.getPort());
        this.sendPacket = new DatagramPacket(this.sendData,this.sendData.length,this.receivePacket.getAddress(),this.receivePacket.getPort());
        this.socket.send(this.sendPacket);

    }
}