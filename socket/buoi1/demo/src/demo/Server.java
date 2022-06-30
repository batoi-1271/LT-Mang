/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author truon
 */
public class Server {
    private int data;

    public Server() {
      
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public boolean check(Client client){
        int n = client.getN();
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public void receive(Client client){
       if(check(client)) {
           setData(client.getN());
           System.out.println("nhan thanh cong "+getData());
       }
       else System.out.println("khong thanh cong");
    }
}
