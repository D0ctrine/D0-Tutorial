package Gesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javaBasic0618.memberDAO;
import javaBasic0618.memberDTO;

public class gesipan {
	private static gesipan gesiInstance;
	Scanner in = new Scanner(System.in);
	gesiDTO dto = new gesiDTO();
	gesiDTO crypt = new gesiDTO();
	ArrayList<gesiDTO> gesipw = new ArrayList<gesiDTO>();
	ArrayList<gesiDTO> gesiDTOList = null;
	gesipan(){
		
	}
	public static gesipan getInstance() {
		if(gesiInstance == null){
			gesiInstance = new gesipan();
		}
		return gesiInstance;
	}
	
	public void gmenu() {
		
		int num;


			boolean flag=true;
			while(flag) {
				gesimenu();
				num = in.nextInt();
				in.nextLine();
				switch(num) {
	case 1:insert(dto);break;
	case 2:getList();break;
	case 3:delete(dto);break;
	case 4:flag=false;break;
		default : System.out.println("�߸��� ���� �Է�");
		

	}
	}
	}
	void gesimenu(){
		System.out.println("==============");
		System.out.println("   <�Խ���>");
		System.out.println("1. �Խù� �ۼ�");
		System.out.println("2. �Խù� ����");
		System.out.println("3. �Խù� ����");
		System.out.println("4. �Խù� ����");
	}
	public Connection getConnection(){
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");

		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}
		return conn;
	}
	public void insert(gesiDTO gesi) {
		/*
		 * 1.c
		 * 2.Connection ����
		 * 3.���� ����
		 * 4.���
		 */
		//����̹��ε� + connection ����� �ܰ�
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		String imsi;

		System.out.println("����� �̸��� �Է����ּ���.");
		dto.setId(in.nextLine());
		System.out.println("�Խ��� ���� : ");
		imsi = in.nextLine();
		long Time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dayTime.format(new Date(Time));
		System.out.println("���� :");
		
		dto.setWrite("���� : "+imsi+"\n"+"���� :"+in.nextLine()+"\n"+"�ۼ��ð� :"+str);
		
		/*
		 * System.out.println("�Խù��� ��й�ȣ�� �����Ͻðڽ��ϱ�?"+"\n"+"( yes | no )"); String
		 * pw=in.nextLine(); if(pw.equals("yes")) { crypt=new gesiDTO();
		 * crypt.setId(dto.getId()); pw=in.nextLine(); crypt.setWrite(pw);
		 * gesipw.add(crypt);
		 * 
		 * }
		 */
		
		
		try {
			//���� �ۼ��ܰ�
		ppst = conn.prepareStatement("insert into gesipan values(?,?)");
		ppst.setString(1, dto.getId());
		ppst.setString(2, dto.getWrite());
	
		
		//���� ����ܰ�
		ppst.executeUpdate();
		System.out.println("�Է�ó���� �Ϸ�Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}//end insert()
	public ArrayList<gesiDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
	
		try {
			ppst = conn.prepareStatement("select * from gesipan");
			
			rs= ppst.executeQuery();
			int i=0;
			if(rs.next()) {
				gesiDTOList = new ArrayList<gesiDTO>();
				System.out.println("============================");
				do {
					
					dto.setId(rs.getString("id"));
					dto.setWrite(rs.getString("message"));
					gesiDTOList.add(dto);
					System.out.print((i+1)+"�� �Խù�"+"\n"+"["+gesiDTOList.get(i).getId()+']'+"\n"+gesiDTOList.get(i).getWrite()+"\n");
					System.out.println("============================");
					i++;
					
				}while(rs.next());
				System.out.println("Ȯ�� : Enter");
				in.nextLine();
				}//end if
				}//end try
				catch(Exception e) {
					System.out.println("SQL Error");
				}finally {
					try {
						if(ppst != null) ppst.close();
						if(conn != null) conn.close();
						if(rs != null) conn.close();
					}catch(Exception e) {
						System.out.println("connection close error");
					}//end catch
				}//end finally
		
		return gesiDTOList;
	}
	public void delete(gesiDTO dto) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		getList();
		String pw;
/*		boolean flag =true;
		while(flag) {
System.out.println("����� 'exit' ����� 'go' �Է¹ٶ��ϴ�.");
			String num=in.nextLine();
		switch(num) {
		case "exit":flag=false;break;
		case "go": break;
		default : System.out.println("�̿� ���� �����̳׿�.");continue;
		}*/
		System.out.println("�۽��� ���� �Է����ּ���.");
		dto.setId(in.nextLine());
	/*	for(int i=0;i<gesipw.size();i++) {
			
			if(dto.getId().equals(gesipw.get(i).getId())) {
				System.out.println("��й�ȣ : ");
				pw=in.nextLine();
				if(pw.equals(gesipw.get(i).getWrite())) {
					*/
		
		try {
			//���� �ۼ��ܰ�
		
		ppst1 = conne.prepareStatement("delete from gesipan where=?");
		ppst1.setString(1,dto.getId());
		
		//���� ����ܰ�
	
		int a = ppst1.executeUpdate();
		System.out.println(a);
		if(a >0) {
			
			System.out.println(a+"�� ����ó���� �Ϸ�Ǿ����ϴ�. /");
		}else {
			System.out.println("������ �����Ͱ� ����ֽ��ϴ�.");
		}
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst1 != null) ppst1.close();
				if(conne != null) conne.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
				//}//end small if
			//}//end if
	//}//end for
		}
	}
//}
