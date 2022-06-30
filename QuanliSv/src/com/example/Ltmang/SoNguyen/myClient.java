package com.example.Ltmang.SoNguyen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class myClient {
    public static void main(String[] args) {
        String a, kq;
        try {
            Socket client = new Socket("Localhost", 7826);
            System.out.println("Client da duoc tao.");

            DataInputStream inFromUser = new DataInputStream(System.in);
            DataInputStream inFromServer = new DataInputStream(client.getInputStream());
            DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
            // nhap lieu tu ban phim
            System.out.println("nhap vao so a :");
            a=inFromUser.readLine();
            // gui len server
            outToServer.writeBytes(a+'\n');
            kq = inFromServer.readLine();
            System.out.println(kq);
            outToServer.close();
            inFromServer.close();
            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
