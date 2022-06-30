
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
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
public class Server {
    private int port;
    private Socket socket;
    private List<Socket> listSocket;

    public List<Socket> getListSocket() {
        return listSocket;
    }

    public void setListSocket(List<Socket> listSocket) {
        this.listSocket = listSocket;
    }
    private ServerSocket serverSocket;
    public Server(int port) {
        this.port = port;
    }
    public void createSocket(){
        try {
            this.listSocket = new LinkedList<Socket>();
            this.serverSocket = new ServerSocket(port);
            new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Socket socket = serverSocket.accept();
                        if(socket != null)
                            listSocket.add(socket);
                    }
                    catch(Exception e){
                        //
                    }
                }   
            }
        }).start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getInput(){
        DataInputStream dataInputStream =null;
        String data="";
         try {
             for(Socket socket : listSocket){
                dataInputStream = new DataInputStream(socket.getInputStream());
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
            for(Socket socket : listSocket){
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeBytes(data+"\n"); 
            } 
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void close(){
        try {
            for(Socket socket : listSocket){
                socket.close();
            }
            //this.socket.close();
            this.serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
