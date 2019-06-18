package Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.Scanner;



public class MenuMain {
	private ArrayList<OneMenu> menuList = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	private static MenuMain mm=null;
	
	private MenuMain(){
		
	}
	
	
	
	public static MenuMain getInstance() {
		if(mm==null) {
			mm = new MenuMain();
		}
		return mm;
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
	
	public void menuMain() {
		boolean flag = true;
		while(flag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: add(); break;
			case 2: getMenuList(); break;
			case 3: del(); break;
			case 4: mod(); break;
			case 5: flag=false; break;
				default : 
			}
		}
	}
	
	public ArrayList<OneMenu> getMenuList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		int i=0;
		try {
			ppst = conn.prepareStatement("select * from OneMenu");
			
			rs= ppst.executeQuery();
			
			if(rs.next()) {
			
				
				do {
					OneMenu dto = new OneMenu();
					dto.setId(rs.getInt("ID"));
					dto.setMenuName(rs.getString("NAME"));
					dto.setMenuPrice(rs.getInt("Price"));
					menuList.add(dto);
					System.out.print(menuList.get(i).getId()+"번 :"+
							"\t"+menuList.get(i).getMenuName()+"\t"+menuList.get(i).getMenuPrice()+"\n");
					i++;	
				}while(rs.next());
					
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
		
		return menuList;
	}
	private void mod() {
		// TODO Auto-generated method stub
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		OneMenu imsiM = new OneMenu();
		try {
			//쿼리 작성단계
		
		ppst1 = conne.prepareStatement("update OneMenu set name=?,price=? where id=?");
		ppst1.setString(1, imsiM.getMenuName());
		ppst1.setInt(2,imsiM.getMenuPrice());
		ppst1.setInt(3,imsiM.getId());
		
		//쿼리 수행단계
		ppst1.executeUpdate();
		System.out.println("갱신처리가 완료되었습니다.");
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
	}

	private void del() {
		// TODO Auto-generated method stub
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		
		try {
			//쿼리 작성단계
		
		ppst1 = conne.prepareStatement("delete from OneMenu");
		//ppst1.setInt(1,memberDTO.getId());
		
		//쿼리 수행단계
	
		int a = ppst1.executeUpdate();
		
		if(a >0) {
			
			System.out.println(a+"건 삭제처리가 완료되었습니다. ");
		}else {
			System.out.println("삭제할 데이터가 없습니다.");
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
		
	}

	private void menu() {
		System.out.println("메뉴선택 ------------");
		System.out.println(" 1. 메뉴추가 ------------");
		System.out.println(" 2. 메뉴보기 ------------");
		System.out.println(" 3. 메뉴삭제 ------------");
		System.out.println(" 4. 메뉴수정 ------------");
		System.out.println(" 5. 메뉴관리종료 ------------");
	}
	/*
	 * private void list() { // TODO Auto-generated method stub for(int i=0; i <
	 * menuList.size(); i++) {
	 * System.out.println("메뉴번호 "+i+":"+menuList.get(i).getMenuName()+
	 * "/"+menuList.get(i).getMenuPrice()); } }
	 */

	private void add() {
		
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		OneMenu imsiM = new OneMenu();
		System.out.println("메뉴이름을 입력하세요");
		imsiM.setMenuName(in.nextLine());
		
		System.out.println("메뉴가격을 입력하세요");
		imsiM.setMenuPrice(in.nextInt());
		in.nextLine();
		
		menuList.add(imsiM);
		
		try {
			//쿼리 작성단계
		ppst = conn.prepareStatement("insert into OneMenu values(menu_seq.nextVal,?,?)");
		ppst.setString(1, imsiM.getMenuName());
		ppst.setInt(2, imsiM.getMenuPrice());

		
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
		
		
		
	}
	

}






