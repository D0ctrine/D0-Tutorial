package anipung;

import java.util.ArrayList;


public class falling {

	ArrayList<String> box =null;

	
	falling(String[][] s){
		
		f_sero(s);
		
		System.out.println();

	}
	


	
	 void f_sero(String[][] s){
		int num;
		for(int i=0;i<5;i++) {
			box = new ArrayList<String>();
			
			for(int j=4;j>=0;j--) {
				if(s[j][i].equals("0")) {
					
				}else {
					box.add(s[j][i]);
				}
			}
			
			num=box.size();
			num=0;
			for(int j=4;j>=0;j--) {
				
					if(num<box.size()) {
						s[j][i]=box.get(num);
					}else {
						s[j][i]=" ";
					}
					num++;
			}//end small for
			
		}//end big for
		
	}//end f_sero()
	
	 
	 
	 /*
	void f_garo(String[][] s) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				
				if(!s[i][j].equals("0"))
				box.add(s[i][j]);
				
			}
		}
	}
	*/
}
