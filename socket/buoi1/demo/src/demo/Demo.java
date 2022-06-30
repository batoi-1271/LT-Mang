/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Scanner;

/**
 *
 * @author truon
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Nhap vao n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Client client = new Client(n);
        client.send();
    }
    
}
