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
 * Servlet implementation class ModifyOK
 */
@WebServlet("/ModifyOK")
public class ModifyOK extends HttpServlet {
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
    public ModifyOK() {
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
		iid = request.getParameter("id");
		ipw = request.getParameter("pw");
		/*
		 * update member set name='name' id='id'
		 */
		sql = "update member set name=
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
