package com.example.Ltmang.URL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class classServer {
    int port;
//    Socket s = null;
    java.net.Socket s = null;
    ServerSocket ss = null;

    public classServer(int port) {
        this.port = port;
    }

    public void create_Socket() throws IOException {
        ss = new ServerSocket(port);
        s = ss.accept();
        System.out.println("Client da ket noi den Server.");
    }
    public String getInput() throws IOException {
        DataInputStream in = new DataInputStream(s.getInputStream());
        String dl = in.readLine();
        return dl;
    }

    public void getOutput (String dl) throws IOException {
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes(dl+"\n");
        s.close();
        ss.close();
    }
}
