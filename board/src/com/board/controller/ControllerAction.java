package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet{
	private Map commandMap = new HashMap();
	public void init(ServletConfig config) throws ServletException{
		loadProperties("com/board/properties/Command");
	}
	
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while(actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement();
			;
			String className = rbHome.getString(command);
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				
				commandMap.put(command,commandInstance);
			}catch(ClassNotFoundException e) { 
				continue;
			}catch(InstantiationException e) {
				e.printStackTrace();
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		CommandAction com = null;
		try {
			String command = request.getRequestURI();
			System.out.println("line 50 command : " + command);
			if(command.indexOf(request.getContextPath())==0) {
				command = command.substring(request.getContextPath().length());
				System.out.println("line 53 command : " + command);
			}
			com = (CommandAction) commandMap.get(command);
			System.out.println("line 56 com : " + com);
			
			if(com == null) {
				System.out.println("not found : " + command);
				return;
			}
			view = com.requestPro(request, response);
			if(view==null) {
				return;
			}
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
}