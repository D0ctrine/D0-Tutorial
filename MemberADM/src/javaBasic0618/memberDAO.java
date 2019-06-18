package javaBasic0618;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.Scanner;


public class memberDAO {
	private static memberDAO daoInstance;
	Scanner in = new Scanner(System.in);

	private memberDAO() {
		
	}
	
	
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
		
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");

		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}
		return conn;
	}
	
	public void insert(memberDTO membDto) {
		/*
		 * 1.c
		 * 2.Connection 맺음
		 * 3.쿼리 수행
		 * 4.결과
		 */
		//드라이버로드 + connection 만드는 단계
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		

		System.out.println("이름을 입력해주세요.");
		membDto.setName(in.nextLine());
		System.out.println("나이를 입력해주세요.");
		membDto.setAge(in.nextInt());
		in.nextLine();
		System.out.println("성별을 입력해주세요.(남|여)");
		membDto.setGender(in.nextLine());
		System.out.println("직업을 입력해주세요.");
		membDto.setJob(in.nextLine());
		
		
		try {
			//쿼리 작성단계
		ppst = conn.prepareStatement("insert into member1 values(id.nextVal,?,?,?,?)");
		ppst.setString(1, membDto.getName());
		ppst.setInt(2, membDto.getAge());
		ppst.setString(3, membDto.getGender());
		ppst.setString(4, membDto.getJob());
		
		//쿼리 수행단계
		ppst.executeUpdate();
		System.out.println("입력처리가 완료되었습니다.");
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
	
	public void update(memberDTO memberDTO) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		getList();
	int id;
		System.out.println("수정할 id를 입력해주세요.");
		id=in.nextInt();
		in.nextLine();
		System.out.println("이름을 입력해주세요.");
		memberDTO.setName(in.nextLine());
		System.out.println("나이를 입력해주세요.");
		memberDTO.setAge(in.nextInt());
		in.nextLine();
		System.out.println("성별을 입력해주세요.(남|여)");
		memberDTO.setGender(in.nextLine());
		System.out.println("직업을 입력해주세요.");
		memberDTO.setJob(in.nextLine());
		
		
		try {
			//쿼리 작성단계
		
		
		ppst1 = conne.prepareStatement("update member1 set name=?,age=?,gender=?,job=? where id=?");
		ppst1.setString(1, memberDTO.getName());
		ppst1.setInt(2, memberDTO.getAge());
		ppst1.setString(3, memberDTO.getGender());
		ppst1.setString(4, memberDTO.getJob());
		ppst1.setInt(5, id);
		//쿼리 수행단계
		ppst1.executeUpdate();
		System.out.println("갱신처리가 완료되었습니다.");
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
	public void delete(memberDTO memberDTO) {
		Connection conne = getConnection();
		PreparedStatement ppst1 = null;
		getList();
		
		System.out.println("id를 입력해주세요.");
		int id = in.nextInt();

		
		try {
			//쿼리 작성단계
		
		ppst1 = conne.prepareStatement("delete from member1 where=?");
		ppst1.setInt(1,id);
		
		//쿼리 수행단계
	
		int a = ppst1.executeUpdate();
		System.out.println(a);
		if(a >0) {
			
			System.out.println(a+"건 삭제처리가 완료되었습니다. /");
		}else {
			System.out.println("삭제할 데이터가 비어있습니다.");
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
	public ArrayList<memberDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<memberDTO> memberDTOList = null;
		try {
			ppst = conn.prepareStatement("select * from member1");
			
			rs= ppst.executeQuery();
			int i=0;
			if(rs.next()) {
				memberDTOList = new ArrayList<memberDTO>();
				
				do {
					memberDTO dto = new memberDTO();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					dto.setGender(rs.getString("gender"));
					dto.setJob(rs.getString("job"));
					memberDTOList.add(dto);
					System.out.print(memberDTOList.get(i).getId()+"번 고객"+memberDTOList.get(i).getName()+"\t"+memberDTOList.get(i).getAge()
							+"\t"+memberDTOList.get(i).getGender()+"\t"+memberDTOList.get(i).getJob()+"\n");
					
					i++;
					
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
	public ArrayList<memberDTO> getSearch() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<memberDTO> memberDTOList = null;
		System.out.println("검색할 고객명을 입력하시오 :");
		String name;
		name=in.nextLine();
		
		try {
			ppst = conn.prepareStatement("select * from member1 where name=?");
			ppst.setString(1,name);
			rs= ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<memberDTO>();
				int i=0;
				do {
					memberDTO dto = new memberDTO();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					dto.setGender(rs.getString("gender"));
					dto.setJob(rs.getString("job"));
					memberDTOList.add(dto);
					System.out.print(memberDTOList.get(i).getId()+"번 고객"+memberDTOList.get(i).getName()+"\t"+memberDTOList.get(i).getAge()
							+"\t"+memberDTOList.get(i).getGender()+"\t"+memberDTOList.get(i).getJob()+"\n");
					
					i++;
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
	
}
