package Quiz01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOut {
//입력하기 또는 생성
	FileInputStream fi = null; // Byte방식으로 jvm에서 외부로 input하는 객체변수
	FileOutputStream fo = null;
	int selnum;
	Scanner in = new Scanner(System.in);
	boolean flag = true;
	String targetFile = "test.txt";
	member memb = new member();
	ArrayList<String> idbox = new ArrayList<String>();
	public FileOut() {

		while (flag) {
			if(read(0)==null) {
				setF();
			}
			read(0);
			menu();

			selnum = in.nextInt();
			in.nextLine();

			switch (selnum) {
			case 1:
				insert();
				break;
			case 2:
				read(1);
				break;
			case 3:
				mod();
				break;
			case 4:
				del();
				break;
			default:
				flag = false;
			}
		}
	}

	void menu() {
		System.out.println("==================");
		System.out.println("회원관리프로그램");
		System.out.println("1.회원가입");
		System.out.println("2.회원보기");
		System.out.println("3.회원수정");
		System.out.println("4.회원삭제");
		System.out.println("5.EXIT");
		System.out.println("==================");
	}

	private void del() {
		// TODO Auto-generated method stub
		read();
		boolean flag=true;
		while(flag) {
			System.out.println("지우실 아이디를 입력해주세요.");
			System.out.println("(뒤로가기 : x)");
			String delId = in.nextLine();
			if(delId.equals("x") || delId.equals("X")) {
				
				break;
			}
			for(int i=0;i<idbox.size();i++) {
				if(delId.equals(idbox.get(i))) {
					idbox.remove(i);
					idbox.remove(i);
					flag=false;
					break;
					}
				i++;
				}
			}
			insert(idbox);
		}
		

	private void mod() {
		// TODO Auto-generated method stub
		read();
		int selnum;
		boolean flag=true;
		while(flag) {
			//read(2);
			System.out.println("고칠 아이디를 입력해주세요~");
			String fixId = in.nextLine();
			for(int i=0;i<idbox.size();i++) {
				if(fixId.equals(idbox.get(i))) {
					while(flag) {
					System.out.println("무엇을 고치시겠습니까?");
					System.out.println("1.ID");
					System.out.println("2.PW");
					System.out.println("3.종료");
					selnum = in.nextInt();
					in.nextLine();
					switch(selnum) {
					case 1:System.out.print("New ID :");idbox.set(i, in.nextLine());break;
					case 2:System.out.println("New PW :");idbox.set((i+1), in.nextLine());break;
					case 3:flag =false;break;
					}
					
				}
					insert(idbox);
					
			}
				i++;
			
		}
		}
		
	}

	String read(int i) {

		int k = 0;
		String imsi1 = "";
		byte[] readM = new byte[16];
		
		try {

			fi = new FileInputStream(targetFile);
			
			if (fi != null) {
				while ((k = fi.read(readM)) != -1) {
					imsi1 += new String(readM, 0, k);
				}
				if (i == 1) {
					System.out.println(imsi1);
				}
			} 

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return imsi1;
	}
	void read() {
		int k = 0;
		String imsi="";
		char a;
		
		try {

			fi = new FileInputStream(targetFile);
			idbox.removeAll(idbox);
			if (fi != null) {
				while((k = fi.read()) != -1) {

					a=(char) k;
					if(a==47) {
						idbox.add(imsi);
						imsi="";
					}else if(a==13){
						idbox.add(imsi);
						imsi="";
					}else if(a==10){
						imsi="";
					}else {
						imsi+=a;
					}
				}
					
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("====아이디 명단====");
			for(int j=0;j<idbox.size();j++) { //아이디만 출력 (짝수 : 아이디 / 홀수 : 비번)
				System.out.println("ID : "+idbox.get(j));
				j++;
			}
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	}
	
	public void setF() {
		if (fo == null) {

			// 파일 저장
			try {
				fo = new FileOutputStream(targetFile);

			} catch (Exception e) {

			} finally {
				try {
					if (fo != null)
						fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void insert() {

		try {
			String imsi = read(0);
			fo = new FileOutputStream(targetFile);

			System.out.println("ID를 입력하시오.");
			memb.setId(in.nextLine());
			System.out.println("PW를 입력하시오.");
			memb.setPw(in.nextLine());
			fo.write((memb.getId() + "/" + memb.getPw() + "\r\n" + imsi).getBytes());
			fo.flush();

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (fo != null)
					fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

void insert(ArrayList a) {

	try {
		
		String imsi = ""; 
		for(int i=0;i<a.size();i++) {
			imsi+=a.get(i)+"/"+a.get(i+1)+"\r\n";
			i++;
		}
		fo = new FileOutputStream(targetFile);

		fo.write(imsi.getBytes());
		fo.flush();

	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		try {
			if (fo != null)
				fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
}