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
				default :System.out.println("�߸��� ���Է�!");
							
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
	
	System.out.println("������������������������������������������������");
	System.out.println("���ٱ����屹 �������Դϴ�~~^^");
	System.out.println("1. �մ��ڸ�����");
	System.out.println("2. �¼���������");
	System.out.println("3. �޴��������");
	System.out.println("������������������������������������������������");

}//end menuinfo()



}
