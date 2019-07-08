package Quiz;

import java.util.ArrayList;
import java.util.Random;

public class Quiz04 {
	ArrayList<Quiz04_DTO> ResultList = new ArrayList<Quiz04_DTO>();
	Random r=new Random();
	String bonus="SDT";
	String option="*#";
	int scoresum=0;
	int bonusimsi;
	int[] bon_imsi=new int[3];
	
	Quiz04(){
		Scorecount();
		ScoreSum();
	}
	
	public void Scorecount() { //점수 입력
		System.out.print("[");
		for(int j=0;j<3;j++) {
			Quiz04_DTO dto=new Quiz04_DTO();
			dto.setPoint(r.nextInt(11)); //점수
			System.out.print(dto.getPoint());
			dto.setBonus(bonus.charAt(bonusimsi = r.nextInt(3)));//보너스
			bon_imsi[j]=bonusimsi+1;
			System.out.print(dto.getBonus());
			ResultList.add(dto);
		
			int imsi=r.nextInt(5);
			if(imsi<2) {
				ResultList.get(j).setOption(""+option.charAt(imsi));
				if(option.charAt(imsi)=='*' & j>1) {
					ResultList.get(j-1).setOption(""+option.charAt(imsi));
				}
			}
			System.out.print(ResultList.get(j).getOption()+" ");
		}
		System.out.print("]");
	}
			
	public void ScoreSum() { //점수 합산
		System.out.println();
		for(int i=0;i<3;i++) {
			int score =(int) Math.pow(ResultList.get(i).getPoint(), bon_imsi[i]);
			if(ResultList.get(i).getOption().startsWith("*")) {
				for(int j=0;j<ResultList.get(i).getOption().length();j++) {
					score *=2;
				}
				
			}else if(ResultList.get(i).getOption().equals("#")) {
				score*=-1;
			}
			scoresum+=score;
		}
		System.out.println(scoresum);
		
	}
	
	
	
}
