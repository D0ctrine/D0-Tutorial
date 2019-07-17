package C;

import java.io.IOException;
import java.net.Socket;

public class CStart {

	Socket client = null;
	CStart(){
		try {
			client = new Socket("127.0.0.1",8888);
			new WithServer(client);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
