package Quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz02 {

	
	public void dart() {
		Scanner in =new Scanner(System.in);
		System.out.println("����"+"\t"+"dartResult"+"\t"+"answer"+"\t"+"����");
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
				
				//SDT ���Ë����� ���� ������ ������
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
				
				//System.out.println("sdt�� ������ : "+sumimsi);
		
				if(optionimsi<2) {
					//�ɼ��� ������ *�̸� 2��
					if(option.charAt(optionimsi)=='*') {
						if(throwdarttemp==0) { //ó���̸� ó���� 2��
							sumimsi*=2;
							Explain+="*2";
						}else {	//ó���ƴϸ� �� ������ ���� ���� 2��
							sumimsi*=2;
							Explain+="*2";
							if(sumimsi1>0) {
								sumimsi+=sumimsi1;//�� ���� ����ϰ�� �ѹ��� �������μ� 2��
								if(Explainimsi!="")
								Explainimsi+="*2('*')";
							}else {
								sumimsi-=sumimsi1;	//�� ���� �����ϰ�� �ѹ��� �����μ� -2��
								//Explainimsi="-"+Explainimsi;
							}
						}
					}else if(option.charAt(optionimsi)=='#') {
						sumimsi*=-1; //#�̸� -�� ��������
						Explain=Explain+"*(-1)";
					}
					//System.out.println("�ɼ������� : "+sumimsi);	
					sum+=sumimsi;
					//��Ŭ���� ���� : charAt�տ� ��Ʈ������ ""�� ���н������ �Ѵ� �ƴϸ� ���ھƽ�Ű���ڷ� ����
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
			//dartResult ���� ���߱�
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
