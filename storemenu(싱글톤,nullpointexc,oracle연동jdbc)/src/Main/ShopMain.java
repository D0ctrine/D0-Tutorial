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
		System.out.println(" �� �� table �̼��� ?");
		int delNum = in.nextInt();
		in.nextLine();
		System.out.println(" �ݾ� : ");
		System.out.println(" �̿��� �ּż� �����մϴ�.!!!");
		tableInfo[delNum]=null;
	}
	private void menuADM() {
		menumain.menuMain();
	}
	private void tableList() {
		for(int i=0; i < tableInfo.length; i++) {
			System.out.println("--[ "+i+" ] Table  ���� ---");
			if(tableInfo[i]!=null) {
				System.out.println("  : �ֹ�����");
				tableInfo[i].list();
			}else {
				System.out.println("  : ���ڸ�");
			}
		}
	}
	private void newTable() {
		for(int i=0; i < tableInfo.length; i++) {
			if(tableInfo[i]==null) {
				TableInfo newTable = new TableInfo();
				System.out.println(i+"�� Table�� �ȳ��ϰڽ��ϴ�.");
				newTable.imsiOne.setTableNum(i);
				
				System.out.println(" �޴��� �����Ͽ� �ּ��� ------");
				
				newTable.menuMain();
				tableInfo[i]=newTable;
				newTable=null;
				break;
			}
		}
	}
	private void menu() {
		System.out.println("�޴����� ------------");
		System.out.println(" 1. �¼����� ------------");
		System.out.println(" 2. �¼����� ------------");
		System.out.println(" 3. ����ϱ� ------------");
		System.out.println(" 4. �޴����� ------------");
	}

}
