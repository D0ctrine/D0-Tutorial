package ShoppingUser;

import java.util.ArrayList;
import java.util.Scanner;

import GoodsADM.ShopADM;
import Object.Goods;
import Object.Member;

public class MemberShopping {
	private Scanner in = new Scanner(System.in);
	private Member nowUser = null;
	private ShopADM shopLink = null;
	
	public MemberShopping(Member m) {
		this.nowUser=m;
		shopLink = ShopADM.getInstance();
		infoUser();
		boolean pFlag=true;
		while(pFlag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: list(); break;
			case 2: viewBasket(); break;
		//	case 3: del(); break;
			default: pFlag=false;
			}
		}
	}
	
	private void viewBasket() {
		// TODO Auto-generated method stub
		
	}

	private void list() {
		ArrayList<Goods> glist = shopLink.getgList();
		for(int i=0; i <glist.size(); i++) {
			System.out.println(i+"�� : "+glist.get(i).getName()+"/"+glist.get(i).getCnt());
		}
		System.out.println("�����Ͻ� ������ ��ȣ�� �Է��ϼ��� : ������ x�� �Է��ϼ���");
		int gnum = in.nextInt();
		
		
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. ��ǰ����");
		System.out.println("2. ��ٱ��Ϻ���");
		System.out.println("3. �����޴�");
	}

	private void infoUser() {
		System.out.println(nowUser.getId()+"/"+nowUser.getName()+"�� ");
	}
}
