package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private Statement stmt= null;
	
	private final String driver = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String u_id ="scott", u_pw="tiger";
	
	private String id, name, pw, gender, phone1, phone2, phone3;
	
	HttpSession hs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
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
		hs = request.getSession();
		id = (String)hs.getAttribute("id");
		
		name = request.getParameter("name");
		pw = request.getParameter("pw");
		gender = request.getParameter("gender");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		
		/* 
		 * update member set name='name', pw='pw', gender='gender', phone1='phone1', phone2='phone2', phone3='phone3' where id = 'id'; 
		 */
		if(pwConfirm()) {
			String sql = "update member set name='" + name + "', pw='" + pw + "', gender='" + gender + "', phone1='" + phone1 + "', phone2='" + phone2 + "', phone3='" + phone3 + "' where id='" + id + "'";
			System.out.println(sql);
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, u_id, u_pw);
				stmt = conn.createStatement();
				int i = stmt.executeUpdate(sql);
				
				if(i ==1) {
					System.out.println("update completed");
					
					hs.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				}else {
					System.out.println("update failed");
					response.sendRedirect("modify.jsp");
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
		}else {
			System.out.println("ng");
		}
	}
	
	private boolean pwConfirm() {
		boolean b = false;
		String sessionPw = (String)hs.getAttribute("pw");
		if(sessionPw.equals(pw)) {
			b = true;
		}
		return b;
	}
}
