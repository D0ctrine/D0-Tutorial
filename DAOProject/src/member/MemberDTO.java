package member;

import java.util.Scanner;

/*
 * �з���ȣ	id
 * �̸�		name
 * �����ּ�	mail
 * �ּ���		addr
 * ������		regDate
 */

public class MemberDTO {
	
	private int id;
	private String name;
	private String mail;
	private String addr;

	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public static void menu() {
		System.out.println("============");
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.����");
		System.out.println("4.����Ʈ");
		System.out.println("============");
		
		
	}
}
