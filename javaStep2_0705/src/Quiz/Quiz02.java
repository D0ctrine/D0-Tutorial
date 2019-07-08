package Quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz02 {

	
	public void dart() {
		Scanner in =new Scanner(System.in);
		System.out.println("예제"+"\t"+"dartResult"+"\t"+"answer"+"\t"+"설명");
		Random r=new Random();
		String bonus="SDT";
		String dartResult="";
		String option="*#";
		int throwdarttemp=0,sumimsi1=0;
		String sumExplain="",Explain="",Explainimsi="";
		for(int i=0;i<7;i++) {
			int sum=0;
			for(int j=0;j<3;j++) {
				int throwdart=r.nextInt(11);
				int sumimsi=0;
				int optionimsi=r.nextInt(5);
				int bonusimsi=r.nextInt(3);
				
				//SDT 나올떄마다 제곱 세제곱 네제곱
				if(bonus.charAt(bonusimsi)=='S') {
					sumimsi+=(throwdart);
					Explain=throwdart+"^1";
				}else if(bonus.charAt(bonusimsi)=='D') {
					sumimsi+=(throwdart*throwdart);
					Explain=throwdart+"^2";
				}else if(bonus.charAt(bonusimsi)=='T') {
					sumimsi+=(throwdart*throwdart*throwdart);
					Explain=throwdart+"^3";
				}
				
				//System.out.println("sdt로 했을때 : "+sumimsi);
		
				if(optionimsi<2) {
					//옵션이 있을때 *이면 2배
					if(option.charAt(optionimsi)=='*') {
						if(throwdarttemp==0) { //처음이면 처음만 2배
							sumimsi*=2;
							Explain+="*2";
						}else {	//처음아니면 전 점수랑 지금 점수 2배
							sumimsi*=2;
							Explain+="*2";
							if(sumimsi1>0) {
								sumimsi+=sumimsi1;//전 점수 양수일경우 한번더 더함으로서 2배
								if(Explainimsi!="")
								Explainimsi+="*2('*')";
							}else {
								sumimsi-=sumimsi1;	//전 점수 음수일경우 한번더 뺌으로서 -2배
								//Explainimsi="-"+Explainimsi;
							}
						}
					}else if(option.charAt(optionimsi)=='#') {
						sumimsi*=-1; //#이면 -를 곱한점수
						Explain=Explain+"*(-1)";
					}
					//System.out.println("옵션있을때 : "+sumimsi);	
					sum+=sumimsi;
					//이클립스 버그 : charAt앞에 인트있을시 ""로 구분시켜줘야 한다 아니면 문자아스키숫자로 나옴
					dartResult += throwdart +""+ bonus.charAt(bonusimsi) +""+ option.charAt(optionimsi);
				}else {
					sum+=sumimsi;
					dartResult += throwdart +""+ bonus.charAt(bonusimsi);
				}
				throwdarttemp=throwdart;
				sumimsi1=sumimsi;
				if(Explainimsi!="") {
					
					sumExplain+=Explainimsi+"+";
				}
					Explainimsi=Explain;
					
			}
			sumExplain+=Explainimsi;
			//dartResult 공백 맞추기
			while(dartResult.length()!=12) {
				dartResult+=" ";
			}
			
			System.out.println((i+1)+"\t"+dartResult+"\t"+sum+"\t"+sumExplain);
			sumExplain="";
			dartResult="";
			Explainimsi="";
		
		}
		
		
	}
	
}
