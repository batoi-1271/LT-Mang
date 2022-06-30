package com.example.Ltmang.SoNguyenCg;

import java.io.IOException;
import java.util.Scanner;

public class myClient {
    public static void main(String[] args) throws IOException {
        mainClient ob = new mainClient(3000);
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen a: ");
        String a= in.nextLine();
        System.out.println("Nhap vao so nguyen b: ");
        String b = in.nextLine();
        ob.Create_Socket();
        ob.GetOutput(a);
        ob.GetOutput(b);
        String tl = ob.GetInput();
        System.out.println("Ket qua: Cap so " +a+ "-" +b+ " "+ tl);
    }
}
