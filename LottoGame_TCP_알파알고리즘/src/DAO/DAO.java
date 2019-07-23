package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	static DAO md = null;

	private DAO() {// �쇅遺��뿉�꽌 �젒洹쇳븯吏� 紐삵븯寃�

	}

	public static DAO getInstance() { // �떛湲��넠
		if (md == null) {
			md = new DAO();
		}
		return md;
	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1111");

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}

		return conn;
	}

	public void insert(String id, ArrayList<String> LottoNum) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		System.out.println("insert-Start");
		try {
			// 荑쇰━ �옉�꽦�떒怨�
			ppst = conn.prepareStatement("insert into Lotto values(?,?,?,?,?,?,?,?)");
			ppst.setString(1, id);
			for (int i = 0; i < LottoNum.size(); i++) {
				System.out.println("insert");
				ppst.setString(i + 2, LottoNum.get(i));
			}
			System.out.println("insert-End");
			// 荑쇰━ �닔�뻾�떒怨�
			ppst.executeUpdate();

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
	}

	public String[] getList(String id) {
		// �뜲�씠�꽣 踰좎씠�뒪�뿉 �젒�냽�쓣 �빐�꽌 �빐�떦�맂�뒓 �젙蹂대�� 媛��졇�삩�떎.
		// �뿰寃곗꽕�젙 ->荑쇰━�쟾�넚 諛� 由ы꽩 ->�뿰寃곗쥌猷� 怨쇱젙�뿉 �뵲�씪 肄붾뵫�븳�떎.
		// �뱶�씪�씠踰꾨줈�뱶 + connection 留뚮뱶�뒗 �떒怨�
		Connection conn = getConnection(); // �뿰寃곗꽕�젙
		PreparedStatement ppst = null; // 荑쇰━�쟾�넚
		ResultSet rs = null;// �쟾�넚�맂 荑쇰━瑜� 由ы꽩 諛쏄린 �쐞�빐...
		String[] LottoList = new String[46];
		// 由ы꽩.

		try {
			// 荑쇰━ �옉�꽦�떒怨�
			ppst = conn.prepareStatement("select*from lotto where id= ?");
			ppst.setString(1, id);
			// 荑쇰━ �닔�뻾�떒怨�
			rs = ppst.executeQuery();
			System.out.println("Query");

			// 荑쇰━�쓽 寃곌낵媛� �엳�뒗媛�?
			if (rs.next()) {
				do {
					String num = rs.getString("NUM");
					String a = (rs.getString("NUMA"));
					String b = (rs.getString("NUMB"));
					String c = (rs.getString("NUMC"));
					String d = (rs.getString("NUMD"));
					String e = (rs.getString("NUME"));
					String f = (rs.getString("NUMF"));
					for (int i = 1; i < 46; i++) {
						
						if ((i + "").equals(num)) {
							LottoList[i] += "*";
						}
					}
					for (int i = 1; i < 46; i++) {
						
						if ((i + "").equals(a)) {
							LottoList[i] += "*";
						}
					}
					for (int i = 1; i < 46; i++) {
					
						if ((i + "").equals(b)) {
							LottoList[i] += "*";						
							}
					}
					for (int i = 1; i < 46; i++) {
					
						if ((i + "").equals(c)) {
							LottoList[i] += "*";
						}
					}
					for (int i = 1; i < 46; i++) {
				
						if ((i + "").equals(d)) {
							LottoList[i] += "*";
						}
					}
					for (int i = 1; i < 46; i++) {
						
						if ((i + "").equals(e)) {
							LottoList[i] += "*";
						}
					}
					for (int i = 1; i < 46; i++) {
					
						if ((i + "").equals(f)) {
							LottoList[i] += "*";
						}
					}

				} while (rs.next());
			}

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
		return LottoList;
	}

}
