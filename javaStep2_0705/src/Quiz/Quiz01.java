package Quiz;


public class Quiz01 {
	public int gene(int a) {
		
		int sum=0;
		
		if(a<10) {
			sum=a+a;
		}else if(a<100) {
			sum=a/10+a%10+a;
		}else if(a<1000) {
			sum=a/100+a%100/10+a%10+a;
		}else if(a<10000) {
			sum=a/1000+a%1000/100+a%100/10+a%10+a;
		}
		
		return sum; 
	}
	
}
