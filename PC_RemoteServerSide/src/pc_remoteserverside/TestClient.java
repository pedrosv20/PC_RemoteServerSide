/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_remoteserverside;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Pedro Vargas
 */
public class TestClient {
    
    /**
     * @param args
     */
    
    
    public static void main(String[] args) throws InterruptedException  {
        // TODO Auto-generated method stub
        // abre conexÃ£o com o servido

       
        try {
            
           Socket s = new Socket("192.168.0.14", 2000);
           DataOutputStream output = new DataOutputStream(s.getOutputStream());
           output.write("monitor off".getBytes());
           
          /*
            DataInputStream ois = new DataInputStream(s.getInputStream());
            ArrayList<String> users = new ArrayList();
            String a =  "";
            Thread.currentThread().sleep(1000); 
            
            while (ois.available() != 0) {
               a = ois.readUTF();
               users.add(a);
            }

            System.out.println(users);
            
            System.out.println("Qual seu nome");
            Scanner meu = new Scanner(System.in);
            String user = meu.nextLine();
            Semaphore mutexEnviar = new Semaphore(1);
            Semaphore mutexReceber = new Semaphore(0);
            ThreadEnviar envia = new ThreadEnviar(user, s, users, mutexEnviar, mutexReceber);

            ThreadReceber recebe = new ThreadReceber(user, s, mutexEnviar, mutexReceber);
            envia.start();
            recebe.start();
          */

            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
