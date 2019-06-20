package anipung;



public class rule {
	String[][] sc=new String[5][5];
	
rule(){


	
	
	
}

void sero(String[][] s) {
	for(int i=0;i<3;i++) {
		for(int j=0;j<5;j++) {
			//sc[i][j]=" ";
			if(s[i][j]==s[i+1][j]) {
				if(s[i+1][j]==s[i+2][j]) {
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
void garo(String[][] s) {
	for(int i=0;i<5;i++) {
		for(int j=0;j<3;j++) {
			//sc[i][j]=" ";
			if(s[i][j]==s[i][j+1]) {
				if(s[i][j+1]==s[i][j+2]) {
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

}
