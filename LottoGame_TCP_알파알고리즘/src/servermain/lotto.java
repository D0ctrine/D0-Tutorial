package servermain;

import java.util.ArrayList;
import java.util.Random;

public class lotto {

	Random r = new Random();
	ArrayList<String> lotto = null;


	public String[] lottocheck(ArrayList<String> ClientLotto,ArrayList<String> Lotto_Official) {
		// TODO Auto-generated method stub
		String[] box = new String[7];
		
		for (int i = 0; i < ClientLotto.size(); i++) {
			for (int j = 0; j < Lotto_Official.size(); j++) {
				if (Lotto_Official.get(j).equals(ClientLotto.get(i))) {
					box[i] = "(O)";
					break;
				} else {
					box[i] = "(X)";
				}

			}
		}
		
		
		return box;
	}

//로또 번호 생성파트
	public ArrayList<String> lottoNum() {
		int count = 0;
		lotto = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			int lottoNum = r.nextInt(45) + 1;
			for (int j = 0; j < lotto.size(); j++) {
				if ((lottoNum + "").equals(lotto.get(j))) { // 똑같을때
					count = 1;
					while (count == 1) {
						lottoNum = r.nextInt(45) + 1;
						if (!(lottoNum + "").equals(lotto.get(j))) {// 다를 때
							count = 0;
						}

					}
				}
			}
			lotto.add(lottoNum + "");
		}
		return lotto;
	}
	
}
