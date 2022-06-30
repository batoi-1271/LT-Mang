package com.example.Ltmang.URL;

import java.io.IOException;
import java.util.Scanner;

public class mainClient {
    public static void main(String[] args) throws IOException {
        classClient ob = new classClient(7826);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap duong dan cua ban: ");
        String link = sc.nextLine();

        ob.createSocket();
        ob.getOutput(link);
        String dl = ob.getInput();
        String []dt = dl.split(",");
        System.out.println("URL: "+dt[0]);
        System.out.println("Nam of the file is: ");
        System.out.println("Host name is: " +dt[1]);
        System.out.println("Port number is: " +dt[2]);
        System.out.println("Protocol type is: " +dt[3]);
    }

}
