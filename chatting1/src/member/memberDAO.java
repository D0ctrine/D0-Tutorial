package member;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class memberDAO {
	Scanner in = new Scanner(System.in);
	private static memberDAO daoInstance=new memberDAO();
	
	
	String send_id,receive_id,message;
	//send_id : 보내는 사람
	//receive_id : 받는 사람
	
	private memberDAO() {
		
	};
	
	public static memberDAO getInstance() {
		if(daoInstance == null){
			daoInstance = new memberDAO();
		}
		return daoInstance;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.59:1521:orcl","system","1111");

		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}
		return conn;
	}
	public void login(String id,int i) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		
		try {
			//쿼리 작성단계
		
		ppst1 = conne.prepareStatement("update humember set login=? where id=?");
		ppst1.setInt(1, i);
		ppst1.setString(2, id);
	
		
		//쿼리 수행단계
		ppst1.executeUpdate();
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
	
	
	public ArrayList<memberDTO> getFriends(String id,int i) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<memberDTO> membDTOList = null;
		try {
			
			ppst = conn.prepareStatement("select id from humember where not id=? and login=?");
			ppst.setString(1, id);
			ppst.setInt(2, i);
			rs= ppst.executeQuery();
			
			if(rs.next()) {
				membDTOList = new ArrayList<memberDTO>();
				
				do {
					memberDTO dto = new memberDTO();
					dto.setId(rs.getString("id"));
					membDTOList.add(dto);
					
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
		
		return membDTOList;
	}
	
	public ArrayList<memberDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<memberDTO> membDTOList = null;
		try {
			
			ppst = conn.prepareStatement("select * from humember");
	
			rs= ppst.executeQuery();
			
			if(rs.next()) {
				membDTOList = new ArrayList<memberDTO>();
				
				do {
					memberDTO dto = new memberDTO();
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					membDTOList.add(dto);
					
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
		
		return membDTOList;
	}
	
	public void join(memberDTO membDto) {
		//회원 가입
		
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		PreparedStatement ppst1 = null;
		
		
		try {
		ppst = conn.prepareStatement("insert into humember values(?,?)");
		//System.out.println("실행");
		ppst.setString(1, membDto.getId());
		ppst.setString(2, membDto.getPwd());
		//System.out.println("실행");
		ppst1 = conn.prepareStatement("commit");
		ppst.executeUpdate();
		ppst1.executeUpdate();

		
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(ppst1 != null) ppst1.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}//end insert()
	
	public void delete(memberDTO membDto) {
		//회원 탈퇴
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		PreparedStatement ppst2 = null;
		PreparedStatement ppst3 = null;
		
		try {
			//쿼리 작성단계
		ppst1 = conne.prepareStatement("delete from humember where id=?");
		ppst1.setString(1,membDto.getId());
		ppst2 = conne.prepareStatement("delete from humsg where send_id=? or receive_id=?");
		ppst2.setString(1,membDto.getId());
		ppst2.setString(2,membDto.getId());
		ppst3 = conne.prepareStatement("commit");
		
		//쿼리 수행단계
	
		ppst1.executeUpdate();
	
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst1 != null) ppst1.close();
				if(ppst2 != null) ppst2.close();
				if(ppst3 != null) ppst3.close();
				if(conne != null) conne.close();
			}catch(Exception e) {
				System.out.println("connection close error");
			}//end catch
		}//end finally
	}
	
}
