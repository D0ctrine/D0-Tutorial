package javaBasic0618;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Gesi.gesipan;

public class menu {
	Scanner in = new Scanner(System.in);
	static memberDAO dao = memberDAO.getInstance();
	static gesipan get = gesipan.getInstance();
	memberDTO dto = new memberDTO();
	 static ArrayList<memberDTO> list ;
	int num;

	menu(){
		boolean flag=true;
		while(flag) {
	pmenu();
	num = in.nextInt();
	switch(num) {
	case 1:dao.insert(dto);break;
	case 2:dao.update(dto);break;
	case 3:dao.delete(dto);break;
	case 4:call();break;
	case 5:dao.getSearch();break;
	case 6:dao.read(dto);break;
	case 7:get.gmenu();break;

	default : System.out.println("�߸��� ���� �Է�");
}
}//end switch

}
void pmenu() {
	System.out.println("-------------");
	System.out.println("������ ���α׷�");
	System.out.println("1.ȸ������ ");
	System.out.println("2.ȸ������ ");
	System.out.println("3.ȸ������ ");
	System.out.println("4.��ü��� ");
	System.out.println("5.ȸ���˻� ");
	System.out.println("6.���������� ");
	System.out.println("7.�Խ��� ");
	System.out.println("-------------");
}
public static void call() {
	 list = dao.getList();	
}

}