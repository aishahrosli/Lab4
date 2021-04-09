package exercise4;

import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = null;
		
		try {
			
			int portNo = 4228;
			ss = new ServerSocket(portNo);
			
			String text1 = "Good afternoon";
			System.out.println("Waiting for request!");
			
			while(true) {
				
				Socket cs = ss.accept();
				
				DataOutputStream outputStream = new DataOutputStream(cs.getOutputStream());
				
				outputStream.writeUTF(text1);
				
				cs.close();
				
			}
			
		}catch(IOException ioe) {
			
			if(ss != null) {
				ss.close();
				
				ioe.printStackTrace();
			}
		}
	}
}
