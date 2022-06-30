import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    public Server(int port) {
        this.port = port;
    }
    public void createSocket() throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.socket = this.serverSocket.accept();
    }
    public String getInput() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
        String data = dataInputStream.readLine();
        return data;
    }
    public void getOutput(String data) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
        dataOutputStream.writeBytes(data+"\n");
        this.socket.close();
        this.serverSocket.close();
    }
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
        return ucln==1 ? true : false;
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
        String posts = post.toString().length() > 0 ? post.toString() : "-1";
        List<String> list = new ArrayList();
        list.add("File Name: "+fileName);
        list.add("Host Name: "+hostName);
        list.add("Post: " + posts);
        list.add("Protocol: "+protocol);
        return list;
    }
}
