package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com:8080/haha");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getFile());
            System.out.println(url.getPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
