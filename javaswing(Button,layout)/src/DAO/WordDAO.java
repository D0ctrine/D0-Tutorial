package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.WordDTO;

public class WordDAO {
	private static WordDAO md = null;

	private WordDAO() {

	}

	public static WordDAO getInstance() {
		if (md == null) {
			md = new WordDAO();
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
/*
	public WordDTO selectID(String sid) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		WordDTO dto=null;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from Member where id=?");
			ppst.setString(1, sid);
			// 쿼리 수행단계
			rs = ppst.executeQuery();

			// 쿼리의 결과가 있는가?
			if (rs.next()) {
				dto = new WordDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));

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
		
		return dto;
	}
*/
	public void insert(WordDTO inOne) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("insert into word values(?, ?)");
			ppst.setString(1, inOne.getEng());
			ppst.setString(2, inOne.getKor());
			// 쿼리 수행단계
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

	public ArrayList<WordDTO> getList() {

		// 드라이버로드 + connection 만드는 단계
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<WordDTO> WordDTOList = null;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from word");
			// 쿼리 수행단계
			rs = ppst.executeQuery();

			// 쿼리의 결과가 있는가?
			if (rs.next()) {
				WordDTOList = new ArrayList<WordDTO>();

				do {
					WordDTO dto = new WordDTO();

					dto.setKor(rs.getString("kor"));
					dto.setEng(rs.getString("eng"));

					WordDTOList.add(dto);
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
		return WordDTOList;
	}

	public void updata(WordDTO inOne) {

		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {

			ppst = conn.prepareStatement("update word set kor=? where eng=?");

			ppst.setString(1, inOne.getKor());
			ppst.setString(2, inOne.getEng());
			// 쿼리 수행단계
			ppst.executeUpdate();
		} catch (Exception e) {

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

	public void del(String delID) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		try {
			ppst = conn.prepareStatement("delete from word where eng=?");
			ppst.setString(1, delID);
			int k = ppst.executeUpdate();
		} catch (Exception e) {

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
}
