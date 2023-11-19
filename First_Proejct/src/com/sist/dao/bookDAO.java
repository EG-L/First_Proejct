package com.sist.dao;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
public class bookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.119:1521:XE";
	public bookDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void InsertBookData(bookVO vo) {
		try {
			
			getConnection();
			String sql = "INSERT INTO BOOKINFO VALUES(?,?,?,?,?,?,?,TO_DATE(?,'yyyy'),?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getBookTitle());
			ps.setString(3, vo.getBookAuthor());
			ps.setString(4, vo.getBookPublisher());
			ps.setString(5, vo.getBookType());
			ps.setString(6, vo.getBookPerson());
			ps.setString(7, vo.getBookSign());
			ps.setString(8, vo.getBookDate());
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
	
	public ArrayList<middlectVO> SearchBookisbn(){
		ArrayList<middlectVO> list = new ArrayList<middlectVO>();
		try {
			getConnection();
			String sql = "SELECT mno,cate,cno "+"FROM middlect";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				middlectVO vo = new middlectVO();
				vo.setMno(rs.getString(1));
				vo.setCate(rs.getString(2));
				vo.setCno(rs.getInt(3));
				
				list.add(vo);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			disConnection();
		}
		return list;
	}
}
