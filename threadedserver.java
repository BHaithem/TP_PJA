package tppja;

import java.io.IOException;
import java.net.ServerSocket;

public class threadedserver {

	
		
		public static void main(String[] args){
			try {
				ServerSocket serversocket = new ServerSocket(1010);
				while(true) {
				 serversocket.accept();
					Thread th = new Thread();
					th.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		

		}
}