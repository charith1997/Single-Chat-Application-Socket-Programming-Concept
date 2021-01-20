package SingleChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		
		String clientMessage;
		
		System.out.println("Waiting for client's request...");  // Server start
		
		@SuppressWarnings("resource")
		ServerSocket serversocket = new ServerSocket(9806);  // Set client port address 
		
		while(true) {
			
			Socket socket = serversocket.accept();  // Server wait for client request 
		
			System.out.println("Connection is completed");  // Connection complete with client
		
			//read the client message
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		
			clientMessage = fromClient.readLine() + '\n';
		
			toClient.writeBytes(clientMessage);
		
		}
	}

}
