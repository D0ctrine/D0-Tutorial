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
	private Goods basket=null;
	ArrayList<Goods> basketlist = null;
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
		
		
		if(basketlist==null) {
			basketlist = new ArrayList<Goods>();
		}
	
		basketlist.add(basket);
		for(int i=0; i<basketlist.size();i++) {
		
			System.out.println("�� : "+basket.getId()+"/"+basket.getName()+"/"+basketlist.get(i).getCnt());
		}
		
	}

	private void list() {
		ArrayList<Goods> glist = shopLink.getgList();
		int i;
		
		boolean flag=true;
		for(i=0; i <glist.size(); i++) {
			System.out.println((i+1)+"�� : "+glist.get(i).getName()+"/"+glist.get(i).getCnt());
		}
		while(flag) {
			basket = new Goods();
		System.out.println("��ٱ��� ������ ������ ��ȣ�� �Է��ϼ��� : ������ x�� �Է��ϼ���");
		String gnum = in.nextLine();
		
		for(int d=0;d<glist.size();d++) {
		if(gnum.equals(glist.get(d).getName())) {
			basket.setName(glist.get(d).getName());
		}
		
		}
	//	String ans;
		basket.setId(gnum);  
		System.out.println("��� ��ðڽ��ϱ�?");
		int cnum = in.nextInt();
		in.nextLine();
		basket.setCnt(cnum);
		if(cnum<=glist.get(i-1).getCnt()) {
			cnum = cnum-glist.get(i-1).getCnt();
			flag = false;
			/*
			System.out.println("���� ����Ͻðڽ��ϱ�? yes | no");
			ans = in.nextLine();
			if(ans.equals("yes")) {
				
			}else {
				flag = false;
			}
			*/
		}else {
			System.out.println("������ �ʰ� �����ϼ̽��ϴ�.");
			System.out.println("(�ٽ� ����ּ���~)");
		}//end else
		
		}//end while
		
		
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
