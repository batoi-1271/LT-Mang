package com.example.QLSV;

import java.util.ArrayList;
import java.util.Scanner;

public class QLSVUKB {
        private String id;
        private String name;
        private float DTB;
        Scanner sv = new Scanner(System.in);
        public QLSVUKB() {
            id=name="";
            DTB=0;
        }

        public void Nhap() {
            System.out.println("NHAP THONG TIN SV.");
            System.out.println("Nhap ma Sv: "); id = sv.nextLine();
            System.out.println("Nhap ho ten Sv: "); name = sv.nextLine();
            System.out.println("Nhap diem TB: "); DTB = sv.nextFloat();
        }
        public void setDTB(float DTB) {
            this.DTB= DTB;
        }
        public float getDTB() {
            return this.DTB;
        }
        public void Xuat() {
            System.out.printf("%s\t\t%s\t%3f\n", id, name, DTB);
        }
        void MENU() {
            int n=0;
            ArrayList<QLSVUKB> arrHoSo = new ArrayList<>();
            QLSVUKB hosoSV;
            do {
                System.out.println("==============NENU===========");
                System.out.println("1. Nhap danh sach Sinh vien.");
                System.out.println("2. Danh sach Sinh vien.");
                System.out.println("3. Them Sinh vien.");
                System.out.println("4. Xoa sinh vien.");
                System.out.println("5. Sap xep sinh vien theo DTB.");
                System.out.println("6. Thoat!!!.");
                System.out.println("Moi ban lua chon.-> ");
                int choice = sv.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("1. NHAP DANH SACH SINH VIEN.");
                        try {
                            System.out.println("Nhap so luong Sinh vien: ");
                            n= sv.nextInt();
                        }
                        catch (Exception e) {
                            System.out.println("vui long nhap so!.");
                        }
                        for (int i=0; i<n; i++) {
                            System.out.println("Sinh vien thu: "+(i+1));
                            hosoSV = new QLSVUKB();
                            hosoSV.Nhap();
                            arrHoSo.add(hosoSV);
                        }
                        break;
                    case 2:
                        System.out.println("2. DANH SACH SINH VIEN.");
                        System.out.print("STT\t");
                        System.out.print("Ma SV\t");
                        System.out.print("Ho ten\t\t\t");
                        System.out.print("DTB\n");
                        for (int i=0; i<arrHoSo.size(); i++) {
                            System.out.print(""+(i+1)+"\t");
                            arrHoSo.get(i).Xuat();
                        }
                        break;
                    case 3:
                        System.out.println("3. THEM SINH VIEN.");
                        try {
                            System.out.println("Nhap Sl sinh vien muon them: ");
                            n= sv.nextInt();
                        }
                        catch (Exception e) {
                            System.out.println("vui long nhap so!.");
                        }
                        for (int i=0; i<n; i++) {
                            System.out.println("Sinh vien thu: "+(i+1));
                            hosoSV = new QLSVUKB();
                            hosoSV.Nhap();
                            arrHoSo.add(hosoSV);
                        }
                        break;
                    case 4:
                        System.out.println("4. XOA SINH VIEN.");
                        int index;
                        System.out.println("Nhap vi tri can xoa: ");
                        index= sv.nextInt();
                        arrHoSo.remove(index);
                        System.out.printf("Da xoa sinh vien vi tri thu %d !.", index);
                        break;
                    case 5:
                        System.out.println("5. SAP XEP SV THEO DTB.");
                        QLSVUKB[] list = new QLSVUKB[arrHoSo.size()];
                        list = arrHoSo.toArray(list);

                        for(int i=0; i<n-1; i++) {
                            for(int j=i+1; j<n; j++) {
                                if(list[i].getDTB() > list[j].getDTB()) {
                                    QLSVUKB temp = new QLSVUKB();
                                    temp = list[i];
                                    list[i] = list[j];
                                    list[j] = temp;
                                }
                            }
                        }

                        for(int i=0; i<n; i++) {
                            list[i].Xuat();
                        }

                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Vui long chon tu 1-6.");
                }
            } while (true);
        }
}
