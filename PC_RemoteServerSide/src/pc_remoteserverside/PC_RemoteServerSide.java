/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_remoteserverside;

/**
 *
 * @author Pedro Vargas
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//TODO desligar pc, mutar pc, desligar monitores, colocar isso no git
public class PC_RemoteServerSide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               //vai ficar recebendo mensagens do telefone e dependendo da mensagem faz oq eu quiser
               //deve ficar dentro de um while para manter a conexao com somente um device
               // rodar quando pc ligar
		try {
                    ServerSocket serverSocket = new ServerSocket(2000);
                    
                    Socket socket = serverSocket.accept();
                    DataInputStream input = new DataInputStream(socket.getInputStream());

                    while (true){
                        while (input.available() == 0) {

                        }
                        String message = "";
                        int cont = input.available();
                        while (cont > 0) {
                            byte a = input.readByte();
                            message += (char) a; 
                            cont = cont - 1;
                        }

                        System.out.println(message);
                        if (message.equals("aumenta volume")) {
                            upSystemVolume();
                        }
                        else if (message.equals("diminui volume")) {
                            downSystemVolume();
                        }
                        else if (message.equals("monitor off")) {
                            turnOffMonitor();
                        }
                    }
                    
                   
                    
                  
                    
                    
                } 
                catch (Exception e) {
                    e.printStackTrace();
                } 
		

	}
        public static void turnOffMonitor() 
        {
                Runtime rt = Runtime.getRuntime();
                Process pr;
                try 
                {   
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " monitor off ");

                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
        }
        public static void upSystemVolume()
        {

            
                double endVolume = 655.35 * 10;

                Runtime rt = Runtime.getRuntime();
                Process pr;
                try 
                {   
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " changesysvolume " + endVolume);
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " mutesysvolume 0");

                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            
                
        }
        
        public static void downSystemVolume()
        {

            
                double endVolume = 655.35 * -10;

                Runtime rt = Runtime.getRuntime();
                Process pr;
                try 
                {   
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " changesysvolume " + endVolume);
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " mutesysvolume 0");

                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            
                
        }
        

}
