package exercise4;

import java.io.*;
import java.net.*;

public class client {

	
	public static void main(String[] args) throws IOException{
		
		try {
			
			Socket s = new Socket(InetAddress.getLocalHost(), 4228);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			String text = br.readLine();
			System.out.println(text);
			br.close();
			s.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
}
