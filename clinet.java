package tppja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class clinet2 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String message = "";
        String serverInput="";
        try
        {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            System.out.println("server Ip address: " + serverAddress.getHostAddress());
          
            boolean stop = true;
            
            while (stop) {
            	 Socket socket = new Socket(serverAddress, 1010);
            	 message=sc.next();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                	
                     
                	
                input.close();
                out.close();
                socket.close();
            }
        }
        catch(UnknownHostException e1)
        {
            System.out.println("Unknown host exception " + e1.toString());
        }
        catch(IOException e2)
        {
            System.out.println("IOException " + e2.toString());
        }
        catch(IllegalArgumentException e3)
        {
            System.out.println("Illegal Argument Exception " + e3.toString());
        }
        catch(Exception e4)
        {
            System.out.println("Other exceptions " + e4.toString());
        }
    }
}

