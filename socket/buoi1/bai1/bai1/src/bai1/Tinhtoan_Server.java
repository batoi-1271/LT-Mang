/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truon
 */
public class Tinhtoan_Server {
    int port;
    Socket s = null;
    ServerSocket ss = null;
    public Tinhtoan_Server(int port){
      
        this.port = port;
    }
    public void Tao_Socket() throws IOException{
          //buoc 1
        this.ss = new ServerSocket(port);
          //buoc 2
        this.s = this.ss.accept();
    }
    // buoc 3
    public String getInput() throws IOException{
        DataInputStream in = new DataInputStream(this.s.getInputStream());
        String dl = in.readLine();
        return dl;
    }
    public void getOutput(String dl) throws IOException{
        //b5
        DataOutputStream out = new DataOutputStream(this.s.getOutputStream());
        out.writeBytes(dl+"\n");
        //b6
        this.s.close();
        this.ss.close();
    }
    // buoc 4
    public boolean checkSNT(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public boolean checkNTCN(int a,int b){
        int min = a < b ? a : b;
        int ucln=0;
        for(int i=min;i>=1;i--){
            if(a%i==0&&b%i==0){
                ucln = i;
                break;
            }
        }
        if(ucln==1) return true;
        return false;
    }
    public List<String> infoURL(String url){
        // http://dantri.com:8080
        StringBuilder protocol = new StringBuilder();
        StringBuilder hostName = new StringBuilder();
        StringBuilder post = new StringBuilder();
        StringBuilder fileName = new StringBuilder();
        for(int i = 0; i< url.length();i++){
            if(url.charAt(i) != ':') protocol.append(url.charAt(i));
            else{
                for(int j = i+3; j<url.length();j++){
                    if(url.charAt(j)!=':' && url.charAt(j)!='/') hostName.append(url.charAt(j));
                    else{
                        if(url.charAt(j)==':'){
                            int k;
                            for(k = j+1; k<url.length();k++){
                                if(url.charAt(k)== '/'){
                                    j=k;
                                    break;
                                }
                                post.append(url.charAt(k));
                            }
                        }
                        if(url.charAt(j)=='/'){
                            for(int k = j; k<url.length();k++){
                                fileName.append(url.charAt(k));
                            }
                        }
                        break;
                    }
                }
                break;
            }  
        }
        String pos = post.toString().length() != 0 ? post.toString() : "-1";
        List<String> list = new ArrayList();
        list.add("Host Name: "+hostName.toString()+"   -------   ");
        list.add("Post: " + pos+"   -------   ");
        list.add("Protocol: "+protocol.toString()+"   -------   ");
        list.add("File Name: "+fileName.toString());
        return list;
    }
    
}
