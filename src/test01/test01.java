package test01;

import java.sql.*;

public class test01 {
	static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	static String USER = "web5";
	static String PASSWORD = "0910";

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int res = 0;

		try {		
			Class.forName(DRIVER);
			System.out.println("JDBC 드라이버 로드 성공");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("데이터베이스 연결 성공");
			
			sql = "insert into tbl_department values(seq_department.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "컴퓨터공학");
			res = pstmt.executeUpdate();
			pstmt.setString(1, "인공지능학");
			res = pstmt.executeUpdate();
			pstmt.setString(1, "정보보호학");
			res = pstmt.executeUpdate();

			pstmt = con.prepareStatement("insert into tbl_address values(seq_address.nextval, ?, ?, ?)");

			pstmt.setInt(1, 12345);
			pstmt.setString(2, "123 서울시 강남구");
			pstmt.setString(3, "아파트 101");
			res = pstmt.executeUpdate();
			
			pstmt.setInt(1, 45678);
			pstmt.setString(2, "456 서울시 동작구");
			pstmt.setString(3, "빌라 202");
			res = pstmt.executeUpdate();
			
			pstmt.setInt(1, 56789);
			pstmt.setString(2, "789 서울시 송파구");
			pstmt.setString(3, "주택 305");
			res = pstmt.executeUpdate();
			
			pstmt= con.prepareStatement("insert into tbl_student values(seq_student.nextval, ?, ?, ?, ?)");
			
			pstmt.setString(1, "짱구");
			pstmt.setInt(2, 22);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			res = pstmt.executeUpdate();
			
			pstmt.setString(1, "철수");
			pstmt.setInt(2, 21);
			pstmt.setInt(3, 2);
			pstmt.setInt(4, 2);
			res = pstmt.executeUpdate();
			
			pstmt.setString(1, "맹구");
			pstmt.setInt(2, 20);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			res = pstmt.executeUpdate();
			
			pstmt.setString(1, "유리");
			pstmt.setInt(2, 22);
			pstmt.setInt(3, 3);
			pstmt.setInt(4, 3);
			res = pstmt.executeUpdate();
			
			System.out.println("입력 완료");
			
		} catch (SQLException se) {
			System.out.println("연결 실패");
		} catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException se){};
				try {
					con.close();
				} catch (SQLException se){};
			}
		}
		
		test01_1();
		System.out.println("===");
		test01_2();
		System.out.println("===");
		test01_3();
		System.out.println("===");
		test01_4();
	}
	
	public static void test01_1(){
		ResultSet rset = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt=con.prepareStatement("SELECT STUDENT_ID , STUDENT_NAME , department_name, ADDRESS_POSTAL_CODE , ADDRESS_LINE1 ,ADDRESS_LINE2 \r\n"
					+ "FROM TBL_STUDENT ts \r\n"
					+ "JOIN TBL_DEPARTMENT td \r\n"
					+ "ON ts.DEPARTMENT_ID = td.DEPARTMENT_ID \r\n"
					+ "JOIN TBL_ADDRESS ta \r\n"
					+ "ON ts.ADDRESS_ID = ta.ADDRESS_ID");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + " " +rset.getString(3)
				+ " "+rset.getInt(4)+" " +rset.getString(5)+" " + rset.getString(6));
			}
		
		}catch (SQLException se){
			System.out.println("test01_1 연결실패");
		}catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException se){};
				try {
					con.close();
				} catch (SQLException se){};
			}
		}
		
	}
	
	public static void test01_2() {
		ResultSet rset = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt=con.prepareStatement("SELECT student_name, department_name\r\n"
					+ "FROM TBL_STUDENT ts \r\n"
					+ "JOIN TBL_DEPARTMENT td\r\n"
					+ "ON ts.DEPARTMENT_ID = td.DEPARTMENT_ID\r\n"
					+ "WHERE student_age=22");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getString(2));
			}
		
		}catch (SQLException se){
			System.out.println("test01_2 연결실패");
		}catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException se){};
				try {
					con.close();
				} catch (SQLException se){};
			}
		}
	}
	
	public static void test01_3() {
		ResultSet rset = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt=con.prepareStatement("SELECT student_name, department_name\r\n"
					+ "FROM TBL_STUDENT ts \r\n"
					+ "JOIN TBL_DEPARTMENT td \r\n"
					+ "ON ts.DEPARTMENT_ID = td.DEPARTMENT_ID \r\n"
					+ "JOIN TBL_ADDRESS ta \r\n"
					+ "ON ts.ADDRESS_ID = ta.ADDRESS_ID \r\n"
					+ "WHERE ADDRESS_LINE1 LIKE '%서울시 강남구%'");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getString(2));
			}
		
		}catch (SQLException se){
			System.out.println("test01_3 연결실패");
		}catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException se){};
				try {
					con.close();
				} catch (SQLException se){};
			}
		}
	}
	
	public static void test01_4() {
		ResultSet rset = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt=con.prepareStatement("UPDATE TBL_STUDENT \r\n"
					+ "SET ADDRESS_ID =3\r\n"
					+ "WHERE STUDENT_NAME = '맹구'");
			rset = pstmt.executeQuery();
			
			System.out.println("업데이트 완료");
		
		}catch (SQLException se){
			System.out.println("test01_4 연결실패");
		}catch (Exception e) {
			System.out.println("오류 발생");
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException se){};
				try {
					con.close();
				} catch (SQLException se){};
			}
		}
	}

}
