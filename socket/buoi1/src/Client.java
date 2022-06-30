import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private int port;
    private Socket socket;
    public Client(int port) {
        this.port = port;
    }
    public void createSocket() throws IOException {
        this.socket = new Socket("Localhost",this.port);
    }
    public String getInput() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
        String data = dataInputStream.readLine();
        return data;
    }
    public void getOutput(String data) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
        dataOutputStream.writeBytes(data+"\n");
    }
}
