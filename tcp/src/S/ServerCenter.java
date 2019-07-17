package S;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerCenter implements Runnable{

	ServerSocket serverS = null; // 서버를 구동하기 위한 소켓
	Socket serverClient = null; // 클라이언트와 통신을 하기 위한 소켓
	Scanner in = new Scanner(System.in);
	ArrayList<WithClient> clientSocket = new ArrayList<>();
	ArrayList<Socket> Socketbox = new ArrayList<>();
	
	ServerCenter() {
	
		try {
			int num=1;
			serverS = new ServerSocket();
			serverS.bind(new InetSocketAddress("127.0.0.1", 8888));
			WithClient w =null;
			while(true) {
				System.out.println("서버 대기 중 ~~~");
				serverClient = serverS.accept();
				Socketbox.add(serverClient);
				System.out.println("클라이 언트가 입장 하였습니다.");
				w = new WithClient(serverClient);
				w.setName("client"+num);
				num++;
				w.start();
				clientSocket.add(w);
			
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		try {
			while(true) {
				String msg = in.nextLine();
				for(int i=0;i<Socketbox.size();i++) {
					Socketbox.get(i).getOutputStream().write(msg.getBytes());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
