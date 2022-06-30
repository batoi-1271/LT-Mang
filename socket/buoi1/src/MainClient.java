import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client(3000);
        client.createSocket();
        Scanner scanner = new Scanner(System.in);

        // check so nguyen to
        /*String a = scanner.nextLine();
        client.getOutput(a);
        String tl = client.getInput();
        System.out.println(tl);*/

        // check nguyen to cung nhau
        /*System.out.println("nhap vao so a: ");
        String a = scanner.nextLine();
        System.out.println("nhap vao so b: ");
        String b = scanner.nextLine();
        client.getOutput(a);
        client.getOutput(b);
        String tl = client.getInput();
        System.out.println(tl);*/

        // show info url
        System.out.println("nhap vao url: ");
        String url = scanner.nextLine();
        client.getOutput(url);
        String tl = client.getInput();
        String[] tl2 = tl.split("\t");
        for(String x : tl2){
            System.out.println(x);
        }
    }
}
