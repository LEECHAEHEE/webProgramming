package com.board.action;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;


public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try{
			/*String driverName = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			ResultSet rs = null;
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url,"board","board");
			System.out.println("Connection Successful");
			
			Statement stmt = conn.createStatement();
			String sql = "select * from board order by idx desc";
			rs = stmt.executeQuery(sql);
			
			ArrayList<Board> articleList = new ArrayList<Board>();
			
			 while(rs.next()){
					Board article = new Board();
					article.setIdx(rs.getInt("idx"));
					article.setTitle(rs.getString("title"));
					article.setWriter(rs.getString("writer"));
					article.setRegdate(rs.getString("regdate"));
					article.setCount(rs.getInt("count"));
					articleList.add(article);
				} */
			 
			BoardDao dao = BoardDao.getInstance();
			ArrayList<Board> articleList = new ArrayList<Board>();
			articleList = dao.getArticleList();
			
			 request.setAttribute("articleList", articleList); //셋팅된 리스트를 뷰에 포워딩 한다.
			 
			 
			//conn.close();
		}catch(Exception e){
			System.out.println("Connection Failed");
			System.out.println(e.getMessage());
			e.printStackTrace();
	}
		return "list.jsp";
	}

}
