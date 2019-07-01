package chatting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class chatDAO {
Scanner in = new Scanner(System.in);
		private static chatDAO daoInstance=new chatDAO();
		
		
		String send_id,receive_id,message;
		
		
		private chatDAO() {
			
		};
		
		public static chatDAO getInstance() {
			if(daoInstance == null){
				daoInstance = new chatDAO();
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
		
		public ArrayList<chatDTO> chatting(String sender,String receiver) {
			Connection conn = getConnection();
			PreparedStatement ppst = null;
			ResultSet rs = null;
			ArrayList<chatDTO> chattingDTOList = null;
			try {
				
				ppst = conn.prepareStatement("select distinct send_id,message,senddate from humsg where receive_id=? and send_id=? or send_id=? and receive_id=?  order by senddate asc");
				ppst.setString(1, sender);
				ppst.setString(2, receiver);
				ppst.setString(3, sender);
				ppst.setString(4, receiver);
				rs= ppst.executeQuery();
				if(rs.next()) {
					chattingDTOList = new ArrayList<chatDTO>();
					
					do {
						
							chatDTO dto = new chatDTO();
							dto.setSend_id(rs.getString("send_id"));
							dto.setMessage(rs.getString("message"));
							dto.setSenddate(rs.getString("senddate"));
							
							chattingDTOList.add(dto);
						
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
			
			return chattingDTOList;
		}
		public void sendmail(String id,String userID,String msg) {
			
			Connection conn = getConnection();
			PreparedStatement ppst = null;
			PreparedStatement ppst1 = null;
			
			try {
				//쿼리 작성단계
			ppst = conn.prepareStatement("insert into humsg values(?,?,?,default)");
			ppst1 = conn.prepareStatement("commit");
			ppst.setString(1, id);
			ppst.setString(2, userID);
			ppst.setString(3, msg);
			
			//쿼리 수행단계
			ppst.executeUpdate();
			ppst1.executeUpdate();
			}catch(Exception e) {
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
		
		public void delete(chatDTO chatDto) {
			Connection conne = getConnection();
			PreparedStatement ppst1 = null;
			
			try {
				//쿼리 작성단계
			ppst1 = conne.prepareStatement("delete from humsg where receive");
			ppst1.setString(1,chatDto.getReceive_id());
			
			//쿼리 수행단계
		
			int a = ppst1.executeUpdate();
			
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
