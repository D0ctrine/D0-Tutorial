package Server;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerCenter {

ServerSocket serverS = null;
Socket serverClient = null;
ServerSocket ClientMsg = null;

ArrayList<WithClient> clientSocket = new ArrayList<>();

ServerCenter(){
fromClient();
}

private void fromClient() {
	try {
		int num=1;
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("127.0.0.1", 8888));
		
		while(true) {
			System.out.println("���� �����");
			serverClient = serverS.accept();
			System.out.println("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�");
			
			WithClient w = new WithClient(serverClient);
			w.setName("client"+num);
			num++;
			w.start();
			clientSocket.add(w);
		}
	} catch (Exception e) {
e.printStackTrace();
	}
	
}

}
