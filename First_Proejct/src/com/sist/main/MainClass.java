package com.sist.main;
import java.io.FileReader;
import java.util.*;
import com.sist.dao.*;

public class MainClass {
	FileReader fr = null;
	MainClass(){
		try {
			bookVO vo = null;
			fr = new FileReader("C:\\OracleDev\\bookVO.txt");
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			String[] data = sb.toString().split("\n");
			int count = 0;
			for(String dd:data) {
				vo = new bookVO();
				String[] dt = dd.split("\\|");
				vo.setIsbn(dt[0]);
				vo.setBookTitle(dt[1]);
				vo.setBookAuthor(dt[2]);
				vo.setBookPublisher(dt[3]);
				vo.setBookType(dt[4]);
				vo.setBookPerson(dt[5]);
				vo.setBookSign(dt[6]);
				vo.setBookDate(dt[7]);
				vo.setBookAccessionno(dt[8]);
				vo.setBookCallnum(dt[9]);
				vo.setBookLocation(dt[10]);
				count++;
			}
			System.out.println(count);
		} catch (Exception e) {
			// TODO: handle exception
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
		new MainClass();
	}

}
