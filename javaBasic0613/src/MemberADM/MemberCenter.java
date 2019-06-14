package MemberADM;

import java.util.ArrayList;
import java.util.Scanner;

import Object.Member;

public class MemberCenter {
	private Scanner in = new Scanner(System.in);
	private static MemberCenter memberCenter = null;
	private ArrayList<Member> mList=new ArrayList<>();
	
	private MemberCenter(){
		// 예전에는 여기다가 스위치 케이스로 메뉴를 분기하도록 
	}
	
	public static MemberCenter getInstance() {
		if(memberCenter == null) {
			memberCenter = new MemberCenter();
		}
		return memberCenter;
	}
	public void memberprocess() {
		boolean pFlag=true;
		while(pFlag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: join(); break;
		//	case 2: mod(); break;
		//	case 3: del(); break;
			
			case 4: list(); break;
			default: pFlag=false;
			}
		}
	}
// 1차	public boolean logMember(String id) {
	public Member logMember(String id) {	
	   //매개변수로 전달된 id가 mList에 있는지 확인해서 잇으면 true 없으면 false
		Member m = null;// ?? 해당되는 객체의 주소를 m에게 저장
		for(int i=0; i < mList.size(); i++) {
			if(mList.get(i).getId().equals(id)) {
				m=mList.get(i);
			}
		}
		return m;
	}
	private void list() {
		// TODO Auto-generated method stub
		for(int i=0; i<mList.size(); i++) {
			System.out.println(mList.get(i).getId()+
					"/"+mList.get(i).getName()
					);
			
		}
	}

	private void join() {
		// TODO Auto-generated method stub
		System.out.println("ID 입력:");
		String id = in.nextLine();
		String name = in.nextLine();
		Member newM = new Member();
		newM.setId(id);
		newM.setName(name);
		mList.add(newM);
	}

	private void menu() {
		System.out.println(" 메뉴를 선택하세요 ");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원수정");
		System.out.println("3. 회원삭제");
		System.out.println("4. 회원보기");
		System.out.println("5. 이전메뉴");
	}
}
