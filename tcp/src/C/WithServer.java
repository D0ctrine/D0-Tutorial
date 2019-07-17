package C;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WithServer {
	String id = null;

	InputStream reMsg = null;
	OutputStream sendMsg = null;

	Socket myClient = null;

	Scanner in = new Scanner(System.in);

	public WithServer(Socket s) {
		this.myClient = s;
		streamSet();
		sendData();
		receiveData();
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

	private void sendData() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						String re = in.nextLine();
					//	sendMsg = myClient.getOutputStream();
						sendMsg.write(re.getBytes());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();

	}

	private void streamSet() {
		try {
			System.out.println("ID를 입력하세요 >");
			id = in.nextLine();
			sendMsg = myClient.getOutputStream();
			sendMsg.write(id.getBytes());

			reMsg = myClient.getInputStream();

			byte[] reBuf = new byte[100];
			reMsg.read(reBuf);
			String msg = new String(reBuf);
			msg = msg.trim();
			System.out.println(msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
