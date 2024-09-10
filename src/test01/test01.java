package test01;

import java.sql.*;

public class test01 {
	static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	static String USER = "web5";
	static String PASSWORD = "0910";

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName(DRIVER);
			System.out.println("JDBC 드라이버 로드 성공");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("데이터베이스 연결 성공");
			stmt = con.createStatement();

		} catch (SQLException se) {
			System.out.println("연결 실패");
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
		
	}
}
