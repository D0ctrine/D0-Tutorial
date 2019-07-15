package Samsung;

import java.util.ArrayList;
import java.util.Random;

public class map {

	int[][] pos_xy = new int[3][2];
	ArrayList<String> pos_way = new ArrayList<String>();
	
	
	void mapping(int a,int b){
		String[][] map = new String[a][b];
		Random r = new Random();
		int x=0,y=0;
		for(int i=0;i<a ;i++) {
			for(int j=0;j<b ;j++) {
				if((i%(a-1))==0 || j%(b-1)==0) { 
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
		pos_xy[0][0] = x;
		pos_xy[0][1] = y;
		do {
			x=r.nextInt(a-2)+1;
			y=r.nextInt(b-2)+1;
		}while(map[x][y].equals("R"));
		
			map[x][y]="B";
			pos_xy[1][0] = x;
			pos_xy[1][1] = y;
			do {
				x=r.nextInt(a-2)+1;
				y=r.nextInt(b-2)+1;
			}while(map[x][y].equals("R") | map[x][y].equals("B"));
			
			map[x][y]="O";
			pos_xy[2][0] = x;
			pos_xy[2][1] = y;
			
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
			
		}
		
	}
	
	public static int[][] BFS_Left(int[][] pos, String[][] land) {
		int x=pos[0][0];
		int y=pos[0][1];
		while (land[x][y].equals(".")) {
			y--;
		}
		y++;
		return pos;
	}
	public static int[][] BFS_Right(int[][] pos, String[][] land) {
		int x=pos[0][0];
		int y=pos[0][1];
		while (land[x][y].equals(".")) {
			y++;
		}
		y--;
		return pos;
	}
	
	public static boolean DFS(int x, int y, int sizeX, int sizeY, String[][] land) {
		int cnt = 0;
		while (BFS(x,y,sizeX, land)==sizeX) {
			cnt++;
			if(cnt == sizeY) {
				return true;
			}
			x++;
		}
		return false;
	}
	
	
}
