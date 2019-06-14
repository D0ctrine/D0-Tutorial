package gusetsit;

import java.util.Scanner;

public class guestadm {

	Scanner in = new Scanner(System.in);
	
	guestadm(){

		boolean flag = true;
		int num;
		
		while(flag) {
		
			num =in.nextInt();
			switch(num) {
			case 1:break;
			case 2:break;
			case 3:break;
				default :System.out.println("잘못된 값입력!");
							
			}//end switch
			
		}//end while
	}
	
	
	
}
