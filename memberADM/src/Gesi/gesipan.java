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
		default : System.out.println("잘못된 값을 입력");
		

	}
	}
	}
	void gesimenu(){
		System.out.println("==============");
		System.out.println("   <게시판>");
		System.out.println("1. 게시물 작성");
		System.out.println("2. 게시물 보기");
		System.out.println("3. 게시물 삭제");
		System.out.println("4. 게시물 종료");
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
		 * 2.Connection 맺음
		 * 3.쿼리 수행
		 * 4.결과
		 */
		//드라이버로드 + connection 만드는 단계
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		String imsi;

		System.out.println("당신의 이름을 입력해주세요.");
		dto.setId(in.nextLine());
		System.out.println("게시할 제목 : ");
		imsi = in.nextLine();
		long Time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dayTime.format(new Date(Time));
		System.out.println("내용 :");
		
		dto.setWrite("제목 : "+imsi+"\n"+"내용 :"+in.nextLine()+"\n"+"작성시간 :"+str);
		
		/*
		 * System.out.println("게시물의 비밀번호를 설정하시겠습니까?"+"\n"+"( yes | no )"); String
		 * pw=in.nextLine(); if(pw.equals("yes")) { crypt=new gesiDTO();
		 * crypt.setId(dto.getId()); pw=in.nextLine(); crypt.setWrite(pw);
		 * gesipw.add(crypt);
		 * 
		 * }
		 */
		
		
		try {
			//쿼리 작성단계
		ppst = conn.prepareStatement("insert into gesipan values(?,?)");
		ppst.setString(1, dto.getId());
		ppst.setString(2, dto.getWrite());
	
		
		//쿼리 수행단계
		ppst.executeUpdate();
		System.out.println("입력처리가 완료되었습니다.");
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
					System.out.print((i+1)+"번 게시물"+"\n"+"["+gesiDTOList.get(i).getId()+']'+"\n"+gesiDTOList.get(i).getWrite()+"\n");
					System.out.println("============================");
					i++;
					
				}while(rs.next());
				System.out.println("확인 : Enter");
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
System.out.println("종료시 'exit' 진행시 'go' 입력바랍니다.");
			String num=in.nextLine();
		switch(num) {
		case "exit":flag=false;break;
		case "go": break;
		default : System.out.println("이외 값을 누르셨네요.");continue;
		}*/
		System.out.println("송신자 명을 입력해주세요.");
		dto.setId(in.nextLine());
	/*	for(int i=0;i<gesipw.size();i++) {
			
			if(dto.getId().equals(gesipw.get(i).getId())) {
				System.out.println("비밀번호 : ");
				pw=in.nextLine();
				if(pw.equals(gesipw.get(i).getWrite())) {
					*/
		
		try {
			//쿼리 작성단계
		
		ppst1 = conne.prepareStatement("delete from gesipan where=?");
		ppst1.setString(1,dto.getId());
		
		//쿼리 수행단계
	
		int a = ppst1.executeUpdate();
		System.out.println(a);
		if(a >0) {
			
			System.out.println(a+"건 삭제처리가 완료되었습니다. /");
		}else {
			System.out.println("삭제할 데이터가 비어있습니다.");
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
