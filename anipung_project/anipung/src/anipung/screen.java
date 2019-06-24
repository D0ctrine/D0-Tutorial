package anipung;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class screen {
	boolean flag;
	int num1;
	public String[][] sc=new String[5][5];
	Scanner in = new Scanner(System.in);
	rule rl=null;
	 Random r=new Random();
	public screen(){
		
		

	}
	
	
	public void rand() {
		
		
		 
		 for(int i=0;i<5;i++) {
			 for(int j=0;j<5;j++) {
				
				 num1=r.nextInt(5)+1;
				 String snum = Integer.toString(num1);
				 sc[i][j]=snum;
				
				 
				// System.out.print(sc[i][j]+"\t");
				 
			 }
			 
			// System.out.println();
		 }
	
}
	public void show(String[][] s) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				
				//System.out.print(s[i][j]+"\t");
			}
	//System.out.println();
		}
	}
	public boolean check(String[][] s) {
		int count=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {

				
			if(s[i][j].equals(" ")) {
				count++;
			}else {
			}
				
			}
		}
		if(count==0) {
			flag=false;			
		}
		
		return flag;
	}
	public boolean check(JButton[][] gameB) {
		int count=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {

				
			if(gameB[i][j].getText().equals(" ")) {
				count++;
			}else {
			}
				
			}
		}
		if(count==0) {
			flag=false;			
		}
		
		return flag;
	}
	public void fill(String[][] s) {
		int num1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(s[i][j].equals(" ")) {
					num1=r.nextInt(5)+1;
					 String snum = Integer.toString(num1);
					 s[i][j]=snum;
				}
			}
		}
	}	
	public void fill(JButton[][] gameB) {
		
		
		int num1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(gameB[i][j].getText().equals(" ")) {
					num1=r.nextInt(5)+1;
					 String snum = Integer.toString(num1);
					 gameB[i][j].setText(snum);
				}
			}
		}
	}
	
}
