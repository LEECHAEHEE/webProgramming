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

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
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
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String u_id ="scott", u_pw="tiger";
	
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");

		/* 
		 * insert into member values('name', 'id', 'pw', 'gender', 'phone1', 'phone2', 'phone3'); 
		 */
		String sql = "insert into member values('" + name + "','" + id + "','" + pw + "','" +gender+ "','" +phone1+ "','" +phone2+ "','" +phone3 +"')"; 
		System.out.println(sql);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u_id, u_pw);
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			
			if(i==1) {
				System.out.println("join OK");
				response.sendRedirect("joinResult.jsp");
			}else {
				System.out.println("FAILED");
				response.sendRedirect("join.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
	}

}
