package SingleChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws Exception{
		
		String message;
		String newMessage;
		
		BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost",9806);
		
		System.out.println("Enter message: ");
		
		DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		message = fromUser.readLine();
		
		toServer.writeBytes(message + '\n');
		
		newMessage = fromServer.readLine();
		
		System.out.println("Your message: " + newMessage);
		
		clientSocket.close();

	}

}
