package Samsung;

import java.awt.List;
import java.util.Random;

public class map {

	
	
	void mapping(int a,int b){
		String[][] map = new String[a][b];
		Random r = new Random();
		int x=0,y=0;
		for(int i=0;i<a ;i++) {
			for(int j=0;j<b ;j++) {
				if((i%(a-1))==0 || j%(b-1)==0) { //행 맨 위와 맨 밑 / 열 맨 앞과 맨 뒤
					map[i][j]="#";
				}else if(r.nextInt(3)==1) {
					map[i][j]="#";
				}else {
					map[i][j]=".";
				}
			}
		}
		x=r.nextInt(a-2)+1;
		y=r.nextInt(b-2)+1;
		map[x][y]="R";
		do {
			x=r.nextInt(a-2)+1;
			y=r.nextInt(b-2)+1;
		}while(!map[x][y].equals("#"));
			map[x][y]="B";
		
			do {
				x=r.nextInt(a-2)+1;
				y=r.nextInt(b-2)+1;
			}while(!map[x][y].equals("#"));
				map[x][y]="O";
		
		
		//출력부
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
}
