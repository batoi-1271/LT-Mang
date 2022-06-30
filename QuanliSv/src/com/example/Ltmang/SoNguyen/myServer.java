package com.example.Ltmang.SoNguyen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class myServer {
    public static void main(String[] args) {
        String n, kq;
        try {
            ServerSocket server = new ServerSocket(7826);
            System.out.println("Server da duoc tao.");

            Socket client = server.accept();
            System.out.println("Client da ket noi den Server.");
            DataInputStream inFromClient = new DataInputStream(client.getInputStream());

            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
            n = inFromClient.readLine();

            int a = Integer.parseInt(n);
            int dem = 0;
            for(int i=2;i<=a/2;i++)
                if(a%i==0) {
                    dem++;break;}
            if (dem==0)
                kq = "La so nguyen to!";
            else
                kq = "Khong la so nguyen to!";

            outToClient.writeBytes(kq +'\n');
            inFromClient.close();
            outToClient.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
