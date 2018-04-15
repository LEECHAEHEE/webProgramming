package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOK
 */
@WebServlet("/JoinOK")
public class JoinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * insert into member values('name', 'id', 'pw', 'phone1', 'phone2', 'phone3', 'gender');
	 */
	String uid = "scott", upw="tiger";
	String id, pw, name, phone1, phone2, phone3, gender;
	String sql;  
	
	Connection conn;
	Statement stmt;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOK() {
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
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws SaslException, IOException{
		request.setCharacterEncoding("EUC-KR");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
	
		sql =  "insert into member values('" + name + "','" + id + "','" + pw + "','" + phone1 + "','" + phone2 + "','" + phone3 + "','" + gender + "')";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if(i==1) {
				System.out.println("SIGN IN SUCESS");
				response.sendRedirect("joinResult.jsp");
			}else {
				System.out.println("SIGN IN FALIED");
				response.sendRedirect("join.jsp");
			}
				
		}catch(Exception e){
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
