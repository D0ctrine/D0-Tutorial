package SitInfo;

import java.util.Scanner;

import object.member;

public class chair {
	member[] chairnum;
	Scanner in = new Scanner(System.in);
	boolean flag = true;
	int num,big=30000,mid=20000,small=10000;
	int tnum,gnum;
	String[] menu = new String[3];
	

public chair(){
		
		if(chairnum==null) {
			chairnum=new member[20]; // [1][i] �� ���̺� ��ȣ [2][i]�� �ο� �������
		}

		chairinfo();
		
		
		
		while(flag)
		{
			menu();
			num=in.nextInt();
			switch(num) {
			case 1:order();break;
			case 2:orderadd();break;
			case 3:orderdel();break;
			case 4:orderlist();break;
				default :System.out.println("�߸��� ���Է�!");
							
			}//end switch
			
			
		}
		
		
	}
	public void chairlist() {
		for(int i=0;i<20;i++) {
				
					System.out.print(i+1+"�� ���̺�"+"\t");	
				
				if(chairnum[i]!=null) {
					System.out.print("[�մ� �ο�"+chairnum[i].getCount()+"]"+"�ݾ� :"+chairnum[i].getPrice()+"��");
			}
				System.out.println();
		}
	}
	public void orderlist() {
		// TODO Auto-generated method stub
		System.out.println("�� �� ���̺��Դϱ�?");
		tnum=in.nextInt();
		System.out.println(tnum+"�� ���̺� �޴� �����Դϴ�.");
		for(int i=0;i<10;i++) {
			System.out.println(chairnum[tnum].getName()[i]);
		}//end for
		System.out.println(tnum+"�� ���̺� �ݾ� �����Դϴ�.");
		System.out.println(chairnum[tnum].getPrice());
	}

	private void orderdel() {
		// TODO Auto-generated method stub
		int num1;
		System.out.println("�� �� ���̺��Դϱ�?");
		tnum=in.nextInt();
		System.out.println(tnum+"�� ���̺� �޴� �����Դϴ�.");
		for(int i=0;i<10;i++) {
			System.out.println(chairnum[tnum].getName()[i]);
		}//end for
		System.out.println("����� �ֹ� ��ȣ�� �Է����ּ���.");
		num1=in.nextInt();
		chairnum[tnum].setName(num1, null); // �����ϰ� �޴� ������.....

		System.out.println("����� �޴��� �ݾ��� �������ּ���.");
		System.out.println("1.10000");
		System.out.println("2.20000");
		System.out.println("3.30000");
		num1=in.nextInt();
		switch(num1) {
		case 1:chairnum[tnum].setMinPrice(small);break;
		case 2:chairnum[tnum].setMinPrice(mid);break;
		case 3:chairnum[tnum].setMinPrice(big);break;
		default : System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
		}
		
			
	}
	

	private void orderadd() {
		// TODO Auto-generated method stub
		while(flag)
		{
			menu();
			num=in.nextInt();
			in.nextLine();
			System.out.println("�� �� ���̺��Դϱ�?");
			tnum=in.nextInt();
			switch(num) {
			case 1:{
				chairnum[tnum].setPrice(big);break;
			}
			case 2:{
				chairnum[tnum].setPrice(mid);break;
			}
			case 3:{
				chairnum[tnum].setPrice(small);break;
		}
				default :System.out.println("�߸��� ���Է�!");
							
			}//end switch
			
			for(int i=0;i<10;i++) {
				if(chairnum[tnum].getName()[i]==null)
				chairnum[tnum].setName(i,menu[num]);
				else {
					System.out.println("�޴� ������ �ʰ��ϼ̾�� �Ф� �׸��� �弼��...");
				}
			}//end for
			
			
		}//end while
	}

	private void order() {
		// TODO Auto-generated method stub
		foodmenu();
		
		while(flag)
		{
			menu();
			num=in.nextInt();
			in.nextLine();
			System.out.println("�� �� ���̺��Դϱ�?");
			tnum=in.nextInt();
			switch(num) {
			case 1:{
				chairnum[tnum].setPrice(big);break;
			}
			case 2:{
				chairnum[tnum].setPrice(mid);break;
			}
			case 3:{
				chairnum[tnum].setPrice(small);break;
		}
				default :System.out.println("�߸��� ���Է�!");
							
			}//end switch
			
			for(int i=0;i<20;i++) {
				if(chairnum[tnum].getName()[i]==null)
				chairnum[tnum].setName(i,menu[num]);
				else {
					System.out.println("�޴� ������ �ʰ��ϼ̾�� �Ф� �׸��� �弼��...");
				}
			}
		
			
		}//end while
		
	}

	void foodmenu(){
		menu[1]="���ٱ� ���屹(� )";
		menu[2]="���ٱ� ���屹(��)";
		menu[3]="���ٱ� ���屹(��)";
		System.out.println("1."+menu[1]+"| 2~3�κ�");
		System.out.println("2."+menu[2]+"| 3~4�κ�");
		System.out.println("3."+menu[3]+"| 4~5�κ�");
	}
	
	void menu(){
		System.out.println("1.�ֹ��ϱ�");
		System.out.println("2.�ֹ��߰�");
		System.out.println("3.�ֹ�����");
		System.out.println("4.�ֹ�����");
	}
	
	void chairinfo() {
		
		
		flag=true;
		while(flag) {
		for(int i=0;i<chairnum.length;i++) {
			chairnum[i].setMid(i+1);
			
		}//end for
		System.out.println("�׷��ο��� �� ����Դϱ�?");
		gnum=in.nextInt();
		System.out.println("��� ���̺��� �����Ͻðڽ��ϱ�?");
		tnum=in.nextInt();
				if(chairnum[tnum].getMid()==0) {
					
					chairnum[tnum].setCount(gnum);
					System.out.println(tnum+"�� ���̺��� �����ϼ̽��ϴ�.");
					in.nextLine();
					flag=false;
				}else {
					System.out.println("�մ��� �̹� �ֽ��ϴ�.");
				}//end else
			
		}//end while
		
	}
	
	
	
}
