package com.spice.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		if(session != null) {
			session.invalidate();
			session = request.getSession();
		} else {
			session = request.getSession();
		}
		System.out.println("Login Servlet Called........");
		String mob = request.getParameter("mobile");
		String pass = request.getParameter("password");
		String method = request.getParameter("method");
		System.out.println("Username ....."+mob);
		System.out.println("Password ....."+pass);
		System.out.println("method ....."+method);
		if(method != null) {
			if(method.equalsIgnoreCase("home")) {
				RequestDispatcher view = request.getRequestDispatcher("/homeAwcc.jsp");
				view.forward(request, response);
			}
		}
		else {
			if(mob.equals("admin") && pass.equals("admin")) {
				System.out.println("Login Successfully");
				
				RequestDispatcher view = request.getRequestDispatcher("/homeAwcc.jsp");
				request.setAttribute("accesspage", "awcc");
				session.setAttribute("mapdata", null);
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				view.forward(request, response);
			}
		}
	}
}
