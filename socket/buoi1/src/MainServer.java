import java.io.IOException;
import java.util.Arrays;

public class MainServer {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3000);
        server.createSocket();
        /*String a = server.getInput();
        String tl="";
        if(server.checkSNT(Integer.parseInt(a)))
            tl = "la so nguyen to";
        else tl = "khong la so nguyen to";*/

        // check nguyen to cung nhau
        /*String a = server.getInput();
        String b = server.getInput();
        String tl = "";
        if(server.checkNTCN(Integer.parseInt(a),Integer.parseInt(b)))
            tl = "nguyen to cung nhau";
        else
            tl = "khong nguyen to cung nhau";
        server.getOutput(tl);*/

        // show info url
        String url = server.getInput();
        StringBuilder tl = new StringBuilder();
        for(String x : server.infoURL(url)){
            tl.append(x).append("\t");
        }
        server.getOutput(tl.toString());
    }
}
