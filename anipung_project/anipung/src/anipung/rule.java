package anipung;

import javax.swing.JButton;

public class rule {
	String[][] sc=new String[5][5];
	falling fall=null;
	
	public rule(String[][] s){
		
		sero(s);
		garo(s);
		
		fall=new falling(s);
		
		
	
	}
public rule(JButton[][] gameB){
		
		sero(gameB);
		garo(gameB);
		
		//fall=new falling(gameB);
		
		
	
	}
public void sero(String[][] s) {
	
	for(int i=0;i<3;i++) {
		for(int j=0;j<5;j++) {
			//sc[i][j]=" ";
			
			if(s[i][j].equals(s[i+1][j])) {
				if(s[i+1][j].equals(s[i+2][j])) {
					sc[i][j]="0";
					sc[i+1][j]="0";
					sc[i+2][j]="0";
				}
			}
		}
	}
	
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			if(sc[i][j]=="0")
				s[i][j] = sc[i][j];
			
		}
	}
	
}
public void sero(JButton[][] gameB) {

for(int i=0;i<3;i++) {
	for(int j=0;j<5;j++) {
		
		
		if(gameB[i][j].getText().equals(gameB[i+1][j].getText())) {
			if(gameB[i+1][j].getText().equals(gameB[i+2][j].getText())) {
				sc[i][j]="0";
				sc[i+1][j]="0";
				sc[i+2][j]="0";
				
			}
		}
	}
}

for(int i=0;i<5;i++) {
	for(int j=0;j<5;j++) {
		if(sc[i][j]=="0")
			gameB[i][j].setText(sc[i][j]);
		
	}
}
}

public void garo(String[][] s) {
	for(int i=0;i<5;i++) {
		for(int j=0;j<3;j++) {
			//sc[i][j]=" ";
			if(s[i][j].equals(s[i][j+1])) {
				if(s[i][j+1].equals(s[i][j+2])) {
					sc[i][j]="0";
					sc[i][j+1]="0";
					sc[i][j+2]="0";
				}
			}
			
		}
	}
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			if(sc[i][j]=="0")
				s[i][j] = sc[i][j];
		}

	}
	
}

public void garo(JButton[][] gameB) {
	String[][] s=new String[5][5];
	for(int i=0;i<5;i++) {
		for(int j=0;j<3;j++) {
			//sc[i][j]=" ";
			if(gameB[i][j].getText().equals(gameB[i][j+1].getText())) {
				if(gameB[i][j+1].getText().equals(gameB[i][j+2].getText())) {
					sc[i][j]="0";
					sc[i][j+1]="0";
					sc[i][j+2]="0";
				
				}
			}
			
		}
	}
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			if(sc[i][j]=="0")
				gameB[i][j].setText( sc[i][j]);
		}

	}
}
}
