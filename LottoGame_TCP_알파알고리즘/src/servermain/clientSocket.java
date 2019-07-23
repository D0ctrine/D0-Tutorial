package servermain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import DAO.DAO;

public class clientSocket extends Thread {
	Socket myclient = null;
	Scanner in = new Scanner(System.in);
	InputStream reMsg = null;
	OutputStream sendMsg = null;
	String id = "";
	String send = "";
	lotto Lotto = new lotto();
	DAO dao = DAO.getInstance();
	byte[] rebuf = new byte[100];
	
	clientSocket(Socket server) {
		this.myclient = server;
	}

	@Override
	public void run() {
		streamset();
		sendDate();
		receiveDate();
	}

	private void receiveDate() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {

						reMsg.read(rebuf);
						String msg = new String(rebuf).trim();
						if (msg.indexOf("help") != -1) {
							sendDate(
									"This is Lotto game. \r\n Ex(?? ?? ?? ?? ?? ?? +??) \r\n Please separate with space with each number.");
						} else if (msg.indexOf("play") != -1) {
							play();
						} else if (msg.indexOf("exit") != -1) {
							sendDate("Turn off yourself ^^ ");
						} else {
							sendDate("Functions Exception");
							System.out.println(id + " / " + msg);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void play() {
		ArrayList<String> Lotto_official = Lotto.lottoNum(); //�젙�떟 踰덊샇 �깮�꽦�빐以�
		int count=0;
		for(int h=0;h<3;h++) {  //3踰덈쭔 �떎�뻾
			
		String[] prefer = dao.getList(id);
		String prefer_send="사용자 1등 빈도 수";
		int max=1;
		for(int i=1;i<prefer.length;i++) {
			if(prefer[i]!=null) {
					
				if(prefer[max].substring(4).length()<prefer[i].substring(4).length()) {
					max = i;
			}
		}
		}
				
					prefer_send+="  ["+max+"] : "+prefer[max].substring(4).length();
					
		if(prefer_send!="사용자 1등 빈도 수") {
			sendDate(prefer_send);
		}
		
		sendDate("\n"+(h+1)+"/3 번째"+"Lotto Game Start!!\r\n Fill number \r\n [??] [??] [??] [??] [??] [??] +[??]");
		sendDate("( '!': 초과  / '?': 중복  / '^': 초과 and 중복 )");
		try {
			byte[] rebuf1 = new byte[100];
			reMsg.read(rebuf1);
			String msg = " " + new String(rebuf1).trim() + " ";
			StringTokenizer a = new StringTokenizer(msg);
			ArrayList<String> client = new ArrayList<>();
			String[] client_imsi = new String[7];
			int check_num[] = new int[7]; 
				for (int i = 0; i<7; i++) {
					String m = a.nextToken();
					int num = Integer.parseInt(m);
					client.add(m);
					if(num<=45) {	//num�씠 45蹂대떎 �옉�쓣 寃쎌슦留� 鍮꾧탳�빐�씪
						m = " " + m + " ";
						if (msg.substring(msg.indexOf(m) + 3).indexOf(m) != -1) {
							check_num[i] = 1;
						}
					}else {
						//45 珥덇낵 �븷寃쎌슦
						m = " " + m + " ";
						if (msg.substring(msg.indexOf(m) + 3).indexOf(m) != -1) {
							check_num[i] = 1;
						}
						check_num[i] += 2;
					}
				}
				dao.insert(id, client);
				client_imsi = Lotto.lottocheck(client,Lotto_official); //留욎븯�떎 ���졇�떎.
				for(int i=0;i<client.size();i++) {
					if(check_num[i]==3) {//以묐났+珥덇낵
						client.set(i,client.get(i)+ "^");
						count=count+2;
					}else if(check_num[i]==1) { //以묐났
						client.set(i, client.get(i)+ "?");
						count=count+2;
					}
					else if(check_num[i]==2) { //珥덇낵
						client.set(i,client.get(i)+ "!");
						count++;
					}else {
						client.set(i,client.get(i));
					}
				}
			
				
				//client.removeAll(client);
				for(int i=0;i<client.size();i++) {
					  client.set(i, client.get(i)+client_imsi[i]);
				}
				
				//異쒕젰遺�
				String show="MY Lotto Number ";
				for(int i=0;i<client.size();i++) {
					  show += "[ "+client.get(i)+" ]  ";
				}
				sendDate(show);
				
				//�젙�떟
				client.removeAll(client);
				
		}catch(NumberFormatException g) {
			sendDate("숫자 말고 다른값을 입력하셨습니다.");
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		}//for臾�
		String show="";
		show="Official Lotto Number ";
		for(int i=0;i<Lotto_official.size();i++) {
			  show += "[ "+Lotto_official.get(i)+" ]  ";
			  System.out.print(Lotto_official.get(i)+"/");
		}
		sendDate(show+"\r\n");
	}

	private void sendDate() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						send = in.nextLine();
						sendMsg.write(send.getBytes());

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}

	private void sendDate(String msg) {
		try {
			sendMsg.write(msg.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void streamset() {
		try {
			sendMsg = myclient.getOutputStream();
			sendMsg.write("[ Please create your ID ]".getBytes());
			reMsg = myclient.getInputStream();
			byte[] buf = new byte[100];
			reMsg.read(buf); // �겢�씪�씠�뼵�듃濡� 遺��꽣 硫붿떆吏�瑜� �삤湲곕�� ��湲�
			id = new String(buf);
			id = id.trim();
			System.out.println("id :" + id);
			String re = "[" + id
					+ "] Login Success~! \r\n [Welcome LottoWorld] \r\n [Function] 1.'/help' 2.'/play' 3.'/exit'";
			sendMsg.write(re.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
