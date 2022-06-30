/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phantan.bai2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author truon
 */
public class main {
    public static void main(String[] args) {
         try {
            FileInputStream filein = new FileInputStream("D:/Sanphan.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(filein));
                
            String strLine;
            while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  System.out.println (strLine);
}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrienKhai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
