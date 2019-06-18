package Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import Menu.MenuMain;
import Menu.OneMenu;

public class TableInfo {
	private ArrayList<OneMenuInfo> orderList=new ArrayList<>(); // 내가 주문한 메뉴내역
	private ArrayList<OneMenu> nowMenu= new ArrayList<>();   // 가게의 메뉴판
	private Scanner in = new Scanner(System.in);
	private MenuMain mm = null;
	public OneMenuInfo imsiOne = new OneMenuInfo();
	public TableInfo(){
		
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
	public void init(){
		mm = MenuMain.getInstance();
		nowMenu = mm.getMenuList();
	}

	public void menuMain() {
		boolean flag = true;
		while(flag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: add(); break;
			case 2: list(); break;
			case 3: flag=false; break;
				default : 
			}
		}
	}
	
	
	/*
	 * private void menuList() { for(int i=0; i < nowMenu.size(); i++) {
	 * System.out.println("메뉴번호 "+i+":"+nowMenu.get(i).getMenuName()+
	 * "/"+nowMenu.get(i).getMenuPrice()); } }
	 */
	
	public void list() {
		
		mm.getMenuList();
	}
	
	private void add() {
		
		mm.getMenuList();
		System.out.println(" 메뉴 번호를 선택하세요 : ");
		int menuNum = in.nextInt();
		in.nextLine();
		System.out.println(" 수량을 선택하세요");
		int menuNumCnt = in.nextInt();
		in.nextLine();
		
		
		imsiOne.setOneMenuFlag(menuNum);
		imsiOne.setMenuName(nowMenu.get(menuNum).getMenuName());
		imsiOne.setMenuPrice(nowMenu.get(menuNum).getMenuPrice());
		imsiOne.setCnt(menuNumCnt);

		orderList.add(imsiOne);
		
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
	
		
		try {
			//쿼리 작성단계
		ppst = conn.prepareStatement("insert into cur_menu values(curid_seq.nextVal,?,?,current_timestamp,?,?)");
		ppst.setString(1, imsiOne.getMenuName());
		ppst.setInt(2, imsiOne.getMenuPrice());
		ppst.setInt(3, imsiOne.getTableNum());
		ppst.setInt(4, imsiOne.getCnt());
		
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
	public void menu() {
		System.out.println("-- tableInfo Menu ---");
		System.out.println(" 1. 메뉴선택");
		System.out.println(" 2. 주문내역");
		System.out.println(" 3. 이전메뉴로");
	}
	
	
	
	
	

}
