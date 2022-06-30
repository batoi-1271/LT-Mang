/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.IOException;

/**
 *
 * @author truon
 */
public class CT_Chinh_Server {
    public static void main(String[] args) throws IOException {
        Tinhtoan_Server ob = new Tinhtoan_Server(3000);
        //tao socket
        ob.Tao_Socket();
        // doc du lieu cua client
        /*String a = ob.getInput();
        // xu ly du lieu
        String tl = "";
        if(ob.checkSNT(Integer.parseInt(a)))
            tl = "la so nguyen to";
        else
            tl = "khong la so nguyen to";
        // gui lai du lieu cho Client
        ob.getOutput(tl);
        */
        
        ///check so nguyen to cung nhau
        /*String x= ob.getInput();
        String y = ob.getInput();
        String tl = "";
        if(ob.checkNTCN(Integer.parseInt(x),Integer.parseInt(y)))
            tl = "nguyen to cung nhau";
        else
            tl = "khong nguyen to cung nhau";
        // gui lai du lieu cho Client
        ob.getOutput(tl);*/
        
        
        // check domain
        String url = ob.getInput();
        String tl = "";
        for(String x : ob.infoURL(url)){
            tl+=x;
        }
        ob.getOutput(tl);
       
    }
}
