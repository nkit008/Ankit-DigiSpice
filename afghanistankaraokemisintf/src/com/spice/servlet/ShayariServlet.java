package com.spice.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShayariServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		if(session != null) {
			session.invalidate();
			session = request.getSession();
		} else {
			session = request.getSession();
		}
		System.out.println("Shayari Service Servlet Called........");	
		
			RequestDispatcher view = request.getRequestDispatcher("/shayari.jsp");
			view.forward(request, response);
		
	}

}
