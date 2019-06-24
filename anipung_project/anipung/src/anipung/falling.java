package anipung;

import java.util.ArrayList;

import javax.swing.JButton;


public class falling {

	ArrayList<String> box =null;

	
	falling(String[][] s){
		
		f_sero(s);
		


	}
public falling(JButton[][] gameB){
		
		f_sero(gameB);
		


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
	 public	 void f_sero(JButton[][] gameB){
			int num;
			for(int i=0;i<5;i++) {
				box = new ArrayList<String>();
				
				for(int j=4;j>=0;j--) {
					if(gameB[j][i].getText().equals("0")) {
						
					}else {
						box.add(gameB[j][i].getText());
					}
				}
				
				num=box.size();
				num=0;
				for(int j=4;j>=0;j--) {
					
						if(num<box.size()) {
							gameB[j][i].setText(box.get(num));
						}else {
							gameB[j][i].setText(" ");
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
