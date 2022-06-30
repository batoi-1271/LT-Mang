package com.example.Ltmang.SoNguyenCg;

import java.io.IOException;

public class mainServer {
    public static void main(String[] args) throws IOException {
        cgServer ob = new cgServer(3000);
        System.out.println("Server da duoc tao.");

        ob.create_Socket();
        String a = ob.GetInput();
        String b = ob.GetInput();
        String tl = "";
//        if (ob.KTNT(Integer.parseInt(a)))
//            tl = "La so nguyen to";
//        else
//            tl = "Khong phai la so nguyen to";

        if (ob.NTCNDQ(Integer.parseInt(a), Integer.parseInt((b))))
            tl = "La so nguyen to cung nhau";
        else
            tl = "Khong phai la so nguyen to cung nhau";
        ob.getOutput(tl);
    }
}
