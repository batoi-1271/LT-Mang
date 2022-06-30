/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author truon
 */
public class Client {
    int port;
    Socket sclient = null;
    public Client(int port){
        this.port = port;
    }
    public void Tao_Socket() throws IOException{
        sclient = new Socket("Localhost",port);
    }
    // buoc 3
    public String getInput() throws IOException{
        DataInputStream in = new DataInputStream(this.sclient.getInputStream());
        String dl = in.readLine();
        return dl;
    }
    public void getOutput(String dl) throws IOException{
        //b5
        DataOutputStream out = new DataOutputStream(this.sclient.getOutputStream());
        out.writeBytes(dl+"\n");
    }

    /// bai2
    public void getOutput2(String x,String y) throws IOException{
        //b5
        DataOutputStream out = new DataOutputStream(this.sclient.getOutputStream());
        out.writeBytes(x+"\n");
        out.writeBytes(y+"\n");
    }
    
}
