package com.sist.main;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.dao.*;
//String bookDtype=""; // 자료유형
//String bookPerson=""; // 개인저자
//String bookSign=""; // 서명
//String bookPublisher=""; // 출판사
//String bookDate=""; // 발행연도
//String bookISBN=""; // 고유번호
//String bookAccessionNo=""; // 등록번호
//String bookCallNum=""; // 청구기호
//String bookLocation=""; // 자료실/서가
//a[0]|a[1]|ISBN|제목|저자|bookDtype|bookPerson|bookSign|bookPublisher|bookDate
public class MainClass {
	FileReader fr = null;
	MainClass(){
		try {
			bookVO vo = null;
			bookDAO dao = new bookDAO();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
			fr = new FileReader("C:\\OracleDev\\bookVO.txt");
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			String[] data = sb.toString().split("\n");
			for(String dd:data) {
				vo = new bookVO();
				String[] dt = dd.split("\\|");
				vo.setIsbn(dt[2]);
				vo.setBookTitle(dt[3]);
				vo.setBookAuthor(dt[4]);
				vo.setBookType(dt[5]);
				vo.setBookPerson(dt[6]);
				vo.setBookSign(dt[7]);
				vo.setBookPublisher(dt[8]);
				vo.setBookDate(dt[9]);
				vo.setBookAccessionno(dt[10]);
				vo.setBookCallnum(dt[11]);
				vo.setBookLocation(dt[12]);
				
				dao.InsertBookData(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new MainClass();
		bookDAO dao = new bookDAO();
		ArrayList<middlectVO> vo = dao.SearchBookisbn();
		for(middlectVO dd:vo) {
			System.out.println(dd.getCate()+" "+dd.getCno()+" "+dd.getMno());
		}
	}

}
