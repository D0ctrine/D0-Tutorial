package S;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Scanner;

public class WithClient extends Thread { // 접속 한 클라이언트랑 통신하기 위한 클래스
	String id = null;
	int i=0;
	InputStream reMsg = null;
	OutputStream sendMsg = null;
	Scanner in = new Scanner(System.in);
	Socket myClient = null;
 	@Override
	public void run() {
		streamSet();
		
		receiveData();
	}

	public WithClient(Socket s) {
		this.myClient = s;
	}

	private void receiveData() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
					//	reMsg = myClient.getInputStream();
						byte[] reBuf = new byte[100];
						reMsg.read(reBuf);
						String msg = new String(reBuf).trim();
						System.out.println(id + " / " + msg);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}



	private void streamSet() {
		try {
			// 클라이언트로 부터 메시지가 오기를 대기
			reMsg = myClient.getInputStream();
			byte[] reBuf = new byte[100];
			reMsg.read(reBuf);
			id = new String(reBuf);
			id = id.trim();

			System.out.println(id);

			String re = id + "!  welcome";
			sendMsg = myClient.getOutputStream();
			sendMsg.write(re.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
