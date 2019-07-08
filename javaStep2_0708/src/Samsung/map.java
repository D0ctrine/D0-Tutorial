package Samsung;

import java.util.Random;

public class map {

	
	
	void mapping(int a,int b){
		String[][] map = new String[a][b];
		Random r = new Random();
		for(int i=0;i<a;i++) {
			
			for(int j=0;j<b;j++) {
				if((i%(a-1))==0 || j%(b-1)==0) { //행 맨 위와 맨 밑/열 맨 앞과 맨 뒤
					map[i][j]="#";
				}else if(r.nextInt(2)==1) {
					map[i][j]=".";		//최소 3개이상 
					
				}else {
					map[i][j]="#";
				}
				
				
				
				
			}
		}
		
		//출력부
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
}
