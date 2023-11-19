package com.sist.dao;
import java.sql.*;
import java.sql.Date;
import java.util.*;
public class bookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	bookDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void InsertBookData(bookVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO BOOKINFO VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getBookTitle());
			ps.setString(3, vo.getBookAuthor());
			ps.setString(4, vo.getBookPublisher());
			ps.setString(5, vo.getBookType());
			ps.setString(6, vo.getBookPerson());
			ps.setString(7, vo.getBookSign());
			ps.setDate(8, Date.valueOf(vo.getBookDate()));
			ps.setString(9, vo.getBookAccessionno());
			ps.setString(10, vo.getBookCallnum());
			ps.setString(11, vo.getBookLocation());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
}
