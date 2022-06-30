
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author truon
 */
public class Client {
     private int port;
    private Socket socket;
    public Client(int port) {
        this.port = port;
    }
    public void createSocket(){
         try {
             this.socket = new Socket("Localhost",this.port);
         } catch (IOException ex) {
             System.out.println("loi khi khoi tao socket");
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public String getInput(){
        DataInputStream dataInputStream =null;
        String data="";
         try {
             if(this.socket.getInputStream()!=null){
                dataInputStream = new DataInputStream(this.socket.getInputStream());
                data= dataInputStream.readLine();
             }
         } catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }    
        return data;
    }
    public void getOutput(String data){
        DataOutputStream dataOutputStream;
         try {
             dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
             dataOutputStream.writeBytes(data+"\n");
         } catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void close(){
         try {
             this.socket.close();
         } catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
