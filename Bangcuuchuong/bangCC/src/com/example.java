package com;

import java.util.Scanner;

public class example {
    public static void main(String[] args) {
        System.out.println("Bang cuu chuong.");
        Scanner ob = new Scanner(System.in);
        for (int i = 1; i <=9; i++) {
            System.out.println("----------------");
            for (int j = 1; j <=10 ; j++) {
                System.out.printf("%d x %d = %d", i, j, i*j);
                System.out.println("");
            }
        }
    }
}
