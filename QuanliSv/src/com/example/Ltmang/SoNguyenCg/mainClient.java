package com.example.Ltmang.SoNguyenCg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class mainClient {
    int port;
    Socket s = null;

    public mainClient(int port) {
        this.port = port;
    }
    public void Create_Socket() throws IOException {
        s = new Socket("Localhost", port);

    }
    public String GetInput() throws IOException {
        DataInputStream in = new DataInputStream(s.getInputStream());
        String dl = in.readLine();
        return dl;
    }
    public void GetOutput (String dl) throws IOException{
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes(dl +'\n');
    }
}
