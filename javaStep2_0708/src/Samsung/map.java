package Samsung;

import java.util.Random;

public class map {

	
	
	void mapping(int a,int b){
		String[][] map = new String[a][b];
		Random r = new Random();
		for(int i=0;i<a;i++) {
			
			for(int j=0;j<b;j++) {
				if((i%(a-1))==0 || j%(b-1)==0) { //�� �� ���� �� ��/�� �� �հ� �� ��
					map[i][j]="#";
				}else if(r.nextInt(2)==1) {
					map[i][j]=".";		//�ּ� 3���̻� 
					
				}else {
					map[i][j]="#";
				}
				
				
				
				
			}
		}
		
		//��º�
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
}
