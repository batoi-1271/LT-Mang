package com;

import java.util.Scanner;

public class example1 {
    public static void main(String[] args) {
        int n =0;
        Scanner ob = new Scanner(System.in);
        try {
            System.out.println("So phan tu cua mang la: ");
            n = ob.nextInt();
        } catch (Exception e) {
            System.out.println("Sai so");
        }
        double []d = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phan tu thu: " +i);
            d[i] = ob.nextDouble();
        }
        System.out.println("Mang gom cac phan tu la: ");
        for (int i = 0; i < d.length; i++) {
            System.out.println("Phan tu thu " +i+ " la: " +d[i]);
        }
        int swap = 0;
        for (int j = 0; j < n-1; j++) {
            for (int i = j+1; i < n; i++) {
                if (d[j] > d[i]) {
                    swap = (int) d[j];
                    d[j] = d[i];
                    d[i] = swap;
                }
            }
        }
        System.out.println("---------------");
        System.out.println("Sap xep tang dan.");
        for (int i = 0; i < d.length; i++) {
            System.out.println("Phan tu thu: " +d[i]);

        }
    }
}
