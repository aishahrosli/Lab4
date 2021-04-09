import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server generates current date.
 * Each connected client will received current date from the server.
 * 
 * @author emalianakasmuri
 *
 */
 
public class Server {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Generate current date
//			String currentDate = dateGenerator.getCurrentDate();
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			
			String text = "I love Distributed Application Development";
			
			// Send current date back to the client
			outputStream.writeBytes(text);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + text);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}

}
