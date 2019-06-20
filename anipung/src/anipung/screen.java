package anipung;


import java.util.Random;

public class screen {

	int num1;
	String[][] sc=new String[5][5];
	
	screen(){
		rand();
		rule rl=new rule();
		
	}
	
	
	void rand() {
		
		Random r=new Random();
		 
		 for(int i=0;i<5;i++) {
			 for(int j=0;j<5;j++) {
				 
				 num1=r.nextInt(5)+1;
				 String snum = Integer.toString(num1);
				 sc[i][j]=snum;
				 System.out.print(sc[i][j]+"\t");
				 
			 }
			 System.out.println();
		 }
	
}
}
