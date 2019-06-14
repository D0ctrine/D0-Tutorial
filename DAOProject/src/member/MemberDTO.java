package member;

import java.util.Scanner;

/*
 * 분류번호	id
 * 이름		name
 * 메일주소	mail
 * 주소지		addr
 * 가입일		regDate
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
		System.out.println("1.삽입");
		System.out.println("2.수정");
		System.out.println("3.삭제");
		System.out.println("4.리스트");
		System.out.println("============");
		
		
	}
}
