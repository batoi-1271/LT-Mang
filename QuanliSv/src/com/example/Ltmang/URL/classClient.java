package com.example.Ltmang.URL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class classClient {
    int port;
    Socket s = null;

    public classClient (int port) {
        this.port = port;
    }

    public void createSocket() throws IOException {
        s = new Socket("Localhost", port);
    }

    public String getInput() throws IOException {
        DataInputStream in = new DataInputStream(s.getInputStream());
        String dl = in.readLine();
        return dl;
    }

    public void getOutput (String dl) throws IOException {
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes(dl + "\n");
    }
}
