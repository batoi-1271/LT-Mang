package com.example.Ltmang;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class myServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7826);
            System.out.println("Server da duoc tao.");

            Socket client = server.accept();
            System.out.println("Client da ket noi den Server.");

            Scanner inFromClient = new Scanner(client.getInputStream());
            PrintStream outToClient = new PrintStream(client.getOutputStream());

            outToClient.println("Xin chao, Nhap duong dan cua ban: ");

            String url = inFromClient.nextLine();
            System.out.println("Client: " + url);

            //Truy cập vào URL

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
