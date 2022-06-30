package com.example.helloworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLSV {
    private String firstName, lastName;
    Scanner sv = new Scanner(System.in);
    public void Nhap() {
        System.out.println("Nhap ho sinh vien: ");
        firstName = sv.nextLine();
        System.out.println("Nhap ten Sinh vien: ");
        lastName = sv.nextLine();
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void Xuat() {
        System.out.println("Ho ten Sv: " +firstName+" "+lastName);
    }
    public void MENU() {
        int n = 0;
        ArrayList<QLSV> arrSV = new ArrayList<>();
        QLSV hssv;
        do {
            System.out.println("===================MENU==================");
            System.out.println("1. Nhap ho ten sinh vien.");
            System.out.println("2. Danh sach sinh vien.");
            System.out.println("3. Danh sach sinh vien ngau nhien");
            System.out.println("4. DS SV giam dan va xuat DS.");
            System.out.println("5. Tim va xoa ho ten.");
            System.out.println("6. Thoat !!!");
            System.out.println("Nhap lua chon cua ban -> ");
            int choice = sv.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Nhap so luong sinh vien: ");
                        n = sv.nextInt();
                    } catch (Exception e) {
                        System.out.println("Vui long nhap so nguyen!!!");
                    }
                    for (int i=0; i<n; i++ ) {
                        System.out.println("SV thu: "+(i+1));
                        hssv = new QLSV();
                        hssv.Nhap();
                        arrSV.add(hssv);
                    }
                    break;
                case 2:
                    System.out.println("DANH SACH SINH VIEN.");
                    for (int i = 0; i < arrSV.size(); i++) {
                        System.out.println("Thong tin sinh vien thu: "+(i+1));
                        arrSV.get(i).Xuat();
                    }
                    break;
                case 3:
                    System.out.println("Danh sach sinh vien ngau nhien.");
                    for (int i = 0; i < n; i++) {
                        Collections.shuffle(arrSV);
                        arrSV.get(i).Xuat();
                    }
                    break;
                case 4:
                    System.out.println("Danh sach sinh vien theo chu cai.");
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui long chon tu 1->6.");
            }
        }
        while (true);
    }
}
