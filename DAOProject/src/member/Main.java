package member;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDAO dao = MemberDAO.getInstance();
Scanner in = new Scanner(System.in);
		//멤버 DTO를 생성
		MemberDTO memberDTO = new MemberDTO();
		
		//멤버 DTO에 값을 SET
		//memberDTO.setName("임꺽정");
		//memberDTO.setMail("naver@gmail.com");
		//memberDTO.setAddr("천안시 불당동");
		//memberDTO.setId(3);
	
		int num;
		
			MemberDTO.menu();
	num = in.nextInt();
		switch(num) {
		case 1:dao.insert(memberDTO);break;
		case 2:dao.update(memberDTO);break;
		case 3:dao.delete(memberDTO);break;
		case 4:List<MemberDTO> dtoList = dao.getList();
		for (int i = 0; i < dtoList.size(); i++) {
			System.out.print(dtoList.get(i).getId()+"\t");
			System.out.print(dtoList.get(i).getName()+"\t");
			System.out.print(dtoList.get(i).getAddr()+"\t");
			System.out.print(dtoList.get(i).getMail()+"\n");
		}
		break;
			default : System.out.println("잘못된 값을 입력");
		}//end switch
	
		//dao.insert(memberDTO);
	}

	
}
