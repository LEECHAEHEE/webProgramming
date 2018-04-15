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
 * Servlet implementation class LoginOk
 */
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String u_id ="scott", u_pw="tiger";
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name="";
		/* 
		 * select name from member where id = 'id' and pw ='pw'; 
		 */
		String sql = "select name from member where id = '" + id + "' and pw ='" + pw + "'";
		System.out.println(sql);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u_id, u_pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				name = rs.getString("name"); 
			}
			
			if(name.equals("")) {
				System.out.println("login failed");
			}else {
				System.out.println("LoginOK");
				
				HttpSession hs = request.getSession();
				hs.setAttribute("id", id);
				hs.setAttribute("pw", pw);
				hs.setAttribute("name", name);
				
				response.sendRedirect("loginResult.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
	}
}
