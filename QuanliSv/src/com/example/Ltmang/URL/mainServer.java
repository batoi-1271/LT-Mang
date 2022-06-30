package com.example.Ltmang.URL;

import java.io.IOException;
import java.net.URL;

public class mainServer {
    public static void main(String[] args) throws IOException {
        classServer ob = new classServer(7826);
        System.out.println("Server da duoc tao.");
        ob.create_Socket();

        String a = ob.getInput();
        String tl = "";
        URL url = new URL(a);
        tl += url.toString() + ","+ url.getHost() + ","+url.getPort() + ", "+url.getProtocol();
        ob.getOutput(tl);
    }
}
