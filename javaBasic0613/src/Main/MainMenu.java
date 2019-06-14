package Main;

import java.util.Scanner;
import GoodsADM.ShopADM;
import MemberADM.MemberCenter;
import Object.Member;
import ShoppingUser.MemberShopping;

public class MainMenu {
	// 1. ȸ������, 2. ����, 3. �α���
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
		// �α��� ���� - > member shopping
		//ShoppingUser.MemberShopping.getInstance();
		System.out.println("id�� �Է��ϼ���");
		String id = in.nextLine();
		//boolean chk = mc.logMember(id);
		// 2�� ���� - �α��� �� ������ �̽�� mebershopping���� ���� ����ڸ� ������ �� �ִ�
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
		System.out.println(" �޴��� �����ϼ��� ");
		System.out.println("1. ȸ������");
		System.out.println("2. ���ΰ���");
		System.out.println("3. �α���");
		System.out.println("4. ����");
	}

}
