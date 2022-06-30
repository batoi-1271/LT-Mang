package com.example.Ltmang.SoNguyenCg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class cgServer {
    int port;
    Socket s = null;
    ServerSocket ss = null;

    public cgServer(int port) {
        this.port = port;
    }

    public void create_Socket() throws IOException {
        ss = new ServerSocket(port);
        s = ss.accept();
        System.out.println("Client da ket noi den Server.");

    }

    public String GetInput() throws IOException {
        DataInputStream in = new DataInputStream(s.getInputStream());
        String dl = in.readLine();
        return dl;
    }

    public void getOutput(String dl) throws IOException {
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes(dl + '\n');
        s.close();
        ss.close();
    }
    public boolean NTCNDQ(int a,int b)
    {
        if(b == 0)
            return (a == 1);
        return NTCNDQ(b,a%b);
    }
//    public boolean KTNT(int n) {
//        boolean kt = true;
//        for (int i = 2; i <= n / 2; i++)
//            if (n % i == 0) {
//                kt = false;
//                break;
//            }
//        return kt;
//    }
}
