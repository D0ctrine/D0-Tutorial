package Main;

import java.util.Scanner;

import SitInfo.chair;

public class MainMenu {
	
	Scanner in = new Scanner(System.in);
	chair ch=null;
	
	MainMenu(){
	
		boolean flag = true;
		int num;
		
		
		
		while(flag) {
			menuinfo();	
			num =in.nextInt();
			switch(num) {
			case 1:guestsit();break;
			case 2:sitinfo();break;
			case 3:menuadm();break;
				default :System.out.println("잘못된 값입력!");
							
			}//end switch
			
		}//end while
	
	
	}
	

private void menuadm() {
		// TODO Auto-generated method stub
	if(ch==null) {
		ch=new chair();
	}
	ch.chairlist();
}


private void sitinfo() {
		// TODO Auto-generated method stub
		
	}


private void guestsit() {
		// TODO Auto-generated method stub
	
	
		
	}



void menuinfo() {
	
	System.out.println("────────────────────────");
	System.out.println("뼈다귀해장국 전문점입니다~~^^");
	System.out.println("1. 손님자리배정");
	System.out.println("2. 좌석정보보기");
	System.out.println("3. 메뉴관리기능");
	System.out.println("────────────────────────");

}//end menuinfo()



}
