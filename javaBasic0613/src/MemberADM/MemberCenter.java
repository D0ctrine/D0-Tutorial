package MemberADM;

import java.util.ArrayList;
import java.util.Scanner;

import Object.Member;

public class MemberCenter {
	private Scanner in = new Scanner(System.in);
	private static MemberCenter memberCenter = null;
	private ArrayList<Member> mList=new ArrayList<>();
	
	private MemberCenter(){
		// �������� ����ٰ� ����ġ ���̽��� �޴��� �б��ϵ��� 
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
// 1��	public boolean logMember(String id) {
	public Member logMember(String id) {	
	   //�Ű������� ���޵� id�� mList�� �ִ��� Ȯ���ؼ� ������ true ������ false
		Member m = null;// ?? �ش�Ǵ� ��ü�� �ּҸ� m���� ����
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
		System.out.println("ID �Է�:");
		String id = in.nextLine();
		String name = in.nextLine();
		Member newM = new Member();
		newM.setId(id);
		newM.setName(name);
		mList.add(newM);
	}

	private void menu() {
		System.out.println(" �޴��� �����ϼ��� ");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ������");
		System.out.println("3. ȸ������");
		System.out.println("4. ȸ������");
		System.out.println("5. �����޴�");
	}
}
