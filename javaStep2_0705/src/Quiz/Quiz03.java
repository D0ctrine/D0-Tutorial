package Quiz;

import java.util.Random;

public class Quiz03 {
	Random r = new Random();
	public void ans(int n) { //n�� ����
		
		int[][] box=new int[n][n];
		int[][] box1=new int[n][n];
		String[][] box2=new String[n][n];
		int[] ans=new int[n];
		int[] ans1=new int[n];
		int imsi=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				box[i][j]=r.nextInt(2); //���� 2���� �ϳ� �ֱ�
				box1[i][j]=r.nextInt(2); //���� 2���� �ϳ� �ֱ�
				if(box1[i][j]==1 || box[i][j]==1) {
					box2[i][j]="#";
				}else {
					box2[i][j]=" ";
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(box[i][j]+"\t");
			}	
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(box1[i][j]+"\t");
			}	
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(box2[i][j]+"\t");
			}	
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int a=n-j;
				while(a-1!=0) {
					imsi*=2;
					a--;
				}
					ans[i]+=box[i][j]*imsi;
					//System.out.println(ans[i]);
					ans1[i]+=box1[i][j]*imsi;
					//System.out.println(ans1[i]);
					imsi=1;
			}
		}
		
		System.out.println("�Ű�����"+"\t"+"��");
		
		System.out.println("n"+"\t"+n);
		
		System.out.print("arr1"+"\t"+"[");
		for(int i=0;i<n-1;i++) {
			System.out.print(ans[i]+",");
		}
		System.out.print(ans[n-1]);
		System.out.print("]");
		System.out.println();

		System.out.print("arr2"+"\t"+"[");
		for(int i=0;i<n-1;i++) {
			System.out.print(ans1[i]+",");
		}
		System.out.print(ans1[n-1]);
		System.out.print("]");
		System.out.println();
		
		System.out.print("���"+"\t"+"[");
		for(int i=0;i<n;i++) {
			System.out.print("\"");
			for(int j=0;j<n;j++) {
				System.out.print(box2[i][j]);
				
			}
			System.out.print("\"");
			if(i!=n-1) {
				
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
	
	
	
	
}
