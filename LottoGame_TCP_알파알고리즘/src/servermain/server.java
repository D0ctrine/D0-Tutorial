package servermain;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class server {
	ArrayList<clientSocket> Socketbox = new ArrayList<clientSocket>();
	Socket serverclient = null;
	int num=1;
	server(){
	try {
		
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress("10.0.0.54",8888));
		while(true) {
			System.out.println("Server Waiting");
			serverclient = server.accept();
			InetAddress ip = serverclient.getInetAddress();
			System.out.println("클라이언트["+(new String(ip+"")).substring(1)+"] 입장 .");
			clientSocket w = new clientSocket(serverclient);
			Socketbox.add(w);
			w.setName("client"+num);
			num++;
			w.start();
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
	
}
