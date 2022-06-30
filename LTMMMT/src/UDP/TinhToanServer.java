/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author BaToi
 */
public class TinhToanServer {
    private DatagramSocket socket;
    private byte[] receiveData, sendData;
    private int port;
    private  DatagramPacket receivePacket;
    private  DatagramPacket sendPacket;
    
    public TinhToanServer(int port) {
        this.port = port;
    }
    
    public int us(int a, int b) {
        while(a != b) {
            if (a > b) a = a -b;
            else 
                b = b - a;
        }
        return a;
            
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
    
    public void Send_DL(String s) throws IOException {
        String tl = "";
        int result = 0;
        String []s1 = s.split(",");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1]);
        //        String op = s1[2];
//        switch(op.charAt(0)) {
//            case '+':
//                result = a + b;
//                break;
//           case '-':
//                result= a - b;
//                break;
//           case '*':
//                result= a * b;
//                break;
//           case '/':
//                result= a / b;
//                break;
//           }
//        tl = "Ket qua la: " + result;
        if(this.us(a, b) == 1) tl = "Hai so nguyen to cung nhau";
        else 
            tl = "Hai so khong nguyen to cung nhau";
        
        //b4
        this.sendData = new byte[256];
        this.sendData = tl.getBytes();
        this.sendPacket = new DatagramPacket(this.sendData, this.sendData.length, this.receivePacket.getAddress(), this.receivePacket.getPort());
        this.socket.send(this.sendPacket);
    }
    
    
    
}
