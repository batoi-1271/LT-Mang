/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author truon
 */
public class CT_Chinh_Client {
    public static void main(String[] args) throws IOException {
        Client client = new Client(3000);
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Nhap vao so nguyen: ");
        String a = sc.nextLine();
        client.Tao_Socket();
        client.getOutput(a); // gui du lieu len socket
        // doi du lieu
        String tl = client.getInput();// doc du lieu ve
        System.out.println("ket qua "+tl);*/
        
        
        
        /// bai 2 check so nguyen to cung nhau
        /*System.out.println("Nhap vao so thu nhat: ");
        String x = sc.nextLine();
        System.out.println("Nhap vao so thu hai: ");
        String y = sc.nextLine();
        client.Tao_Socket();
        client.getOutput2(x,y); // gui du lieu len socket
        // doi du lieu
        String tl = client.getInput();// doc du lieu ve
        System.out.println("ket qua "+tl);*/
        
        /// bai 3 check domain
        System.out.println("nhap url: ");
        String url = sc.nextLine();
        client.Tao_Socket();
        client.getOutput(url);
        String tl = client.getInput();
        System.out.println("ket qua "+tl);
  }
}
