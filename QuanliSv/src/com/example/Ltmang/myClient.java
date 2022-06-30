package com.example.Ltmang;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class myClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("Localhost", 7826);
            System.out.println("Client da duoc tao.");

            Scanner inFromServer = new Scanner(client.getInputStream());
            PrintStream outToServer = new PrintStream(client.getOutputStream());

            System.out.println("Server: " + inFromServer.nextLine());

            Scanner ob = new Scanner(System.in);
            String url = ob.nextLine();

            outToServer.println(url);

            URL u = new URL(url);
            //Sau đó in các thông tin của tài nguyên như
            System.out.println("Name of the file is:");
            System.out.println("Host Name is: "+u.getHost());
            System.out.println("Port number is: "+u.getPort());
            System.out.println("Protocol type is: "+u.getProtocol());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
