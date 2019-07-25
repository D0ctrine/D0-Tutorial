package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CStart {
	Socket client=null;
	CStart(){
connectServer(); 		
	}
	
	private void connectServer() {
		
		try {
			client = new Socket("127.0.0.1",8888);
			new WithServer(client);
				
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
