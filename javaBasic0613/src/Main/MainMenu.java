package Main;

import java.util.Scanner;
import GoodsADM.ShopADM;
import MemberADM.MemberCenter;
import Object.Member;
import ShoppingUser.MemberShopping;

public class MainMenu {
	// 1. 회원관리, 2. 쇼핑, 3. 로그인
	private Scanner in = new Scanner(System.in);
	private MemberCenter mc=null;
	private ShopADM shopM = null;
	
	MainMenu(){
		boolean pFlag=true;
		while(pFlag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: member(); break;
			case 2: shop(); break;
			case 3: logIn(); break;
			case 4: pFlag=false;
			}
		}
		
	}
	private void logIn() {
		// TODO Auto-generated method stub
		// 로그인 성공 - > member shopping
		//ShoppingUser.MemberShopping.getInstance();
		System.out.println("id를 입력하세요");
		String id = in.nextLine();
		//boolean chk = mc.logMember(id);
		// 2차 수정 - 로그인 한 정보가 이써야 mebershopping에서 현재 사용자를 전달할 수 있다
		Member nowM= mc.logMember(id);
		if(nowM != null) {
			new MemberShopping(nowM);
			Member m = new Member();
			MemberShopping a = new MemberShopping(m);
			
			
		}
	}
	private void shop() {
		// TODO Auto-generated method stub
		shopM = ShopADM.getInstance();
		shopM.shopManager();
	}
	private void member() {
		// TODO Auto-generated method stub
		mc=MemberCenter.getInstance();
		mc.memberprocess();
		//new MemberCenter();
	}
	private void menu() {
		System.out.println(" 메뉴를 선택하세요 ");
		System.out.println("1. 회원관리");
		System.out.println("2. 쇼핑관리");
		System.out.println("3. 로그인");
		System.out.println("4. 종료");
	}

}
