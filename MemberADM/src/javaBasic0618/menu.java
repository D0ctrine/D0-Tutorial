package javaBasic0618;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {
	Scanner in = new Scanner(System.in);
	static memberDAO dao = memberDAO.getInstance();
	memberDTO dto = new memberDTO();
	static ArrayList<memberDTO> list = dao.getList();
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
	default : System.out.println("�߸��� ���� �Է�");
}
}//end switch

}
void pmenu() {
	System.out.println("������ ���α׷�");
	System.out.println("1.ȸ������ ");
	System.out.println("2.ȸ������ ");
	System.out.println("3.ȸ������ ");
	System.out.println("4.��ü��� ");
	System.out.println("5.ȸ���˻� ");
}
public static void call() {
	for (int i = 0; i < list.size(); i++) {
		System.out.print(list.get(i).getId()+"\t");
		System.out.print(list.get(i).getName()+"\t");
		System.out.print(list.get(i).getAge()+"\t");
		System.out.print(list.get(i).getGender()+"\t");
		System.out.print(list.get(i).getJob()+"\n");
	}	
}

}
