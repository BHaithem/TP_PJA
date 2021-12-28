package tppja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SERVER {
        public static void main(String[] args)
        {
            String clientInput="";

            try {
            	 

            	  ServerSocket serverSocket = new ServerSocket(1010);
                System.out.println("waiting for clients...");
                
                     Socket socket = serverSocket.accept();
                     
                     System.out.println("server listing on port"+ socket.getLocalPort());
                    File fl  = new File("E:\\new folder");
                    File[] liste = fl.listFiles();
                    
                    
                       BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                      clientInput = input.readLine();
                      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                      if(clientInput.equals("QUIT")){
                         
                          System.out.println("fin de session");

                      }
                      if(clientInput.equals("get text")){
                          try
                             {
                             
                                      File fl1  = new File("E:\\\new folder\\pja.txt");

                               FileInputStream file = new FileInputStream(fl1);  
                               Scanner sc = new Scanner(file);  
                               
                             
                               while(sc.hasNextLine())
                               {
                                 System.out.println(sc.nextLine());
                                 String txt = sc.nextLine();
                                 out.println(new String(txt));
                               }
                               sc.close();    
                             }
                             catch(IOException e)
                             {
                               e.printStackTrace();
                             }
                          }

                      
                            
                          if(clientInput.equals("list")){
                        	  try {
								if(!fl.exists()) {
									System.out.println("error file dosen't exist");
								}else {

									for(File fe : liste){
								        if(fe.isFile())
								        { 
								        	
								        	out.println(new String("Nom du fichier :    "+fe.getName()));
								        	
								        	   System.out.println("Nom du fichier  : "+ fe.getName()); 
								          
								        } 
								        else if(fe.isDirectory())
								        {
								        	out.println(new String("Nom du répertoire  :   "+fe.getName()));
								        	 System.out.println("Nom du répertoire  : "+ fe.getName()); 
								        }
								}
								}
							} catch (Exception e) {
								
								e.printStackTrace();
							}  
                            	input.close();
                                out.close();
                                socket.close();
                          }
                            	
                           

                   
            } catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
}
