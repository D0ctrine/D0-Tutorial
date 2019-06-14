package GoodsADM;

import java.util.ArrayList;
import java.util.Scanner;

import Object.Goods;

public class ShopADM {
	
	public ArrayList<Goods> getgList() {
		return gList;
	}
	private static ShopADM shoplink = null;
	private Scanner in = new Scanner(System.in);
	private ArrayList<Goods> gList = new ArrayList<>();
	private ShopADM() {
	}
	public static ShopADM getInstance() {
		if(shoplink == null) {
			shoplink = new ShopADM();
		}
		return shoplink;
	}
	public void shopManager() {
		boolean pFlag=true;
		while(pFlag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: insert(); break;
			case 2: list(); break;
			case 3: pFlag=false; break;
			}
		}
	}
	private void list() {
		for(int i=0; i <gList.size(); i++) {
			System.out.println(i+"번 : "+gList.get(i).getName()+"/"+gList.get(i).getCnt());
		}
		
	}
	private void insert() {
		Goods newGood = new Goods();
		System.out.println("물건의 이름 : ");
		String name = in.nextLine();
		System.out.println("물건의 수량: ");
		int cnt=in.nextInt();
		in.nextLine();
		
		newGood.setName(name);
		newGood.setCnt(cnt);
		
		gList.add(newGood);
		
	}
	private void menu() {
		System.out.println("1. 물품등록");
		System.out.println("2. 물품리스트");
		System.out.println("3. 이전메뉴");
	}

}
