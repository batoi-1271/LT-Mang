/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Scanner;

/**
 *
 * @author truon
 */
public class Client {
    private int n;

    public Client(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void send(){  
        Client client = new Client(this.n);
        Server server = new Server();
        server.receive(client);
    }
}
