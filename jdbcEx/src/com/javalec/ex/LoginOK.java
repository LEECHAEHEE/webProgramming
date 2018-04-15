package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOK
 */
@WebServlet("/LoginOK")
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String uid = "scott", upw="tiger";
	String id,pw,iid, ipw, name;
	String sql;  
	ResultSet rs;
	Connection conn;
	Statement stmt;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		iid = request.getParameter("id");
		ipw = request.getParameter("pw");

		sql = "select name from member where id='" + iid +"' and pw='" + ipw + "'";
		System.out.println(sql);
		request.setCharacterEncoding("EUC-KR");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(sql);
			if(rs==null) {
				System.out.println("login error!");
				response.sendRedirect("login.jsp");
			}
			while(rs.next()) {
				name = rs.getString("name");
			}
			
			HttpSession hs = request.getSession();
			hs.setAttribute("name", name);
			hs.setAttribute("id", id);
			hs.setAttribute("pw", pw);
				
			response.sendRedirect("loginResult.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
