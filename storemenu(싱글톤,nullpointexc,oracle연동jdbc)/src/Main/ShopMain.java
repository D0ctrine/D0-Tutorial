package Main;

import java.util.Scanner;

import Menu.*;
import Table.TableInfo;

public class ShopMain {
	private TableInfo[] tableInfo = new TableInfo[5];
	private Scanner in = new Scanner(System.in);
	private MenuMain menumain=null;
	ShopMain(){
		setting();
		init();
	}
	private void setting() {
		menumain=MenuMain.getInstance();
	}
	
	private void init() {
		while(true) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: newTable(); break;
			case 2: tableList(); break;
			case 3: exitTable(); break;
			case 4: menuADM(); break;
				default :
			}
		}
	}
	private void exitTable() {
		System.out.println(" 몇 번 table 이세요 ?");
		int delNum = in.nextInt();
		in.nextLine();
		System.out.println(" 금액 : ");
		System.out.println(" 이용해 주셔서 감사합니다.!!!");
		tableInfo[delNum]=null;
	}
	private void menuADM() {
		menumain.menuMain();
	}
	private void tableList() {
		for(int i=0; i < tableInfo.length; i++) {
			System.out.println("--[ "+i+" ] Table  정보 ---");
			if(tableInfo[i]!=null) {
				System.out.println("  : 주문정보");
				tableInfo[i].list();
			}else {
				System.out.println("  : 빈자리");
			}
		}
	}
	private void newTable() {
		for(int i=0; i < tableInfo.length; i++) {
			if(tableInfo[i]==null) {
				TableInfo newTable = new TableInfo();
				System.out.println(i+"번 Table로 안내하겠습니다.");
				newTable.imsiOne.setTableNum(i);
				
				System.out.println(" 메뉴를 선택하여 주세요 ------");
				
				newTable.menuMain();
				tableInfo[i]=newTable;
				newTable=null;
				break;
			}
		}
	}
	private void menu() {
		System.out.println("메뉴선택 ------------");
		System.out.println(" 1. 좌석배정 ------------");
		System.out.println(" 2. 좌석정보 ------------");
		System.out.println(" 3. 계산하기 ------------");
		System.out.println(" 4. 메뉴관리 ------------");
	}

}
