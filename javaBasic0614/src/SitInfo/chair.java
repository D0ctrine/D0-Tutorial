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
			chairnum=new member[20]; // [1][i] 는 테이블 번호 [2][i]는 인원 몇명인지
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
				default :System.out.println("잘못된 값입력!");
							
			}//end switch
			
			
		}
		
		
	}
	public void chairlist() {
		for(int i=0;i<20;i++) {
				
					System.out.print(i+1+"번 테이블"+"\t");	
				
				if(chairnum[i]!=null) {
					System.out.print("[손님 인원"+chairnum[i].getCount()+"]"+"금액 :"+chairnum[i].getPrice()+"원");
			}
				System.out.println();
		}
	}
	public void orderlist() {
		// TODO Auto-generated method stub
		System.out.println("몇 번 테이블입니까?");
		tnum=in.nextInt();
		System.out.println(tnum+"번 테이블 메뉴 내역입니다.");
		for(int i=0;i<10;i++) {
			System.out.println(chairnum[tnum].getName()[i]);
		}//end for
		System.out.println(tnum+"번 테이블 금액 내역입니다.");
		System.out.println(chairnum[tnum].getPrice());
	}

	private void orderdel() {
		// TODO Auto-generated method stub
		int num1;
		System.out.println("몇 번 테이블입니까?");
		tnum=in.nextInt();
		System.out.println(tnum+"번 테이블 메뉴 내역입니다.");
		for(int i=0;i<10;i++) {
			System.out.println(chairnum[tnum].getName()[i]);
		}//end for
		System.out.println("지우실 주문 번호를 입력해주세요.");
		num1=in.nextInt();
		chairnum[tnum].setName(num1, null); // 가격하고 메뉴 묶어놀걸.....

		System.out.println("지우신 메뉴에 금액을 선택해주세요.");
		System.out.println("1.10000");
		System.out.println("2.20000");
		System.out.println("3.30000");
		num1=in.nextInt();
		switch(num1) {
		case 1:chairnum[tnum].setMinPrice(small);break;
		case 2:chairnum[tnum].setMinPrice(mid);break;
		case 3:chairnum[tnum].setMinPrice(big);break;
		default : System.out.println("잘못된 값을 입력하셨습니다.");
		}
		
			
	}
	

	private void orderadd() {
		// TODO Auto-generated method stub
		while(flag)
		{
			menu();
			num=in.nextInt();
			in.nextLine();
			System.out.println("몇 번 테이블입니까?");
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
				default :System.out.println("잘못된 값입력!");
							
			}//end switch
			
			for(int i=0;i<10;i++) {
				if(chairnum[tnum].getName()[i]==null)
				chairnum[tnum].setName(i,menu[num]);
				else {
					System.out.println("메뉴 범위를 초가하셨어요 ㅠㅠ 그만좀 드세여...");
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
			System.out.println("몇 번 테이블입니까?");
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
				default :System.out.println("잘못된 값입력!");
							
			}//end switch
			
			for(int i=0;i<20;i++) {
				if(chairnum[tnum].getName()[i]==null)
				chairnum[tnum].setName(i,menu[num]);
				else {
					System.out.println("메뉴 범위를 초가하셨어요 ㅠㅠ 그만좀 드세여...");
				}
			}
		
			
		}//end while
		
	}

	void foodmenu(){
		menu[1]="뼈다귀 해장국(小 )";
		menu[2]="뼈다귀 해장국(中)";
		menu[3]="뼈다귀 해장국(大)";
		System.out.println("1."+menu[1]+"| 2~3인분");
		System.out.println("2."+menu[2]+"| 3~4인분");
		System.out.println("3."+menu[3]+"| 4~5인분");
	}
	
	void menu(){
		System.out.println("1.주문하기");
		System.out.println("2.주문추가");
		System.out.println("3.주문삭제");
		System.out.println("4.주문보기");
	}
	
	void chairinfo() {
		
		
		flag=true;
		while(flag) {
		for(int i=0;i<chairnum.length;i++) {
			chairnum[i].setMid(i+1);
			
		}//end for
		System.out.println("그룹인원은 총 몇명입니까?");
		gnum=in.nextInt();
		System.out.println("몇번 테이블을 선택하시겠습니까?");
		tnum=in.nextInt();
				if(chairnum[tnum].getMid()==0) {
					
					chairnum[tnum].setCount(gnum);
					System.out.println(tnum+"번 테이블을 선택하셨습니다.");
					in.nextLine();
					flag=false;
				}else {
					System.out.println("손님이 이미 있습니다.");
				}//end else
			
		}//end while
		
	}
	
	
	
}
