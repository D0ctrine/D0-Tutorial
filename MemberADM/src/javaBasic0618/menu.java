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
	default : System.out.println("잘못된 값을 입력");
}
}//end switch

}
void pmenu() {
	System.out.println("고객관리 프로그램");
	System.out.println("1.회원가입 ");
	System.out.println("2.회원수정 ");
	System.out.println("3.회원삭제 ");
	System.out.println("4.전체명단 ");
	System.out.println("5.회원검색 ");
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
