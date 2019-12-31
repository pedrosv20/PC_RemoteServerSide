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
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



//TODO, criar uma thread para cada cliente e matar ela depois de tantos segundos sem resposta.
// procurar alternativas para controlar volume no 
public class PC_RemoteServerSide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               //vai ficar recebendo mensagens do telefone e dependendo da mensagem faz oq eu quiser
               //deve ficar dentro de um while para manter a conexao com somente um device
               // rodar quando pc ligar
               System.out.println(System.getProperty("os.name"));
               
               
		try {
                    ServerSocket serverSocket = new ServerSocket(2000);
                    
                    Socket socket = serverSocket.accept();
                    System.out.println("aceitou cliente");
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
                        if (message.equals("aumentar volume")) {
                            if (System.getProperty("os.name").equals("Mac OS X")) { 
                                System.out.println("entrou teste");
                               /* testeVolume(); mac os things*/ }
                            else {upSystemVolume();}
                            
                        }
                        else if (message.equals("diminuir volume")) {
                            if (System.getProperty("os.name").equals("Mac OS X")) { /*mac os things*/ }
                            else {downSystemVolume();}
                            
                        }
                        else if (message.equals("desligar monitor")) {
                            if (System.getProperty("os.name").equals("Mac OS X")) { /*mac os things*/ }
                            else {turnOffMonitor();}
                            
                        }
                        else if (message.equals("desligar computador")) {
                            if (System.getProperty("os.name").equals("Mac OS X")) { /*mac os things*/ }
                            else {shutDown();}
                            
                        }
                    }   
                    
                } 
                catch (Exception e) {
                    e.printStackTrace();
                } 
               
		

	}
        
        public static void testeVolume() throws InterruptedException {
        //Runtime.getRuntime().exec("/usr/bin/osascript -e 'set volume 15'");
                Runtime rt = Runtime.getRuntime();
                Process pr;
                try 
                {   
//                    System.out.println("osascript -e \"set Volume 1\"");
//                    System.out.println("entrou teste");
//                    ProcessBuilder pb = new ProcessBuilder("osascript -e \"set Volume 1\"");
//                    pb.directory(new File("usr"));
//                    Process p = pb.start();
                    String [] cmd = {"/usr/bin", "sudo osascript -e", "\"set Volume 1\""};
                    pr = rt.exec(cmd);
                    

                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
        }
        public static void shutDown()
        {
                Runtime rt = Runtime.getRuntime();
                Process pr;
                try 
                {   
                    pr = rt.exec("D:\\Program Files (x86)\\nircmd.exe" + " exitwin poweroff ");

                } 
                catch (IOException e) 
                {
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
                    pr = rt.exec("nircmd.exe" + " changesysvolume " + endVolume);
                    pr = rt.exec("nircmd.exe" + " mutesysvolume 0");

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
