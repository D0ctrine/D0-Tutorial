package member;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
	private static MemberDAO daoInstance;
	//private static MemberDAO daoInstance= new MemberDAO();
	Scanner in = new Scanner(System.in);
	String s_name,s_mail,s_addr,s_table;
	int s_id;
	private MemberDAO() {
		
	};
	public static MemberDAO getInstance() {
		if(daoInstance == null){
			daoInstance = new MemberDAO();
		}
		return daoInstance;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");

		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}
		return conn;
	}
	public List<MemberDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<MemberDTO> memberDTOList = null;
		try {
			ppst = conn.prepareStatement("select * from member");
			
			rs= ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<MemberDTO>();
				
				do {
					MemberDTO dto = new MemberDTO();
					dto.setId(rs.getInt("ID"));
					dto.setName(rs.getString("NAME"));
					dto.setMail(rs.getString("MAIL"));
					dto.setAddr(rs.getString("ADDR"));
					memberDTOList.add(dto);
					
				}while(rs.next());
					
				}//end if
				}//end try
				catch(Exception e) {
					System.out.println("SQL Error");
				}finally {
					try {
						if(ppst != null) ppst.close();
						if(conn != null) conn.close();
						if(rs != null) conn.close();
					}catch(Exception e) {
						System.out.println("connection close error");
					}//end catch
				}//end finally
		
		

		
		return memberDTOList;
	}
	public void insert(MemberDTO membDto) {
		/*
		 * 1.c
		 * 2.Connection ����
		 * 3.���� ����
		 * 4.���
		 */
		//����̹��ε� + connection ����� �ܰ�
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		

		System.out.println("�̸��� �Է����ּ���.");
		s_name = in.nextLine();
		membDto.setName(s_name);
		System.out.println("������ �Է����ּ���.");
		s_mail = in.nextLine();
		membDto.setMail(s_mail);
		System.out.println("�ּҸ� �Է����ּ���.");
		s_addr = in.nextLine();
		membDto.setAddr(s_addr);
		
		
		
		try {
			//���� �ۼ��ܰ�
		ppst = conn.prepareStatement("insert into member values(id_seq.nextVal,?,?,?)");
		ppst.setString(1, membDto.getName());
		ppst.setString(2, membDto.getMail());
		ppst.setString(3, membDto.getAddr());
		
		//���� ����ܰ�
		ppst.executeUpdate();
		System.out.println("�Է�ó���� �Ϸ�Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}//end insert()
	
	public void update(MemberDTO memberDTO) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		
	
		
		System.out.println("�̸��� �Է����ּ���.");
		s_name = in.nextLine();
		memberDTO.setName(s_name);
		System.out.println("������ �Է����ּ���.");
		s_mail = in.nextLine();
		memberDTO.setMail(s_mail);
		System.out.println("�ּҸ� �Է����ּ���.");
		s_addr = in.nextLine();
		memberDTO.setAddr(s_addr);
		System.out.println("id�� �Է����ּ���.");
		s_addr = in.nextLine();
		memberDTO.setId(s_id);
		
		try {
			//���� �ۼ��ܰ�
		
		ppst1 = conne.prepareStatement("update member set name=?,mail=?,addr=? where id=?");
		ppst1.setString(1, memberDTO.getName());
		ppst1.setString(2, memberDTO.getMail());
		ppst1.setString(3, memberDTO.getAddr());
		ppst1.setInt(4,memberDTO.getId());
		
		//���� ����ܰ�
		ppst1.executeUpdate();
		System.out.println("����ó���� �Ϸ�Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst1 != null) ppst1.close();
				if(conne != null) conne.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}
	public void delete(MemberDTO memberDTO) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		System.out.println("id�� �Է����ּ���.");
		s_id = in.nextInt();
		memberDTO.setId(s_id);
		
		try {
			//���� �ۼ��ܰ�
		
		ppst1 = conne.prepareStatement("delete from member");
		//ppst1.setInt(1,memberDTO.getId());
		
		//���� ����ܰ�
	
		int a = ppst1.executeUpdate();
		System.out.println(a);
		if(a >0) {
			
			System.out.println("����ó���� �Ϸ�Ǿ����ϴ�. /"+a);
		}else {
			System.out.println("aaa");
		}
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst1 != null) ppst1.close();
				if(conne != null) conne.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}
	
}
