package QuizCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
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
		public void insert(String a) {
			Connection conn = getConnection();
			PreparedStatement ppst = null;
			ResultSet rs = null;
			
			try {
				ppst = conn.prepareStatement("insert into url values (?)");
				ppst.setString(1, a);
				ppst.executeUpdate();

				System.out.println(a+"성공");
					}//end try
					catch(Exception e) {
						System.out.println(a+"실패");
					}finally {
						try {
							if(ppst != null) ppst.close();
							if(conn != null) conn.close();
							if(rs != null) conn.close();
						}catch(Exception e) {
							System.out.println("connection close error");
						}//end catch
					}//end finally
		}
}
