/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.buoi2a;

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
    public int UCLN(int a,int b){
        while (a!=b){
            if(a>b) a-=b;
            else b-=a;
        }
        return a;
    }
    public float tinh(int a,int b,String s){
        if(s.equals("+"))
            return a+b;
        else if(s.equals("-"))
            return a-b;
        else if(s.equals("*"))
            return a*b;
        else if(s.equals("/"))
            return a/(float)b;
        return 0;
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
        String[] s = str.split(",");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        String x = s[2];
//        if(UCLN(a,b)==1) tl="Hai so nguyen to cung nhau";
//        else tl="Hai so khong nguyen to cung nhau";
        tl = "ket qua la: "+ String.valueOf(tinh(a,b,x));
        this.sendData = new byte[256];
        this.sendData = tl.getBytes();
        //this.sendPacket = new DatagramSocket(this.sendData,this.sendData.length,this.receivePacket,this.receivePacket.getPort());
        this.sendPacket = new DatagramPacket(this.sendData,this.sendData.length,this.receivePacket.getAddress(),this.receivePacket.getPort());
        this.socket.send(this.sendPacket);

    }
    public void close(){
        this.socket.close();
    }
}
